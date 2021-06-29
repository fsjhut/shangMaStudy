## day15_6_26 excel和word

###  1. excel的操作

在项目中做数据的导入和导出

导出：将根据条件查询到的数据导出到Excel表格。

导入：在产品刚上线的时候，将客户的Excel文件导入到数据库中，在数据入库中的过程中，切记校验数据的重复，切记把失败的数据记录返回给操作人员。

Excel操作的工具：第三方的组件库，POI，ali-easyexcel, hutool-excelUtil

其中POI是原生的组件，其他的是对POI进行封装。

* 在项目中加入poi的依赖库
* 读取Excel

### 2. Word的写操作

```java
/**
 * @author kl by 2016/6/25
 * @boke www.kailing.pub
 */
public class MutilThreadTask {
    public static void main(String[] args) {
        List<Object> list = new ArrayList();
        for (int i = 0; i < 8014; i++) {
            list.add(i + "test.png");
        }
        new MutilThreadTask().handleListMutiSchedule(list,5);
    }
    //多线程并行处理list数据集
    public void handleListMutiSchedule(List list,int taskCount){
        System.out.println("begin====================================");
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(taskCount);
        int start = 0;
        int listSize=list.size();
        int remainder=listSize%taskCount;
        int taskDataSize = listSize/taskCount;
        //平均分配task任务
        for(int i=0;i<taskCount;i++,start+=taskDataSize){
            int end = start + taskDataSize;
            //最后如果有分配不均的，多余部分交给最后一个任务处理
            if(i==taskCount-1){
                if(remainder!=0){
                    end=listSize;
                }
            }
             executorService.schedule(new Task(list,start,end),0,TimeUnit.SECONDS);
        }

    }
    //多线程并行处理list数据集
    public void handleListMutiThread(List list,int taskCount){
        int start = 0;
        ExecutorService ex = Executors.newFixedThreadPool(taskCount);
        int listSize=list.size();
        int remainder=listSize%taskCount;
        int taskDataSize = listSize/taskCount;
        List<Future> futures = new ArrayList(taskCount);
        //平均分配task任务
        for(int i=0;i<taskCount;i++,start+=taskDataSize){
            int end = start + taskDataSize;
            //最后如果有分配不均的，多余部分交给最后一个任务处理
            if(i==taskCount-1){
                if(remainder!=0){
                    end=listSize;
                }
            }
            Future future=ex.submit(new Task(list,start,end)) ;
            futures.add(future);
        }
        try {
            //处理
            for(Future future : futures){
              Object listsf=  future.get();
            }
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Task任务执行单元
     */
    private class Task implements Callable<List<Object>> {
        private List<Object> list;
        private int start;
        private int end;
        public Task(List<Object> list,int start,int end){
            this.list = list;
            this.start = start;
            this.end = end;
        }
        @Override
        public List<Object> call() throws Exception {
            Object obj = null;
            List<Object> retList = new ArrayList();
            for(int i=start;i<end;i++){
                obj = list.get(i);
                Thread.sleep(10);//
                System.out.println(Thread.currentThread()+"当前处理："+obj);
            //    System.out.println(UfileUtil.uploadUFile(obj.toString(),new FileInputStream("E:\\test.png")));
            }
            //返回处理结果
            return retList;
        }
    }
}
```



### 3. fastds分布式文件存储

#### fastdfs的作用

 一旦引入了tomcat集群后，用户上传的文件，将不能tomcat根路径下

需要引入独立的服务器来存储文件,文件服务器支持集群环境(分布式部署)

文件存储服务器：

fastdfs：适合存储中小型文件的服务器（100m以下）

hdfs:大数据开发（数据分析）用的文件服务器

云文件(对象)存储：应用在互联网项目中

#### fastdfs：服务器中的架构思想

nginx：是单线程应用，不做任何多余操作，相当于中转站，负责请求的分发。

横向扩展：服务器不停止，应用正常使用，进行扩展

文件存储服务器：跟踪服务器+存储服务器1+存储服务器2

跟踪服务器(TrackerServer)安装==跟踪端服务器程序==：管理所有的存储服务器的地址与状态信息，与应用服务器tomcat做对接。

存储服务器(StorageServer)组（每组有两台机器）安装==存储端程序，设置跟踪服务器地址==，每个存储服务器都有一个备份机，保证数据的安全。当主存储没有发送心跳包，则切换到备份的服务器，保证高可用性。

存储服务器发送==心跳包==给跟踪服务器，因此跟踪服务器知道所有存储服务器的所有ip、端口、状态信息。

**客户端**：当用户上传文件时，首先连接跟踪服务器，返回一个空闲可用的存储服务器信息，客户端通过api把文件存储到具体的这个存储服务器，存储成功后，返回存储路径字符串，(/group1/aa/bb/xxxxx.docx)

用户上传文件时：连接TrackerServer，把存储路径传给TrackerServer,返回客户端，group1的存储服务器信息。客户端通过api去具体的存储服务器下载文件。

#### api的使用

* 引入fastdfs的依赖包
* 配置fastdfs的配置文件
* 初始化TrackerClient对象
* 打开TracderServer连接
* 初始化StorageClient1对象
* 进行文件上传操作，上传操作的内部会打开StorageServer连接

为了上传的图片能够进行预览显示，因此需要在nginx中部署了一个静态服务器，可以用来访问图片。

