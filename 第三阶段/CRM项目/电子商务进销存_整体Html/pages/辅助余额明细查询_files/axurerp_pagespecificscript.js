
var PageName = '辅助余额明细查询';
var PageId = 'pe3ca522f3c384afe87088143c7908c25'
var PageUrl = '辅助余额明细查询.html'
document.title = '辅助余额明细查询';

if (top.location != self.location)
{
	if (parent.HandleMainFrameChanged) {
		parent.HandleMainFrameChanged();
	}
}

var $OnLoadVariable = '';

var $CSUM;

var hasQuery = false;
var query = window.location.hash.substring(1);
if (query.length > 0) hasQuery = true;
var vars = query.split("&");
for (var i = 0; i < vars.length; i++) {
    var pair = vars[i].split("=");
    if (pair[0].length > 0) eval("$" + pair[0] + " = decodeURIComponent(pair[1]);");
} 

if (hasQuery && $CSUM != 1) {
alert('Prototype Warning: The variable values were too long to pass to this page.\nIf you are using IE, using Firefox will support more data.');
}

function GetQuerystring() {
    return '#OnLoadVariable=' + encodeURIComponent($OnLoadVariable) + '&CSUM=1';
}

function PopulateVariables(value) {
  value = value.replace(/\[\[OnLoadVariable\]\]/g, $OnLoadVariable);
  value = value.replace(/\[\[PageName\]\]/g, PageName);
  return value;
}

function OnLoad(e) {

}

var u289 = document.getElementById('u289');

var u733 = document.getElementById('u733');

u733.style.cursor = 'pointer';
if (bIE) u733.attachEvent("onclick", Clicku733);
else u733.addEventListener("click", Clicku733, true);
function Clicku733(e)
{

if (true) {

	self.location.href="出库单审核.html" + GetQuerystring();

}

}

var u233 = document.getElementById('u233');

var u381 = document.getElementById('u381');

var u881 = document.getElementById('u881');

var u691 = document.getElementById('u691');

u691.style.cursor = 'pointer';
if (bIE) u691.attachEvent("onclick", Clicku691);
else u691.addEventListener("click", Clicku691, true);
function Clicku691(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u199 = document.getElementById('u199');

var u143 = document.getElementById('u143');

var u453 = document.getElementById('u453');

u453.style.cursor = 'pointer';
if (bIE) u453.attachEvent("onclick", Clicku453);
else u453.addEventListener("click", Clicku453, true);
function Clicku453(e)
{

if (true) {

	self.location.href="调拨要货单管理.html" + GetQuerystring();

}

}

var u363 = document.getElementById('u363');

var u202 = document.getElementById('u202');
gv_vAlignTable['u202'] = 'center';
var u512 = document.getElementById('u512');
gv_vAlignTable['u512'] = 'top';
var u273 = document.getElementById('u273');

var u28 = document.getElementById('u28');
gv_vAlignTable['u28'] = 'center';
var u126 = document.getElementById('u126');
gv_vAlignTable['u126'] = 'center';
var u648 = document.getElementById('u648');
gv_vAlignTable['u648'] = 'top';
var u510 = document.getElementById('u510');
gv_vAlignTable['u510'] = 'top';
var u388 = document.getElementById('u388');
gv_vAlignTable['u388'] = 'center';
var u888 = document.getElementById('u888');

var u780 = document.getElementById('u780');
gv_vAlignTable['u780'] = 'center';
var u332 = document.getElementById('u332');
gv_vAlignTable['u332'] = 'center';
var u832 = document.getElementById('u832');

var u184 = document.getElementById('u184');
gv_vAlignTable['u184'] = 'center';
var u790 = document.getElementById('u790');

var u298 = document.getElementById('u298');
gv_vAlignTable['u298'] = 'center';
var u242 = document.getElementById('u242');
gv_vAlignTable['u242'] = 'center';
var u552 = document.getElementById('u552');
gv_vAlignTable['u552'] = 'top';
var u391 = document.getElementById('u391');

var u328 = document.getElementById('u328');
gv_vAlignTable['u328'] = 'center';
var u209 = document.getElementById('u209');

var u118 = document.getElementById('u118');
gv_vAlignTable['u118'] = 'center';
var u702 = document.getElementById('u702');
gv_vAlignTable['u702'] = 'top';
var u462 = document.getElementById('u462');
gv_vAlignTable['u462'] = 'top';
var u301 = document.getElementById('u301');

var u801 = document.getElementById('u801');

u801.style.cursor = 'pointer';
if (bIE) u801.attachEvent("onclick", Clicku801);
else u801.addEventListener("click", Clicku801, true);
function Clicku801(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u611 = document.getElementById('u611');

u611.style.cursor = 'pointer';
if (bIE) u611.attachEvent("onclick", Clicku611);
else u611.addEventListener("click", Clicku611, true);
function Clicku611(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u378 = document.getElementById('u378');
gv_vAlignTable['u378'] = 'center';
var u429 = document.getElementById('u429');

u429.style.cursor = 'pointer';
if (bIE) u429.attachEvent("onclick", Clicku429);
else u429.addEventListener("click", Clicku429, true);
function Clicku429(e)
{

if (true) {

	self.location.href="系统管理.html" + GetQuerystring();

}

}

var u814 = document.getElementById('u814');

var u372 = document.getElementById('u372');
gv_vAlignTable['u372'] = 'center';
var u872 = document.getElementById('u872');
gv_vAlignTable['u872'] = 'center';
var u225 = document.getElementById('u225');

var u339 = document.getElementById('u339');

var u839 = document.getElementById('u839');

u839.style.cursor = 'pointer';
if (bIE) u839.attachEvent("onclick", Clicku839);
else u839.addEventListener("click", Clicku839, true);
function Clicku839(e)
{

if (true) {

	self.location.href="凭证管理.html" + GetQuerystring();

}

}

var u135 = document.getElementById('u135');

var u741 = document.getElementById('u741');

var u249 = document.getElementById('u249');

var u283 = document.getElementById('u283');

var u840 = document.getElementById('u840');

var u20 = document.getElementById('u20');
gv_vAlignTable['u20'] = 'center';
var u651 = document.getElementById('u651');

var u159 = document.getElementById('u159');

var u193 = document.getElementById('u193');

var u469 = document.getElementById('u469');

var u308 = document.getElementById('u308');
gv_vAlignTable['u308'] = 'center';
var u808 = document.getElementById('u808');

var u11 = document.getElementById('u11');

var u464 = document.getElementById('u464');
gv_vAlignTable['u464'] = 'top';
var u265 = document.getElementById('u265');

var u104 = document.getElementById('u104');
gv_vAlignTable['u104'] = 'center';
var u710 = document.getElementById('u710');
gv_vAlignTable['u710'] = 'top';
var u218 = document.getElementById('u218');
gv_vAlignTable['u218'] = 'center';
var u402 = document.getElementById('u402');
gv_vAlignTable['u402'] = 'center';
var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'center';
var u9 = document.getElementById('u9');

var u533 = document.getElementById('u533');

u533.style.cursor = 'pointer';
if (bIE) u533.attachEvent("onclick", Clicku533);
else u533.addEventListener("click", Clicku533, true);
function Clicku533(e)
{

if (true) {

	self.location.href="充值订单管理.html" + GetQuerystring();

}

}

var u83 = document.getElementById('u83');

var u175 = document.getElementById('u175');

var u620 = document.getElementById('u620');
gv_vAlignTable['u620'] = 'top';
var u824 = document.getElementById('u824');

var u438 = document.getElementById('u438');
gv_vAlignTable['u438'] = 'top';
var u24 = document.getElementById('u24');
gv_vAlignTable['u24'] = 'center';
var u530 = document.getElementById('u530');
gv_vAlignTable['u530'] = 'top';
var u348 = document.getElementById('u348');
gv_vAlignTable['u348'] = 'center';
var u382 = document.getElementById('u382');
gv_vAlignTable['u382'] = 'center';
var u658 = document.getElementById('u658');
gv_vAlignTable['u658'] = 'top';
var u15 = document.getElementById('u15');

var u46 = document.getElementById('u46');
gv_vAlignTable['u46'] = 'center';
var u96 = document.getElementById('u96');
gv_vAlignTable['u96'] = 'center';
var u144 = document.getElementById('u144');
gv_vAlignTable['u144'] = 'center';
var u454 = document.getElementById('u454');
gv_vAlignTable['u454'] = 'top';
var u292 = document.getElementById('u292');
gv_vAlignTable['u292'] = 'center';
var u568 = document.getElementById('u568');
gv_vAlignTable['u568'] = 'top';
var u379 = document.getElementById('u379');

var u866 = document.getElementById('u866');

var u37 = document.getElementById('u37');

var u87 = document.getElementById('u87');

var u254 = document.getElementById('u254');
gv_vAlignTable['u254'] = 'center';
var u364 = document.getElementById('u364');
gv_vAlignTable['u364'] = 'center';
var u203 = document.getElementById('u203');

var u478 = document.getElementById('u478');
gv_vAlignTable['u478'] = 'top';
var u570 = document.getElementById('u570');

var u423 = document.getElementById('u423');

var u850 = document.getElementById('u850');
gv_vAlignTable['u850'] = 'center';
var u389 = document.getElementById('u389');

var u889 = document.getElementById('u889');

var u428 = document.getElementById('u428');
gv_vAlignTable['u428'] = 'top';
var u333 = document.getElementById('u333');

var u19 = document.getElementById('u19');

var u185 = document.getElementById('u185');

var u386 = document.getElementById('u386');
gv_vAlignTable['u386'] = 'center';
var u791 = document.getElementById('u791');
gv_vAlignTable['u791'] = 'center';
var u299 = document.getElementById('u299');

var u502 = document.getElementById('u502');
gv_vAlignTable['u502'] = 'top';
var u243 = document.getElementById('u243');

var u553 = document.getElementById('u553');

u553.style.cursor = 'pointer';
if (bIE) u553.attachEvent("onclick", Clicku553);
else u553.addEventListener("click", Clicku553, true);
function Clicku553(e)
{

if (true) {

	self.location.href="发货状态管理.html" + GetQuerystring();

}

}

var u463 = document.getElementById('u463');

u463.style.cursor = 'pointer';
if (bIE) u463.attachEvent("onclick", Clicku463);
else u463.addEventListener("click", Clicku463, true);
function Clicku463(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u302 = document.getElementById('u302');
gv_vAlignTable['u302'] = 'center';
var u802 = document.getElementById('u802');

var u612 = document.getElementById('u612');
gv_vAlignTable['u612'] = 'top';
var u373 = document.getElementById('u373');

var u38 = document.getElementById('u38');
gv_vAlignTable['u38'] = 'center';
var u88 = document.getElementById('u88');
gv_vAlignTable['u88'] = 'center';
var u226 = document.getElementById('u226');
gv_vAlignTable['u226'] = 'center';
var u354 = document.getElementById('u354');
gv_vAlignTable['u354'] = 'center';
var u488 = document.getElementById('u488');
gv_vAlignTable['u488'] = 'top';
var u29 = document.getElementById('u29');

var u432 = document.getElementById('u432');
gv_vAlignTable['u432'] = 'top';
var u480 = document.getElementById('u480');
gv_vAlignTable['u480'] = 'top';
var u580 = document.getElementById('u580');
gv_vAlignTable['u580'] = 'top';
var u398 = document.getElementById('u398');
gv_vAlignTable['u398'] = 'center';
var u876 = document.getElementById('u876');
gv_vAlignTable['u876'] = 'top';
var u342 = document.getElementById('u342');
gv_vAlignTable['u342'] = 'center';
var u842 = document.getElementById('u842');

u842.style.cursor = 'pointer';
if (bIE) u842.attachEvent("onclick", Clicku842);
else u842.addEventListener("click", Clicku842, true);
function Clicku842(e)
{

if (true) {

	self.location.href="账簿查询.html" + GetQuerystring();

}

}

var u652 = document.getElementById('u652');

var u194 = document.getElementById('u194');
gv_vAlignTable['u194'] = 'center';
var u309 = document.getElementById('u309');

var u809 = document.getElementById('u809');
gv_vAlignTable['u809'] = 'center';
var u749 = document.getElementById('u749');

u749.style.cursor = 'pointer';
if (bIE) u749.attachEvent("onclick", Clicku749);
else u749.addEventListener("click", Clicku749, true);
function Clicku749(e)
{

if (true) {

	self.location.href="还机入库.html" + GetQuerystring();

}

}

var u562 = document.getElementById('u562');
gv_vAlignTable['u562'] = 'top';
var u105 = document.getElementById('u105');

var u901 = document.getElementById('u901');

u901.style.cursor = 'pointer';
if (bIE) u901.attachEvent("onclick", Clicku901);
else u901.addEventListener("click", Clicku901, true);
function Clicku901(e)
{

if (true) {

	self.location.href="财务单据详情.html" + "";

}

}
gv_vAlignTable['u901'] = 'top';
var u711 = document.getElementById('u711');

var u219 = document.getElementById('u219');

var u529 = document.getElementById('u529');

u529.style.cursor = 'pointer';
if (bIE) u529.attachEvent("onclick", Clicku529);
else u529.addEventListener("click", Clicku529, true);
function Clicku529(e)
{

if (true) {

	self.location.href="B2B出库管理.html" + GetQuerystring();

}

}

var u374 = document.getElementById('u374');
gv_vAlignTable['u374'] = 'center';
var u622 = document.getElementById('u622');
gv_vAlignTable['u622'] = 'top';
var u472 = document.getElementById('u472');
gv_vAlignTable['u472'] = 'top';
var u325 = document.getElementById('u325');

var u825 = document.getElementById('u825');

var u439 = document.getElementById('u439');

u439.style.cursor = 'pointer';
if (bIE) u439.attachEvent("onclick", Clicku439);
else u439.addEventListener("click", Clicku439, true);
function Clicku439(e)
{

if (true) {

	self.location.href="销售报表查询.html" + GetQuerystring();

}

}

var u722 = document.getElementById('u722');
gv_vAlignTable['u722'] = 'top';
var u396 = document.getElementById('u396');
gv_vAlignTable['u396'] = 'center';
var u882 = document.getElementById('u882');

var u235 = document.getElementById('u235');

var u349 = document.getElementById('u349');

var u383 = document.getElementById('u383');

var u883 = document.getElementById('u883');
gv_vAlignTable['u883'] = 'top';
var u763 = document.getElementById('u763');

var u30 = document.getElementById('u30');
gv_vAlignTable['u30'] = 'center';
var u80 = document.getElementById('u80');
gv_vAlignTable['u80'] = 'center';
var u145 = document.getElementById('u145');

var u751 = document.getElementById('u751');

u751.style.cursor = 'pointer';
if (bIE) u751.attachEvent("onclick", Clicku751);
else u751.addEventListener("click", Clicku751, true);
function Clicku751(e)
{

if (true) {

	self.location.href="其他入库[如活动赠品].html" + GetQuerystring();

}

}

var u259 = document.getElementById('u259');

var u293 = document.getElementById('u293');

var u569 = document.getElementById('u569');

var u408 = document.getElementById('u408');
gv_vAlignTable['u408'] = 'top';
var u21 = document.getElementById('u21');

var u661 = document.getElementById('u661');

u661.style.cursor = 'pointer';
if (bIE) u661.attachEvent("onclick", Clicku661);
else u661.addEventListener("click", Clicku661, true);
function Clicku661(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u204 = document.getElementById('u204');
gv_vAlignTable['u204'] = 'center';
var u479 = document.getElementById('u479');

u479.style.cursor = 'pointer';
if (bIE) u479.attachEvent("onclick", Clicku479);
else u479.addEventListener("click", Clicku479, true);
function Clicku479(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u318 = document.getElementById('u318');
gv_vAlignTable['u318'] = 'center';
var u818 = document.getElementById('u818');

var u628 = document.getElementById('u628');
gv_vAlignTable['u628'] = 'top';
var u12 = document.getElementById('u12');
gv_vAlignTable['u12'] = 'center';
var u43 = document.getElementById('u43');

var u93 = document.getElementById('u93');

var u275 = document.getElementById('u275');

var u114 = document.getElementById('u114');
gv_vAlignTable['u114'] = 'center';
var u720 = document.getElementById('u720');
gv_vAlignTable['u720'] = 'top';
var u186 = document.getElementById('u186');
gv_vAlignTable['u186'] = 'center';
var u538 = document.getElementById('u538');
gv_vAlignTable['u538'] = 'top';
var u34 = document.getElementById('u34');
gv_vAlignTable['u34'] = 'center';
var u84 = document.getElementById('u84');
gv_vAlignTable['u84'] = 'center';
var u334 = document.getElementById('u334');
gv_vAlignTable['u334'] = 'center';
var u834 = document.getElementById('u834');

var u448 = document.getElementById('u448');
gv_vAlignTable['u448'] = 'top';
var u482 = document.getElementById('u482');

var u758 = document.getElementById('u758');
gv_vAlignTable['u758'] = 'center';
var u25 = document.getElementById('u25');

var u56 = document.getElementById('u56');
gv_vAlignTable['u56'] = 'center';
var u244 = document.getElementById('u244');
gv_vAlignTable['u244'] = 'center';
var u296 = document.getElementById('u296');
gv_vAlignTable['u296'] = 'center';
var u554 = document.getElementById('u554');
gv_vAlignTable['u554'] = 'top';
var u392 = document.getElementById('u392');
gv_vAlignTable['u392'] = 'center';
var u668 = document.getElementById('u668');
gv_vAlignTable['u668'] = 'top';
var u47 = document.getElementById('u47');

var u97 = document.getElementById('u97');

var u663 = document.getElementById('u663');

u663.style.cursor = 'pointer';
if (bIE) u663.attachEvent("onclick", Clicku663);
else u663.addEventListener("click", Clicku663, true);
function Clicku663(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u760 = document.getElementById('u760');
gv_vAlignTable['u760'] = 'center';
var u303 = document.getElementById('u303');

var u803 = document.getElementById('u803');
gv_vAlignTable['u803'] = 'center';
var u613 = document.getElementById('u613');

var u732 = document.getElementById('u732');
gv_vAlignTable['u732'] = 'top';
var u670 = document.getElementById('u670');
gv_vAlignTable['u670'] = 'top';
var u874 = document.getElementById('u874');

var u523 = document.getElementById('u523');

u523.style.cursor = 'pointer';
if (bIE) u523.attachEvent("onclick", Clicku523);
else u523.addEventListener("click", Clicku523, true);
function Clicku523(e)
{

if (true) {

	self.location.href="B2B预存款管理.html" + GetQuerystring();

}

}

var u489 = document.getElementById('u489');

u489.style.cursor = 'pointer';
if (bIE) u489.attachEvent("onclick", Clicku489);
else u489.addEventListener("click", Clicku489, true);
function Clicku489(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u433 = document.getElementById('u433');

var u581 = document.getElementById('u581');

u581.style.cursor = 'pointer';
if (bIE) u581.attachEvent("onclick", Clicku581);
else u581.addEventListener("click", Clicku581, true);
function Clicku581(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u399 = document.getElementById('u399');

var u892 = document.getElementById('u892');

var u343 = document.getElementById('u343');

var u843 = document.getElementById('u843');

var u653 = document.getElementById('u653');

var u195 = document.getElementById('u195');

var u578 = document.getElementById('u578');

var u267 = document.getElementById('u267');

var u106 = document.getElementById('u106');
gv_vAlignTable['u106'] = 'center';
var u902 = document.getElementById('u902');

u902.style.cursor = 'pointer';
if (bIE) u902.attachEvent("onclick", Clicku902);
else u902.addEventListener("click", Clicku902, true);
function Clicku902(e)
{

if (true) {

	self.location.href="发票详情.html" + "";

}

}
gv_vAlignTable['u902'] = 'top';
var u712 = document.getElementById('u712');
gv_vAlignTable['u712'] = 'top';
var u522 = document.getElementById('u522');
gv_vAlignTable['u522'] = 'top';
var u5 = document.getElementById('u5');

var u177 = document.getElementById('u177');

var u48 = document.getElementById('u48');
gv_vAlignTable['u48'] = 'center';
var u98 = document.getElementById('u98');
gv_vAlignTable['u98'] = 'center';
var u326 = document.getElementById('u326');
gv_vAlignTable['u326'] = 'center';
var u826 = document.getElementById('u826');
gv_vAlignTable['u826'] = 'center';
var u563 = document.getElementById('u563');

u563.style.cursor = 'pointer';
if (bIE) u563.attachEvent("onclick", Clicku563);
else u563.addEventListener("click", Clicku563, true);
function Clicku563(e)
{

if (true) {

	self.location.href="总账管理.html" + GetQuerystring();

}

}

var u588 = document.getElementById('u588');
gv_vAlignTable['u588'] = 'top';
var u39 = document.getElementById('u39');

var u89 = document.getElementById('u89');

var u236 = document.getElementById('u236');
gv_vAlignTable['u236'] = 'center';
var u680 = document.getElementById('u680');
gv_vAlignTable['u680'] = 'top';
var u884 = document.getElementById('u884');

var u498 = document.getElementById('u498');
gv_vAlignTable['u498'] = 'top';
var u701 = document.getElementById('u701');

u701.style.cursor = 'pointer';
if (bIE) u701.attachEvent("onclick", Clicku701);
else u701.addEventListener("click", Clicku701, true);
function Clicku701(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u442 = document.getElementById('u442');
gv_vAlignTable['u442'] = 'top';
var u673 = document.getElementById('u673');

u673.style.cursor = 'pointer';
if (bIE) u673.attachEvent("onclick", Clicku673);
else u673.addEventListener("click", Clicku673, true);
function Clicku673(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u294 = document.getElementById('u294');
gv_vAlignTable['u294'] = 'center';
var u409 = document.getElementById('u409');

var u742 = document.getElementById('u742');

var u662 = document.getElementById('u662');
gv_vAlignTable['u662'] = 'top';
var u205 = document.getElementById('u205');

var u319 = document.getElementById('u319');

var u819 = document.getElementById('u819');
gv_vAlignTable['u819'] = 'center';
var u629 = document.getElementById('u629');

var u276 = document.getElementById('u276');
gv_vAlignTable['u276'] = 'center';
var u115 = document.getElementById('u115');

var u425 = document.getElementById('u425');

u425.style.cursor = 'pointer';
if (bIE) u425.attachEvent("onclick", Clicku425);
else u425.addEventListener("click", Clicku425, true);
function Clicku425(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u539 = document.getElementById('u539');

u539.style.cursor = 'pointer';
if (bIE) u539.attachEvent("onclick", Clicku539);
else u539.addEventListener("click", Clicku539, true);
function Clicku539(e)
{

if (true) {

	self.location.href="订单退款管理.html" + GetQuerystring();

}

}

var u422 = document.getElementById('u422');
gv_vAlignTable['u422'] = 'top';
var u335 = document.getElementById('u335');

var u835 = document.getElementById('u835');
gv_vAlignTable['u835'] = 'center';
var u449 = document.getElementById('u449');

u449.style.cursor = 'pointer';
if (bIE) u449.attachEvent("onclick", Clicku449);
else u449.addEventListener("click", Clicku449, true);
function Clicku449(e)
{

if (true) {

	self.location.href="产品单管理.html" + GetQuerystring();

}

}

var u483 = document.getElementById('u483');

u483.style.cursor = 'pointer';
if (bIE) u483.attachEvent("onclick", Clicku483);
else u483.addEventListener("click", Clicku483, true);
function Clicku483(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u40 = document.getElementById('u40');
gv_vAlignTable['u40'] = 'center';
var u90 = document.getElementById('u90');
gv_vAlignTable['u90'] = 'center';
var u245 = document.getElementById('u245');

var u359 = document.getElementById('u359');

var u393 = document.getElementById('u393');

var u669 = document.getElementById('u669');

u669.style.cursor = 'pointer';
if (bIE) u669.attachEvent("onclick", Clicku669);
else u669.addEventListener("click", Clicku669, true);
function Clicku669(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u508 = document.getElementById('u508');

var u532 = document.getElementById('u532');

var u81 = document.getElementById('u81');

var u155 = document.getElementById('u155');

var u465 = document.getElementById('u465');

u465.style.cursor = 'pointer';
if (bIE) u465.attachEvent("onclick", Clicku465);
else u465.addEventListener("click", Clicku465, true);
function Clicku465(e)
{

if (true) {

	self.location.href="采购退货单管理.html" + GetQuerystring();

}

}

var u304 = document.getElementById('u304');
gv_vAlignTable['u304'] = 'center';
var u804 = document.getElementById('u804');

u804.style.cursor = 'pointer';
if (bIE) u804.attachEvent("onclick", Clicku804);
else u804.addEventListener("click", Clicku804, true);
function Clicku804(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u579 = document.getElementById('u579');

u579.style.cursor = 'pointer';
if (bIE) u579.attachEvent("onclick", Clicku579);
else u579.addEventListener("click", Clicku579, true);
function Clicku579(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u418 = document.getElementById('u418');
gv_vAlignTable['u418'] = 'top';
var u6 = document.getElementById('u6');
gv_vAlignTable['u6'] = 'center';
var u22 = document.getElementById('u22');
gv_vAlignTable['u22'] = 'center';
var u53 = document.getElementById('u53');

var u375 = document.getElementById('u375');

var u214 = document.getElementById('u214');
gv_vAlignTable['u214'] = 'center';
var u524 = document.getElementById('u524');
gv_vAlignTable['u524'] = 'top';
var u638 = document.getElementById('u638');
gv_vAlignTable['u638'] = 'top';
var u44 = document.getElementById('u44');
gv_vAlignTable['u44'] = 'center';
var u94 = document.getElementById('u94');
gv_vAlignTable['u94'] = 'center';
var u434 = document.getElementById('u434');

var u548 = document.getElementById('u548');

var u286 = document.getElementById('u286');
gv_vAlignTable['u286'] = 'center';
var u865 = document.getElementById('u865');

u865.style.cursor = 'pointer';
if (bIE) u865.attachEvent("onclick", Clicku865);
else u865.addEventListener("click", Clicku865, true);
function Clicku865(e)
{

if (true) {

	self.location.href="成本核算管理.html" + GetQuerystring();

}

}

var u35 = document.getElementById('u35');

var u85 = document.getElementById('u85');

var u66 = document.getElementById('u66');
gv_vAlignTable['u66'] = 'center';
var u344 = document.getElementById('u344');
gv_vAlignTable['u344'] = 'center';
var u844 = document.getElementById('u844');
gv_vAlignTable['u844'] = 'center';
var u654 = document.getElementById('u654');
gv_vAlignTable['u654'] = 'top';
var u196 = document.getElementById('u196');
gv_vAlignTable['u196'] = 'center';
var u768 = document.getElementById('u768');

var u57 = document.getElementById('u57');

var u517 = document.getElementById('u517');

u517.style.cursor = 'pointer';
if (bIE) u517.attachEvent("onclick", Clicku517);
else u517.addEventListener("click", Clicku517, true);
function Clicku517(e)
{

if (true) {

	self.location.href="B2B价保审核管理.html" + GetQuerystring();

}

}

var u564 = document.getElementById('u564');
gv_vAlignTable['u564'] = 'top';
var u403 = document.getElementById('u403');

var u903 = document.getElementById('u903');

u903.style.cursor = 'pointer';
if (bIE) u903.attachEvent("onclick", Clicku903);
else u903.addEventListener("click", Clicku903, true);
function Clicku903(e)
{

if (true) {

	self.location.href="凭证详情.html" + GetQuerystring();

}

}
gv_vAlignTable['u903'] = 'top';
var u678 = document.getElementById('u678');
gv_vAlignTable['u678'] = 'top';
var u770 = document.getElementById('u770');
gv_vAlignTable['u770'] = 'top';
var u623 = document.getElementById('u623');

u623.style.cursor = 'pointer';
if (bIE) u623.attachEvent("onclick", Clicku623);
else u623.addEventListener("click", Clicku623, true);
function Clicku623(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u385 = document.getElementById('u385');

var u589 = document.getElementById('u589');

u589.style.cursor = 'pointer';
if (bIE) u589.attachEvent("onclick", Clicku589);
else u589.addEventListener("click", Clicku589, true);
function Clicku589(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u501 = document.getElementById('u501');

u501.style.cursor = 'pointer';
if (bIE) u501.attachEvent("onclick", Clicku501);
else u501.addEventListener("click", Clicku501, true);
function Clicku501(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u168 = document.getElementById('u168');
gv_vAlignTable['u168'] = 'center';
var u473 = document.getElementById('u473');

var u752 = document.getElementById('u752');
gv_vAlignTable['u752'] = 'top';
var u681 = document.getElementById('u681');

u681.style.cursor = 'pointer';
if (bIE) u681.attachEvent("onclick", Clicku681);
else u681.addEventListener("click", Clicku681, true);
function Clicku681(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u885 = document.getElementById('u885');

var u499 = document.getElementById('u499');

u499.style.cursor = 'pointer';
if (bIE) u499.attachEvent("onclick", Clicku499);
else u499.addEventListener("click", Clicku499, true);
function Clicku499(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u443 = document.getElementById('u443');

var u753 = document.getElementById('u753');
gv_vAlignTable['u753'] = 'top';
var u295 = document.getElementById('u295');

var u278 = document.getElementById('u278');
gv_vAlignTable['u278'] = 'center';
var u367 = document.getElementById('u367');

var u206 = document.getElementById('u206');
gv_vAlignTable['u206'] = 'center';
var u573 = document.getElementById('u573');

var u58 = document.getElementById('u58');
gv_vAlignTable['u58'] = 'center';
var u426 = document.getElementById('u426');
gv_vAlignTable['u426'] = 'top';
var u875 = document.getElementById('u875');

var u688 = document.getElementById('u688');
gv_vAlignTable['u688'] = 'top';
var u49 = document.getElementById('u49');

var u99 = document.getElementById('u99');

var u632 = document.getElementById('u632');
gv_vAlignTable['u632'] = 'top';
var u836 = document.getElementById('u836');

u836.style.cursor = 'pointer';
if (bIE) u836.attachEvent("onclick", Clicku836);
else u836.addEventListener("click", Clicku836, true);
function Clicku836(e)
{

if (true) {

	self.location.href="财务单据查询.html" + GetQuerystring();

}

}

var u484 = document.getElementById('u484');
gv_vAlignTable['u484'] = 'top';
var u598 = document.getElementById('u598');
gv_vAlignTable['u598'] = 'top';
var u61 = document.getElementById('u61');

var u285 = document.getElementById('u285');

var u542 = document.getElementById('u542');
gv_vAlignTable['u542'] = 'top';
var u401 = document.getElementById('u401');

var u394 = document.getElementById('u394');
gv_vAlignTable['u394'] = 'center';
var u160 = document.getElementById('u160');
gv_vAlignTable['u160'] = 'center';
var u509 = document.getElementById('u509');

u509.style.cursor = 'pointer';
if (bIE) u509.attachEvent("onclick", Clicku509);
else u509.addEventListener("click", Clicku509, true);
function Clicku509(e)
{

if (true) {

	self.location.href="B2B签报管理.html" + GetQuerystring();

}

}

var u156 = document.getElementById('u156');
gv_vAlignTable['u156'] = 'center';
var u762 = document.getElementById('u762');
gv_vAlignTable['u762'] = 'center';
var u601 = document.getElementById('u601');

u601.style.cursor = 'pointer';
if (bIE) u601.attachEvent("onclick", Clicku601);
else u601.addEventListener("click", Clicku601, true);
function Clicku601(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u805 = document.getElementById('u805');

var u419 = document.getElementById('u419');

var u799 = document.getElementById('u799');

var u729 = document.getElementById('u729');

var u672 = document.getElementById('u672');
gv_vAlignTable['u672'] = 'top';
var u215 = document.getElementById('u215');

var u525 = document.getElementById('u525');

u525.style.cursor = 'pointer';
if (bIE) u525.attachEvent("onclick", Clicku525);
else u525.addEventListener("click", Clicku525, true);
function Clicku525(e)
{

if (true) {

	self.location.href="B2B订单管理.html" + GetQuerystring();

}

}

var u639 = document.getElementById('u639');

u639.style.cursor = 'pointer';
if (bIE) u639.attachEvent("onclick", Clicku639);
else u639.addEventListener("click", Clicku639, true);
function Clicku639(e)
{

if (true) {

	self.location.href="合同类别管理.html" + "";

}

}

var u859 = document.getElementById('u859');

u859.style.cursor = 'pointer';
if (bIE) u859.attachEvent("onclick", Clicku859);
else u859.addEventListener("click", Clicku859, true);
function Clicku859(e)
{

if (true) {

	self.location.href="应收_应付管理.html" + GetQuerystring();

}

}

var u435 = document.getElementById('u435');

u435.style.cursor = 'pointer';
if (bIE) u435.attachEvent("onclick", Clicku435);
else u435.addEventListener("click", Clicku435, true);
function Clicku435(e)
{

if (true) {

	self.location.href="采购报表查询.html" + GetQuerystring();

}

}

var u549 = document.getElementById('u549');

u549.style.cursor = 'pointer';
if (bIE) u549.attachEvent("onclick", Clicku549);
else u549.addEventListener("click", Clicku549, true);
function Clicku549(e)
{

if (true) {

	self.location.href="EMS单据管理.html" + GetQuerystring();

}

}

var u287 = document.getElementById('u287');

var u0 = document.getElementById('u0');

var u50 = document.getElementById('u50');
gv_vAlignTable['u50'] = 'center';
var u345 = document.getElementById('u345');

var u845 = document.getElementById('u845');

u845.style.cursor = 'pointer';
if (bIE) u845.attachEvent("onclick", Clicku845);
else u845.addEventListener("click", Clicku845, true);
function Clicku845(e)
{

if (true) {

	self.location.href="结转损益.html" + GetQuerystring();

}

}

var u163 = document.getElementById('u163');

var u197 = document.getElementById('u197');

var u769 = document.getElementById('u769');
gv_vAlignTable['u769'] = 'center';
var u608 = document.getElementById('u608');
gv_vAlignTable['u608'] = 'top';
var u41 = document.getElementById('u41');

var u91 = document.getElementById('u91');

var u781 = document.getElementById('u781');

u781.style.cursor = 'pointer';
if (bIE) u781.attachEvent("onclick", Clicku781);
else u781.addEventListener("click", Clicku781, true);
function Clicku781(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u255 = document.getElementById('u255');

var u565 = document.getElementById('u565');

u565.style.cursor = 'pointer';
if (bIE) u565.attachEvent("onclick", Clicku565);
else u565.addEventListener("click", Clicku565, true);
function Clicku565(e)
{

if (true) {

	self.location.href="成本核算管理.html" + GetQuerystring();

}

}

var u404 = document.getElementById('u404');
gv_vAlignTable['u404'] = 'center';
var u904 = document.getElementById('u904');

u904.style.cursor = 'pointer';
if (bIE) u904.attachEvent("onclick", Clicku904);
else u904.addEventListener("click", Clicku904, true);
function Clicku904(e)
{

if (true) {

	self.location.href="财务单据详情.html" + "";

}

}
gv_vAlignTable['u904'] = 'top';
var u679 = document.getElementById('u679');

u679.style.cursor = 'pointer';
if (bIE) u679.attachEvent("onclick", Clicku679);
else u679.addEventListener("click", Clicku679, true);
function Clicku679(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u518 = document.getElementById('u518');
gv_vAlignTable['u518'] = 'top';
var u7 = document.getElementById('u7');

var u32 = document.getElementById('u32');
gv_vAlignTable['u32'] = 'center';
var u82 = document.getElementById('u82');
gv_vAlignTable['u82'] = 'center';
var u63 = document.getElementById('u63');

var u771 = document.getElementById('u771');

var u314 = document.getElementById('u314');
gv_vAlignTable['u314'] = 'center';
var u213 = document.getElementById('u213');

var u624 = document.getElementById('u624');
gv_vAlignTable['u624'] = 'top';
var u738 = document.getElementById('u738');
gv_vAlignTable['u738'] = 'top';
var u54 = document.getElementById('u54');
gv_vAlignTable['u54'] = 'center';
var u621 = document.getElementById('u621');

u621.style.cursor = 'pointer';
if (bIE) u621.attachEvent("onclick", Clicku621);
else u621.addEventListener("click", Clicku621, true);
function Clicku621(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u534 = document.getElementById('u534');
gv_vAlignTable['u534'] = 'top';
var u107 = document.getElementById('u107');

var u682 = document.getElementById('u682');
gv_vAlignTable['u682'] = 'top';
var u886 = document.getElementById('u886');

var u45 = document.getElementById('u45');

var u95 = document.getElementById('u95');

var u76 = document.getElementById('u76');
gv_vAlignTable['u76'] = 'center';
var u444 = document.getElementById('u444');

var u754 = document.getElementById('u754');
gv_vAlignTable['u754'] = 'top';
var u592 = document.getElementById('u592');
gv_vAlignTable['u592'] = 'top';
var u67 = document.getElementById('u67');

var u731 = document.getElementById('u731');

u731.style.cursor = 'pointer';
if (bIE) u731.attachEvent("onclick", Clicku731);
else u731.addEventListener("click", Clicku731, true);
function Clicku731(e)
{

if (true) {

	self.location.href="入库单审核.html" + GetQuerystring();

}

}

var u571 = document.getElementById('u571');

var u664 = document.getElementById('u664');
gv_vAlignTable['u664'] = 'top';
var u207 = document.getElementById('u207');

var u778 = document.getElementById('u778');

u778.style.cursor = 'pointer';
if (bIE) u778.attachEvent("onclick", Clicku778);
else u778.addEventListener("click", Clicku778, true);
function Clicku778(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u574 = document.getElementById('u574');
gv_vAlignTable['u574'] = 'top';
var u117 = document.getElementById('u117');

var u723 = document.getElementById('u723');

u723.style.cursor = 'pointer';
if (bIE) u723.attachEvent("onclick", Clicku723);
else u723.addEventListener("click", Clicku723, true);
function Clicku723(e)
{

if (true) {

	self.location.href="售后出库.html" + GetQuerystring();

}

}

var u689 = document.getElementById('u689');

var u633 = document.getElementById('u633');

u633.style.cursor = 'pointer';
if (bIE) u633.attachEvent("onclick", Clicku633);
else u633.addEventListener("click", Clicku633, true);
function Clicku633(e)
{

if (true) {

	self.location.href="角色管理.html" + "";

}

}

var u837 = document.getElementById('u837');

var u485 = document.getElementById('u485');

u485.style.cursor = 'pointer';
if (bIE) u485.attachEvent("onclick", Clicku485);
else u485.addEventListener("click", Clicku485, true);
function Clicku485(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u599 = document.getElementById('u599');

var u543 = document.getElementById('u543');

u543.style.cursor = 'pointer';
if (bIE) u543.attachEvent("onclick", Clicku543);
else u543.addEventListener("click", Clicku543, true);
function Clicku543(e)
{

if (true) {

	self.location.href="佣金结算管理.html" + GetQuerystring();

}

}

var u395 = document.getElementById('u395');

var u521 = document.getElementById('u521');

u521.style.cursor = 'pointer';
if (bIE) u521.attachEvent("onclick", Clicku521);
else u521.addEventListener("click", Clicku521, true);
function Clicku521(e)
{

if (true) {

	self.location.href="B2B电子渠道审核管理.html" + GetQuerystring();

}

}

var u157 = document.getElementById('u157');

var u467 = document.getElementById('u467');

var u602 = document.getElementById('u602');
gv_vAlignTable['u602'] = 'top';
var u806 = document.getElementById('u806');
gv_vAlignTable['u806'] = 'center';
var u377 = document.getElementById('u377');

var u68 = document.getElementById('u68');
gv_vAlignTable['u68'] = 'center';
var u631 = document.getElementById('u631');

u631.style.cursor = 'pointer';
if (bIE) u631.attachEvent("onclick", Clicku631);
else u631.addEventListener("click", Clicku631, true);
function Clicku631(e)
{

if (true) {

	self.location.href="用户管理.html" + "";

}

}

var u526 = document.getElementById('u526');
gv_vAlignTable['u526'] = 'top';
var u274 = document.getElementById('u274');
gv_vAlignTable['u274'] = 'center';
var u788 = document.getElementById('u788');

var u59 = document.getElementById('u59');

var u436 = document.getElementById('u436');
gv_vAlignTable['u436'] = 'top';
var u584 = document.getElementById('u584');
gv_vAlignTable['u584'] = 'top';
var u698 = document.getElementById('u698');
gv_vAlignTable['u698'] = 'top';
var u642 = document.getElementById('u642');
gv_vAlignTable['u642'] = 'top';
var u31 = document.getElementById('u31');

var u494 = document.getElementById('u494');
gv_vAlignTable['u494'] = 'top';
var u609 = document.getElementById('u609');

u609.style.cursor = 'pointer';
if (bIE) u609.attachEvent("onclick", Clicku609);
else u609.addEventListener("click", Clicku609, true);
function Clicku609(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u721 = document.getElementById('u721');

u721.style.cursor = 'pointer';
if (bIE) u721.attachEvent("onclick", Clicku721);
else u721.addEventListener("click", Clicku721, true);
function Clicku721(e)
{

if (true) {

	self.location.href="销售出库.html" + GetQuerystring();

}

}

var u256 = document.getElementById('u256');
gv_vAlignTable['u256'] = 'center';
var u566 = document.getElementById('u566');
gv_vAlignTable['u566'] = 'top';
var u405 = document.getElementById('u405');
gv_vAlignTable['u405'] = 'top';
var u905 = document.getElementById('u905');

u905.style.cursor = 'pointer';
if (bIE) u905.attachEvent("onclick", Clicku905);
else u905.addEventListener("click", Clicku905, true);
function Clicku905(e)
{

if (true) {

	self.location.href="发票详情.html" + "";

}

}
gv_vAlignTable['u905'] = 'top';
var u519 = document.getElementById('u519');

u519.style.cursor = 'pointer';
if (bIE) u519.attachEvent("onclick", Clicku519);
else u519.addEventListener("click", Clicku519, true);
function Clicku519(e)
{

if (true) {

	self.location.href="B2B电子渠道库存管理.html" + GetQuerystring();

}

}

var u164 = document.getElementById('u164');
gv_vAlignTable['u164'] = 'center';
var u772 = document.getElementById('u772');

var u315 = document.getElementById('u315');

var u815 = document.getElementById('u815');
gv_vAlignTable['u815'] = 'center';
var u625 = document.getElementById('u625');

u625.style.cursor = 'pointer';
if (bIE) u625.attachEvent("onclick", Clicku625);
else u625.addEventListener("click", Clicku625, true);
function Clicku625(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u739 = document.getElementById('u739');

u739.style.cursor = 'pointer';
if (bIE) u739.attachEvent("onclick", Clicku739);
else u739.addEventListener("click", Clicku739, true);
function Clicku739(e)
{

if (true) {

	self.location.href="移库审核.html" + GetQuerystring();

}

}

var u535 = document.getElementById('u535');

u535.style.cursor = 'pointer';
if (bIE) u535.attachEvent("onclick", Clicku535);
else u535.addEventListener("click", Clicku535, true);
function Clicku535(e)
{

if (true) {

	self.location.href="手工充值管理.html" + GetQuerystring();

}

}

var u649 = document.getElementById('u649');

u649.style.cursor = 'pointer';
if (bIE) u649.attachEvent("onclick", Clicku649);
else u649.addEventListener("click", Clicku649, true);
function Clicku649(e)
{

if (true) {

	self.location.href="系统参数管理.html" + GetQuerystring();

}

}

var u683 = document.getElementById('u683');

u683.style.cursor = 'pointer';
if (bIE) u683.attachEvent("onclick", Clicku683);
else u683.addEventListener("click", Clicku683, true);
function Clicku683(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u887 = document.getElementById('u887');
gv_vAlignTable['u887'] = 'top';
var u531 = document.getElementById('u531');

var u60 = document.getElementById('u60');
gv_vAlignTable['u60'] = 'center';
var u849 = document.getElementById('u849');

var u169 = document.getElementById('u169');

var u445 = document.getElementById('u445');

u445.style.cursor = 'pointer';
if (bIE) u445.attachEvent("onclick", Clicku445);
else u445.addEventListener("click", Clicku445, true);
function Clicku445(e)
{

if (true) {

	self.location.href="请购单管理.html" + GetQuerystring();

}

}

var u559 = document.getElementById('u559');

u559.style.cursor = 'pointer';
if (bIE) u559.attachEvent("onclick", Clicku559);
else u559.addEventListener("click", Clicku559, true);
function Clicku559(e)
{

if (true) {

	self.location.href="基础资料管理.html" + GetQuerystring();

}

}

var u297 = document.getElementById('u297');

var u708 = document.getElementById('u708');
gv_vAlignTable['u708'] = 'top';
var u572 = document.getElementById('u572');
gv_vAlignTable['u572'] = 'top';
var u51 = document.getElementById('u51');

var u355 = document.getElementById('u355');

var u855 = document.getElementById('u855');

var u665 = document.getElementById('u665');

u665.style.cursor = 'pointer';
if (bIE) u665.attachEvent("onclick", Clicku665);
else u665.addEventListener("click", Clicku665, true);
function Clicku665(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u504 = document.getElementById('u504');
gv_vAlignTable['u504'] = 'top';
var u337 = document.getElementById('u337');

var u779 = document.getElementById('u779');

var u618 = document.getElementById('u618');
gv_vAlignTable['u618'] = 'top';
var u42 = document.getElementById('u42');
gv_vAlignTable['u42'] = 'center';
var u92 = document.getElementById('u92');
gv_vAlignTable['u92'] = 'center';
var u73 = document.getElementById('u73');

var u575 = document.getElementById('u575');

var u414 = document.getElementById('u414');
gv_vAlignTable['u414'] = 'top';
var u724 = document.getElementById('u724');
gv_vAlignTable['u724'] = 'top';
var u864 = document.getElementById('u864');
gv_vAlignTable['u864'] = 'center';
var u64 = document.getElementById('u64');
gv_vAlignTable['u64'] = 'center';
var u447 = document.getElementById('u447');

u447.style.cursor = 'pointer';
if (bIE) u447.attachEvent("onclick", Clicku447);
else u447.addEventListener("click", Clicku447, true);
function Clicku447(e)
{

if (true) {

	self.location.href="请购单审核管理.html" + GetQuerystring();

}

}

var u634 = document.getElementById('u634');
gv_vAlignTable['u634'] = 'top';
var u748 = document.getElementById('u748');
gv_vAlignTable['u748'] = 'top';
var u486 = document.getElementById('u486');
gv_vAlignTable['u486'] = 'top';
var u55 = document.getElementById('u55');

var u65 = document.getElementById('u65');

var u544 = document.getElementById('u544');
gv_vAlignTable['u544'] = 'top';
var u692 = document.getElementById('u692');
gv_vAlignTable['u692'] = 'top';
var u896 = document.getElementById('u896');
gv_vAlignTable['u896'] = 'top';
var u77 = document.getElementById('u77');

var u431 = document.getElementById('u431');

u431.style.cursor = 'pointer';
if (bIE) u431.attachEvent("onclick", Clicku431);
else u431.addEventListener("click", Clicku431, true);
function Clicku431(e)
{

if (true) {

	self.location.href="统计查询.html" + GetQuerystring();

}

}

var u764 = document.getElementById('u764');
gv_vAlignTable['u764'] = 'center';
var u307 = document.getElementById('u307');

var u807 = document.getElementById('u807');

u807.style.cursor = 'pointer';
if (bIE) u807.attachEvent("onclick", Clicku807);
else u807.addEventListener("click", Clicku807, true);
function Clicku807(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u384 = document.getElementById('u384');
gv_vAlignTable['u384'] = 'center';
var u674 = document.getElementById('u674');
gv_vAlignTable['u674'] = 'top';
var u217 = document.getElementById('u217');

var u75 = document.getElementById('u75');

var u848 = document.getElementById('u848');

u848.style.cursor = 'pointer';
if (bIE) u848.attachEvent("onclick", Clicku848);
else u848.addEventListener("click", Clicku848, true);
function Clicku848(e)
{

if (true) {

	self.location.href="期末结账.html" + GetQuerystring();

}

}

var u237 = document.getElementById('u237');

var u789 = document.getElementById('u789');
gv_vAlignTable['u789'] = 'center';
var u111 = document.getElementById('u111');

var u127 = document.getElementById('u127');

var u437 = document.getElementById('u437');

u437.style.cursor = 'pointer';
if (bIE) u437.attachEvent("onclick", Clicku437);
else u437.addEventListener("click", Clicku437, true);
function Clicku437(e)
{

if (true) {

	self.location.href="库存报表查询.html" + GetQuerystring();

}

}

var u306 = document.getElementById('u306');
gv_vAlignTable['u306'] = 'center';
var u585 = document.getElementById('u585');

u585.style.cursor = 'pointer';
if (bIE) u585.attachEvent("onclick", Clicku585);
else u585.addEventListener("click", Clicku585, true);
function Clicku585(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u699 = document.getElementById('u699');

u699.style.cursor = 'pointer';
if (bIE) u699.attachEvent("onclick", Clicku699);
else u699.addEventListener("click", Clicku699, true);
function Clicku699(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u643 = document.getElementById('u643');

u643.style.cursor = 'pointer';
if (bIE) u643.attachEvent("onclick", Clicku643);
else u643.addEventListener("click", Clicku643, true);
function Clicku643(e)
{

if (true) {

	self.location.href="组织结构管理.html" + "";

}

}

var u847 = document.getElementById('u847');
gv_vAlignTable['u847'] = 'center';
var u495 = document.getElementById('u495');

u495.style.cursor = 'pointer';
if (bIE) u495.attachEvent("onclick", Clicku495);
else u495.addEventListener("click", Clicku495, true);
function Clicku495(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u347 = document.getElementById('u347');

var u833 = document.getElementById('u833');
gv_vAlignTable['u833'] = 'center';
var u257 = document.getElementById('u257');

var u567 = document.getElementById('u567');

u567.style.cursor = 'pointer';
if (bIE) u567.attachEvent("onclick", Clicku567);
else u567.addEventListener("click", Clicku567, true);
function Clicku567(e)
{

if (true) {

	self.location.href="财务报表管理.html" + GetQuerystring();

}

}

var u406 = document.getElementById('u406');
gv_vAlignTable['u406'] = 'top';
var u906 = document.getElementById('u906');

var u773 = document.getElementById('u773');

var u78 = document.getElementById('u78');
gv_vAlignTable['u78'] = 'center';
var u816 = document.getElementById('u816');

var u626 = document.getElementById('u626');
gv_vAlignTable['u626'] = 'top';
var u610 = document.getElementById('u610');
gv_vAlignTable['u610'] = 'top';
var u284 = document.getElementById('u284');
gv_vAlignTable['u284'] = 'center';
var u69 = document.getElementById('u69');

var u536 = document.getElementById('u536');
gv_vAlignTable['u536'] = 'top';
var u727 = document.getElementById('u727');

u727.style.cursor = 'pointer';
if (bIE) u727.attachEvent("onclick", Clicku727);
else u727.addEventListener("click", Clicku727, true);
function Clicku727(e)
{

if (true) {

	self.location.href="其他出库[如活动赠品].html" + GetQuerystring();

}

}

var u684 = document.getElementById('u684');
gv_vAlignTable['u684'] = 'top';
var u190 = document.getElementById('u190');
gv_vAlignTable['u190'] = 'center';
var u446 = document.getElementById('u446');
gv_vAlignTable['u446'] = 'top';
var u137 = document.getElementById('u137');

var u594 = document.getElementById('u594');
gv_vAlignTable['u594'] = 'top';
var u798 = document.getElementById('u798');

u798.style.cursor = 'pointer';
if (bIE) u798.attachEvent("onclick", Clicku798);
else u798.addEventListener("click", Clicku798, true);
function Clicku798(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u709 = document.getElementById('u709');

u709.style.cursor = 'pointer';
if (bIE) u709.attachEvent("onclick", Clicku709);
else u709.addEventListener("click", Clicku709, true);
function Clicku709(e)
{

if (true) {

	self.location.href="出库管理.html" + GetQuerystring();

}

}

var u128 = document.getElementById('u128');
gv_vAlignTable['u128'] = 'center';
var u356 = document.getElementById('u356');
gv_vAlignTable['u356'] = 'center';
var u113 = document.getElementById('u113');

var u666 = document.getElementById('u666');
gv_vAlignTable['u666'] = 'top';
var u505 = document.getElementById('u505');

u505.style.cursor = 'pointer';
if (bIE) u505.attachEvent("onclick", Clicku505);
else u505.addEventListener("click", Clicku505, true);
function Clicku505(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u619 = document.getElementById('u619');

u619.style.cursor = 'pointer';
if (bIE) u619.attachEvent("onclick", Clicku619);
else u619.addEventListener("click", Clicku619, true);
function Clicku619(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u33 = document.getElementById('u33');

var u247 = document.getElementById('u247');

var u576 = document.getElementById('u576');
gv_vAlignTable['u576'] = 'top';
var u415 = document.getElementById('u415');

u415.style.cursor = 'pointer';
if (bIE) u415.attachEvent("onclick", Clicku415);
else u415.addEventListener("click", Clicku415, true);
function Clicku415(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u725 = document.getElementById('u725');

u725.style.cursor = 'pointer';
if (bIE) u725.attachEvent("onclick", Clicku725);
else u725.addEventListener("click", Clicku725, true);
function Clicku725(e)
{

if (true) {

	self.location.href="借机出库.html" + GetQuerystring();

}

}

var u783 = document.getElementById('u783');
gv_vAlignTable['u783'] = 'center';
var u316 = document.getElementById('u316');
gv_vAlignTable['u316'] = 'center';
var u635 = document.getElementById('u635');

u635.style.cursor = 'pointer';
if (bIE) u635.attachEvent("onclick", Clicku635);
else u635.addEventListener("click", Clicku635, true);
function Clicku635(e)
{

if (true) {

	self.location.href="权限管理.html" + "";

}

}

var u141 = document.getElementById('u141');

var u487 = document.getElementById('u487');

u487.style.cursor = 'pointer';
if (bIE) u487.attachEvent("onclick", Clicku487);
else u487.addEventListener("click", Clicku487, true);
function Clicku487(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u70 = document.getElementById('u70');
gv_vAlignTable['u70'] = 'center';
var u545 = document.getElementById('u545');

u545.style.cursor = 'pointer';
if (bIE) u545.attachEvent("onclick", Clicku545);
else u545.addEventListener("click", Clicku545, true);
function Clicku545(e)
{

if (true) {

	self.location.href="佣金结算审核.html" + GetQuerystring();

}

}

var u659 = document.getElementById('u659');

var u397 = document.getElementById('u397');

var u897 = document.getElementById('u897');

var u200 = document.getElementById('u200');
gv_vAlignTable['u200'] = 'center';
var u475 = document.getElementById('u475');

var u858 = document.getElementById('u858');
gv_vAlignTable['u858'] = 'center';
var u455 = document.getElementById('u455');

u455.style.cursor = 'pointer';
if (bIE) u455.attachEvent("onclick", Clicku455);
else u455.addEventListener("click", Clicku455, true);
function Clicku455(e)
{

if (true) {

	self.location.href="采购单管理.html" + GetQuerystring();

}

}

var u765 = document.getElementById('u765');

var u604 = document.getElementById('u604');
gv_vAlignTable['u604'] = 'top';
var u110 = document.getElementById('u110');
gv_vAlignTable['u110'] = 'center';
var u52 = document.getElementById('u52');
gv_vAlignTable['u52'] = 'center';
var u675 = document.getElementById('u675');

var u514 = document.getElementById('u514');
gv_vAlignTable['u514'] = 'top';
var u74 = document.getElementById('u74');
gv_vAlignTable['u74'] = 'center';
var u734 = document.getElementById('u734');
gv_vAlignTable['u734'] = 'top';
var u147 = document.getElementById('u147');

var u240 = document.getElementById('u240');
gv_vAlignTable['u240'] = 'center';
var u586 = document.getElementById('u586');
gv_vAlignTable['u586'] = 'top';
var u730 = document.getElementById('u730');

var u300 = document.getElementById('u300');
gv_vAlignTable['u300'] = 'center';
var u216 = document.getElementById('u216');
gv_vAlignTable['u216'] = 'center';
var u644 = document.getElementById('u644');
gv_vAlignTable['u644'] = 'top';
var u150 = document.getElementById('u150');
gv_vAlignTable['u150'] = 'center';
var u496 = document.getElementById('u496');
gv_vAlignTable['u496'] = 'top';
var u407 = document.getElementById('u407');
gv_vAlignTable['u407'] = 'top';
var u793 = document.getElementById('u793');
gv_vAlignTable['u793'] = 'center';
var u774 = document.getElementById('u774');
gv_vAlignTable['u774'] = 'center';
var u317 = document.getElementById('u317');

var u817 = document.getElementById('u817');
gv_vAlignTable['u817'] = 'center';
var u227 = document.getElementById('u227');

var u537 = document.getElementById('u537');

u537.style.cursor = 'pointer';
if (bIE) u537.attachEvent("onclick", Clicku537);
else u537.addEventListener("click", Clicku537, true);
function Clicku537(e)
{

if (true) {

	self.location.href="手工充值审核.html" + GetQuerystring();

}

}

var u685 = document.getElementById('u685');

u685.style.cursor = 'pointer';
if (bIE) u685.attachEvent("onclick", Clicku685);
else u685.addEventListener("click", Clicku685, true);
function Clicku685(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u856 = document.getElementById('u856');

u856.style.cursor = 'pointer';
if (bIE) u856.attachEvent("onclick", Clicku856);
else u856.addEventListener("click", Clicku856, true);
function Clicku856(e)
{

if (true) {

	self.location.href="基础资料管理.html" + GetQuerystring();

}

}

var u176 = document.getElementById('u176');
gv_vAlignTable['u176'] = 'center';
var u191 = document.getElementById('u191');

var u743 = document.getElementById('u743');

u743.style.cursor = 'pointer';
if (bIE) u743.attachEvent("onclick", Clicku743);
else u743.addEventListener("click", Clicku743, true);
function Clicku743(e)
{

if (true) {

	self.location.href="采购入库.html" + GetQuerystring();

}

}

var u561 = document.getElementById('u561');

u561.style.cursor = 'pointer';
if (bIE) u561.attachEvent("onclick", Clicku561);
else u561.addEventListener("click", Clicku561, true);
function Clicku561(e)
{

if (true) {

	self.location.href="应收_应付管理.html" + GetQuerystring();

}

}

var u595 = document.getElementById('u595');

u595.style.cursor = 'pointer';
if (bIE) u595.attachEvent("onclick", Clicku595);
else u595.addEventListener("click", Clicku595, true);
function Clicku595(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u357 = document.getElementById('u357');

var u630 = document.getElementById('u630');

var u667 = document.getElementById('u667');

u667.style.cursor = 'pointer';
if (bIE) u667.attachEvent("onclick", Clicku667);
else u667.addEventListener("click", Clicku667, true);
function Clicku667(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u506 = document.getElementById('u506');
gv_vAlignTable['u506'] = 'top';
var u583 = document.getElementById('u583');

u583.style.cursor = 'pointer';
if (bIE) u583.attachEvent("onclick", Clicku583);
else u583.addEventListener("click", Clicku583, true);
function Clicku583(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u116 = document.getElementById('u116');
gv_vAlignTable['u116'] = 'center';
var u577 = document.getElementById('u577');

var u416 = document.getElementById('u416');
gv_vAlignTable['u416'] = 'top';
var u726 = document.getElementById('u726');
gv_vAlignTable['u726'] = 'top';
var u79 = document.getElementById('u79');

var u693 = document.getElementById('u693');

u693.style.cursor = 'pointer';
if (bIE) u693.attachEvent("onclick", Clicku693);
else u693.addEventListener("click", Clicku693, true);
function Clicku693(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u636 = document.getElementById('u636');
gv_vAlignTable['u636'] = 'top';
var u784 = document.getElementById('u784');

u784.style.cursor = 'pointer';
if (bIE) u784.attachEvent("onclick", Clicku784);
else u784.addEventListener("click", Clicku784, true);
function Clicku784(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u290 = document.getElementById('u290');
gv_vAlignTable['u290'] = 'center';
var u546 = document.getElementById('u546');
gv_vAlignTable['u546'] = 'top';
var u694 = document.getElementById('u694');
gv_vAlignTable['u694'] = 'top';
var u420 = document.getElementById('u420');
gv_vAlignTable['u420'] = 'top';
var u456 = document.getElementById('u456');
gv_vAlignTable['u456'] = 'top';
var u766 = document.getElementById('u766');
gv_vAlignTable['u766'] = 'center';
var u605 = document.getElementById('u605');

u605.style.cursor = 'pointer';
if (bIE) u605.attachEvent("onclick", Clicku605);
else u605.addEventListener("click", Clicku605, true);
function Clicku605(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u719 = document.getElementById('u719');

u719.style.cursor = 'pointer';
if (bIE) u719.attachEvent("onclick", Clicku719);
else u719.addEventListener("click", Clicku719, true);
function Clicku719(e)
{

if (true) {

	self.location.href="采购退库.html" + GetQuerystring();

}

}

var u461 = document.getElementById('u461');

u461.style.cursor = 'pointer';
if (bIE) u461.attachEvent("onclick", Clicku461);
else u461.addEventListener("click", Clicku461, true);
function Clicku461(e)
{

if (true) {

	self.location.href="采购退货计划单管理.html" + GetQuerystring();

}

}

var u676 = document.getElementById('u676');

var u515 = document.getElementById('u515');

u515.style.cursor = 'pointer';
if (bIE) u515.attachEvent("onclick", Clicku515);
else u515.addEventListener("click", Clicku515, true);
function Clicku515(e)
{

if (true) {

	self.location.href="B2B价保管理.html" + GetQuerystring();

}

}

var u100 = document.getElementById('u100');
gv_vAlignTable['u100'] = 'center';
var u735 = document.getElementById('u735');

var u241 = document.getElementById('u241');

var u587 = document.getElementById('u587');

u587.style.cursor = 'pointer';
if (bIE) u587.attachEvent("onclick", Clicku587);
else u587.addEventListener("click", Clicku587, true);
function Clicku587(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u645 = document.getElementById('u645');

u645.style.cursor = 'pointer';
if (bIE) u645.attachEvent("onclick", Clicku645);
else u645.addEventListener("click", Clicku645, true);
function Clicku645(e)
{

if (true) {

	self.location.href="审批流程管理.html" + "";

}

}

var u336 = document.getElementById('u336');
gv_vAlignTable['u336'] = 'center';
var u759 = document.getElementById('u759');

var u497 = document.getElementById('u497');

u497.style.cursor = 'pointer';
if (bIE) u497.attachEvent("onclick", Clicku497);
else u497.addEventListener("click", Clicku497, true);
function Clicku497(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u593 = document.getElementById('u593');

u593.style.cursor = 'pointer';
if (bIE) u593.attachEvent("onclick", Clicku593);
else u593.addEventListener("click", Clicku593, true);
function Clicku593(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u800 = document.getElementById('u800');
gv_vAlignTable['u800'] = 'center';
var u71 = document.getElementById('u71');

var u555 = document.getElementById('u555');

u555.style.cursor = 'pointer';
if (bIE) u555.attachEvent("onclick", Clicku555);
else u555.addEventListener("click", Clicku555, true);
function Clicku555(e)
{

if (true) {

	self.location.href="物流地域维护管理.html" + GetQuerystring();

}

}

var u704 = document.getElementById('u704');
gv_vAlignTable['u704'] = 'top';
var u863 = document.getElementById('u863');

var u210 = document.getElementById('u210');
gv_vAlignTable['u210'] = 'center';
var u62 = document.getElementById('u62');
gv_vAlignTable['u62'] = 'center';
var u775 = document.getElementById('u775');

var u614 = document.getElementById('u614');

var u228 = document.getElementById('u228');
gv_vAlignTable['u228'] = 'center';
var u120 = document.getElementById('u120');
gv_vAlignTable['u120'] = 'center';
var u340 = document.getElementById('u340');
gv_vAlignTable['u340'] = 'center';
var u686 = document.getElementById('u686');
gv_vAlignTable['u686'] = 'top';
var u158 = document.getElementById('u158');
gv_vAlignTable['u158'] = 'center';
var u430 = document.getElementById('u430');
gv_vAlignTable['u430'] = 'top';
var u744 = document.getElementById('u744');
gv_vAlignTable['u744'] = 'top';
var u250 = document.getElementById('u250');
gv_vAlignTable['u250'] = 'center';
var u596 = document.getElementById('u596');
gv_vAlignTable['u596'] = 'top';
var u167 = document.getElementById('u167');

var u471 = document.getElementById('u471');

var u750 = document.getElementById('u750');
gv_vAlignTable['u750'] = 'top';
var u507 = document.getElementById('u507');

var u493 = document.getElementById('u493');

u493.style.cursor = 'pointer';
if (bIE) u493.attachEvent("onclick", Clicku493);
else u493.addEventListener("click", Clicku493, true);
function Clicku493(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u417 = document.getElementById('u417');

u417.style.cursor = 'pointer';
if (bIE) u417.attachEvent("onclick", Clicku417);
else u417.addEventListener("click", Clicku417, true);
function Clicku417(e)
{

if (true) {

}

}

var u305 = document.getElementById('u305');

var u277 = document.getElementById('u277');

var u151 = document.getElementById('u151');

var u327 = document.getElementById('u327');

var u827 = document.getElementById('u827');
gv_vAlignTable['u827'] = 'top';
var u637 = document.getElementById('u637');

u637.style.cursor = 'pointer';
if (bIE) u637.attachEvent("onclick", Clicku637);
else u637.addEventListener("click", Clicku637, true);
function Clicku637(e)
{

if (true) {

	self.location.href="IP访问限制管理.html" + "";

}

}

var u346 = document.getElementById('u346');
gv_vAlignTable['u346'] = 'center';
var u785 = document.getElementById('u785');

var u291 = document.getElementById('u291');

var u547 = document.getElementById('u547');

var u695 = document.getElementById('u695');

u695.style.cursor = 'pointer';
if (bIE) u695.attachEvent("onclick", Clicku695);
else u695.addEventListener("click", Clicku695, true);
function Clicku695(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u873 = document.getElementById('u873');

var u457 = document.getElementById('u457');

u457.style.cursor = 'pointer';
if (bIE) u457.attachEvent("onclick", Clicku457);
else u457.addEventListener("click", Clicku457, true);
function Clicku457(e)
{

if (true) {

	self.location.href="采购结算单管理.html" + GetQuerystring();

}

}

var u767 = document.getElementById('u767');
gv_vAlignTable['u767'] = 'top';
var u606 = document.getElementById('u606');
gv_vAlignTable['u606'] = 'top';
var u112 = document.getElementById('u112');
gv_vAlignTable['u112'] = 'center';
var u895 = document.getElementById('u895');

var u677 = document.getElementById('u677');

u677.style.cursor = 'pointer';
if (bIE) u677.attachEvent("onclick", Clicku677);
else u677.addEventListener("click", Clicku677, true);
function Clicku677(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u516 = document.getElementById('u516');
gv_vAlignTable['u516'] = 'top';
var u136 = document.getElementById('u136');
gv_vAlignTable['u136'] = 'center';
var u736 = document.getElementById('u736');

var u390 = document.getElementById('u390');
gv_vAlignTable['u390'] = 'center';
var u890 = document.getElementById('u890');
gv_vAlignTable['u890'] = 'top';
var u646 = document.getElementById('u646');
gv_vAlignTable['u646'] = 'top';
var u152 = document.getElementById('u152');
gv_vAlignTable['u152'] = 'center';
var u794 = document.getElementById('u794');

var u246 = document.getElementById('u246');
gv_vAlignTable['u246'] = 'center';
var u556 = document.getElementById('u556');
gv_vAlignTable['u556'] = 'top';
var u705 = document.getElementById('u705');

var u782 = document.getElementById('u782');

var u211 = document.getElementById('u211');

var u776 = document.getElementById('u776');
gv_vAlignTable['u776'] = 'center';
var u615 = document.getElementById('u615');

u615.style.cursor = 'pointer';
if (bIE) u615.attachEvent("onclick", Clicku615);
else u615.addEventListener("click", Clicku615, true);
function Clicku615(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u365 = document.getElementById('u365');

var u440 = document.getElementById('u440');
gv_vAlignTable['u440'] = 'top';
var u121 = document.getElementById('u121');

var u341 = document.getElementById('u341');

var u687 = document.getElementById('u687');

u687.style.cursor = 'pointer';
if (bIE) u687.attachEvent("onclick", Clicku687);
else u687.addEventListener("click", Clicku687, true);
function Clicku687(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u745 = document.getElementById('u745');

u745.style.cursor = 'pointer';
if (bIE) u745.attachEvent("onclick", Clicku745);
else u745.addEventListener("click", Clicku745, true);
function Clicku745(e)
{

if (true) {

	self.location.href="销售入库.html" + GetQuerystring();

}

}

var u251 = document.getElementById('u251');

var u597 = document.getElementById('u597');

u597.style.cursor = 'pointer';
if (bIE) u597.attachEvent("onclick", Clicku597);
else u597.addEventListener("click", Clicku597, true);
function Clicku597(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u400 = document.getElementById('u400');
gv_vAlignTable['u400'] = 'center';
var u900 = document.getElementById('u900');

u900.style.cursor = 'pointer';
if (bIE) u900.attachEvent("onclick", Clicku900);
else u900.addEventListener("click", Clicku900, true);
function Clicku900(e)
{

if (true) {

	self.location.href="凭证详情.html" + GetQuerystring();

}

}
gv_vAlignTable['u900'] = 'top';
var u655 = document.getElementById('u655');

var u161 = document.getElementById('u161');

var u310 = document.getElementById('u310');
gv_vAlignTable['u310'] = 'center';
var u810 = document.getElementById('u810');

u810.style.cursor = 'pointer';
if (bIE) u810.attachEvent("onclick", Clicku810);
else u810.addEventListener("click", Clicku810, true);
function Clicku810(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u72 = document.getElementById('u72');
gv_vAlignTable['u72'] = 'center';
var u660 = document.getElementById('u660');

var u714 = document.getElementById('u714');
gv_vAlignTable['u714'] = 'top';
var u146 = document.getElementById('u146');
gv_vAlignTable['u146'] = 'center';
var u220 = document.getElementById('u220');
gv_vAlignTable['u220'] = 'center';
var u130 = document.getElementById('u130');
gv_vAlignTable['u130'] = 'center';
var u466 = document.getElementById('u466');
gv_vAlignTable['u466'] = 'top';
var u786 = document.getElementById('u786');
gv_vAlignTable['u786'] = 'center';
var u258 = document.getElementById('u258');
gv_vAlignTable['u258'] = 'center';
var u350 = document.getElementById('u350');
gv_vAlignTable['u350'] = 'center';
var u696 = document.getElementById('u696');
gv_vAlignTable['u696'] = 'top';
var u792 = document.getElementById('u792');

var u607 = document.getElementById('u607');

u607.style.cursor = 'pointer';
if (bIE) u607.attachEvent("onclick", Clicku607);
else u607.addEventListener("click", Clicku607, true);
function Clicku607(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u450 = document.getElementById('u450');
gv_vAlignTable['u450'] = 'top';
var u170 = document.getElementById('u170');
gv_vAlignTable['u170'] = 'center';
var u427 = document.getElementById('u427');

u427.style.cursor = 'pointer';
if (bIE) u427.attachEvent("onclick", Clicku427);
else u427.addEventListener("click", Clicku427, true);
function Clicku427(e)
{

if (true) {

	self.location.href="财务管理.html" + GetQuerystring();

}

}

var u737 = document.getElementById('u737');

u737.style.cursor = 'pointer';
if (bIE) u737.attachEvent("onclick", Clicku737);
else u737.addEventListener("click", Clicku737, true);
function Clicku737(e)
{

if (true) {

	self.location.href="移库管理_1.html" + GetQuerystring();

}

}

var u187 = document.getElementById('u187');

var u891 = document.getElementById('u891');
gv_vAlignTable['u891'] = 'top';
var u647 = document.getElementById('u647');

u647.style.cursor = 'pointer';
if (bIE) u647.attachEvent("onclick", Clicku647);
else u647.addEventListener("click", Clicku647, true);
function Clicku647(e)
{

if (true) {

	self.location.href="日志管理.html" + "";

}

}

var u582 = document.getElementById('u582');
gv_vAlignTable['u582'] = 'top';
var u153 = document.getElementById('u153');

var u795 = document.getElementById('u795');

u795.style.cursor = 'pointer';
if (bIE) u795.attachEvent("onclick", Clicku795);
else u795.addEventListener("click", Clicku795, true);
function Clicku795(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u366 = document.getElementById('u366');
gv_vAlignTable['u366'] = 'center';
var u557 = document.getElementById('u557');

var u706 = document.getElementById('u706');

var u212 = document.getElementById('u212');
gv_vAlignTable['u212'] = 'center';
var u761 = document.getElementById('u761');

var u777 = document.getElementById('u777');

var u616 = document.getElementById('u616');
gv_vAlignTable['u616'] = 'top';
var u122 = document.getElementById('u122');
gv_vAlignTable['u122'] = 'center';
var u476 = document.getElementById('u476');

var u180 = document.getElementById('u180');
gv_vAlignTable['u180'] = 'center';
var u490 = document.getElementById('u490');
gv_vAlignTable['u490'] = 'top';
var u746 = document.getElementById('u746');
gv_vAlignTable['u746'] = 'top';
var u252 = document.getElementById('u252');
gv_vAlignTable['u252'] = 'center';
var u656 = document.getElementById('u656');
gv_vAlignTable['u656'] = 'top';
var u162 = document.getElementById('u162');
gv_vAlignTable['u162'] = 'center';
var u311 = document.getElementById('u311');

var u811 = document.getElementById('u811');

var u129 = document.getElementById('u129');

var u893 = document.getElementById('u893');
gv_vAlignTable['u893'] = 'top';
var u715 = document.getElementById('u715');

var u266 = document.getElementById('u266');
gv_vAlignTable['u266'] = 'center';
var u221 = document.getElementById('u221');

var u140 = document.getElementById('u140');
gv_vAlignTable['u140'] = 'center';
var u477 = document.getElementById('u477');

u477.style.cursor = 'pointer';
if (bIE) u477.attachEvent("onclick", Clicku477);
else u477.addEventListener("click", Clicku477, true);
function Clicku477(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u899 = document.getElementById('u899');
gv_vAlignTable['u899'] = 'top';
var u131 = document.getElementById('u131');

var u879 = document.getElementById('u879');

var u441 = document.getElementById('u441');

u441.style.cursor = 'pointer';
if (bIE) u441.attachEvent("onclick", Clicku441);
else u441.addEventListener("click", Clicku441, true);
function Clicku441(e)
{

if (true) {

	self.location.href="售后报表查询.html" + GetQuerystring();

}

}

var u787 = document.getElementById('u787');

u787.style.cursor = 'pointer';
if (bIE) u787.attachEvent("onclick", Clicku787);
else u787.addEventListener("click", Clicku787, true);
function Clicku787(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u376 = document.getElementById('u376');
gv_vAlignTable['u376'] = 'center';
var u862 = document.getElementById('u862');

u862.style.cursor = 'pointer';
if (bIE) u862.attachEvent("onclick", Clicku862);
else u862.addEventListener("click", Clicku862, true);
function Clicku862(e)
{

if (true) {

	self.location.href="总账管理.html" + GetQuerystring();

}

}

var u351 = document.getElementById('u351');

var u697 = document.getElementById('u697');

u697.style.cursor = 'pointer';
if (bIE) u697.attachEvent("onclick", Clicku697);
else u697.addEventListener("click", Clicku697, true);
function Clicku697(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u500 = document.getElementById('u500');
gv_vAlignTable['u500'] = 'top';
var u755 = document.getElementById('u755');

var u261 = document.getElementById('u261');

var u410 = document.getElementById('u410');

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u869 = document.getElementById('u869');

var u360 = document.getElementById('u360');
gv_vAlignTable['u360'] = 'center';
var u171 = document.getElementById('u171');

var u320 = document.getElementById('u320');
gv_vAlignTable['u320'] = 'center';
var u820 = document.getElementById('u820');

var u138 = document.getElementById('u138');
gv_vAlignTable['u138'] = 'center';
var u125 = document.getElementById('u125');

var u230 = document.getElementById('u230');
gv_vAlignTable['u230'] = 'center';
var u540 = document.getElementById('u540');
gv_vAlignTable['u540'] = 'top';
var u358 = document.getElementById('u358');
gv_vAlignTable['u358'] = 'center';
var u166 = document.getElementById('u166');
gv_vAlignTable['u166'] = 'center';
var u470 = document.getElementById('u470');
gv_vAlignTable['u470'] = 'top';
var u16 = document.getElementById('u16');
gv_vAlignTable['u16'] = 'center';
var u154 = document.getElementById('u154');
gv_vAlignTable['u154'] = 'center';
var u796 = document.getElementById('u796');

var u268 = document.getElementById('u268');
gv_vAlignTable['u268'] = 'center';
var u492 = document.getElementById('u492');

var u707 = document.getElementById('u707');

u707.style.cursor = 'pointer';
if (bIE) u707.attachEvent("onclick", Clicku707);
else u707.addEventListener("click", Clicku707, true);
function Clicku707(e)
{

if (true) {

	self.location.href="入库管理.html" + GetQuerystring();

}

}

var u860 = document.getElementById('u860');

var u178 = document.getElementById('u178');
gv_vAlignTable['u178'] = 'center';
var u617 = document.getElementById('u617');

u617.style.cursor = 'pointer';
if (bIE) u617.attachEvent("onclick", Clicku617);
else u617.addEventListener("click", Clicku617, true);
function Clicku617(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u123 = document.getElementById('u123');

var u527 = document.getElementById('u527');

u527.style.cursor = 'pointer';
if (bIE) u527.attachEvent("onclick", Clicku527);
else u527.addEventListener("click", Clicku527, true);
function Clicku527(e)
{

if (true) {

	self.location.href="B2B订单审批管理.html" + GetQuerystring();

}

}

var u181 = document.getElementById('u181');

var u491 = document.getElementById('u491');

var u747 = document.getElementById('u747');

u747.style.cursor = 'pointer';
if (bIE) u747.attachEvent("onclick", Clicku747);
else u747.addEventListener("click", Clicku747, true);
function Clicku747(e)
{

if (true) {

	self.location.href="售后入库.html" + GetQuerystring();

}

}

var u253 = document.getElementById('u253');

var u894 = document.getElementById('u894');

var u657 = document.getElementById('u657');

var u370 = document.getElementById('u370');
gv_vAlignTable['u370'] = 'center';
var u312 = document.getElementById('u312');
gv_vAlignTable['u312'] = 'center';
var u812 = document.getElementById('u812');
gv_vAlignTable['u812'] = 'center';
var u716 = document.getElementById('u716');
gv_vAlignTable['u716'] = 'top';
var u222 = document.getElementById('u222');
gv_vAlignTable['u222'] = 'center';
var u188 = document.getElementById('u188');
gv_vAlignTable['u188'] = 'center';
var u132 = document.getElementById('u132');
gv_vAlignTable['u132'] = 'center';
var u857 = document.getElementById('u857');

var u280 = document.getElementById('u280');
gv_vAlignTable['u280'] = 'center';
var u700 = document.getElementById('u700');
gv_vAlignTable['u700'] = 'top';
var u590 = document.getElementById('u590');
gv_vAlignTable['u590'] = 'top';
var u718 = document.getElementById('u718');

var u352 = document.getElementById('u352');
gv_vAlignTable['u352'] = 'center';
var u852 = document.getElementById('u852');
gv_vAlignTable['u852'] = 'center';
var u756 = document.getElementById('u756');
gv_vAlignTable['u756'] = 'center';
var u262 = document.getElementById('u262');
gv_vAlignTable['u262'] = 'center';
var u101 = document.getElementById('u101');

var u411 = document.getElementById('u411');

u411.style.cursor = 'pointer';
if (bIE) u411.attachEvent("onclick", Clicku411);
else u411.addEventListener("click", Clicku411, true);
function Clicku411(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u229 = document.getElementById('u229');

var u119 = document.getElementById('u119');

var u172 = document.getElementById('u172');
gv_vAlignTable['u172'] = 'center';
var u703 = document.getElementById('u703');

u703.style.cursor = 'pointer';
if (bIE) u703.attachEvent("onclick", Clicku703);
else u703.addEventListener("click", Clicku703, true);
function Clicku703(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u321 = document.getElementById('u321');

var u821 = document.getElementById('u821');

u821.style.cursor = 'pointer';
if (bIE) u821.attachEvent("onclick", Clicku821);
else u821.addEventListener("click", Clicku821, true);
function Clicku821(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u139 = document.getElementById('u139');

var u270 = document.getElementById('u270');
gv_vAlignTable['u270'] = 'center';
var u231 = document.getElementById('u231');

var u541 = document.getElementById('u541');

u541.style.cursor = 'pointer';
if (bIE) u541.attachEvent("onclick", Clicku541);
else u541.addEventListener("click", Clicku541, true);
function Clicku541(e)
{

if (true) {

	self.location.href="订单退款审核.html" + GetQuerystring();

}

}

var u451 = document.getElementById('u451');

u451.style.cursor = 'pointer';
if (bIE) u451.attachEvent("onclick", Clicku451);
else u451.addEventListener("click", Clicku451, true);
function Clicku451(e)
{

if (true) {

	self.location.href="要货申请单管理.html" + GetQuerystring();

}

}

var u797 = document.getElementById('u797');
gv_vAlignTable['u797'] = 'center';
var u269 = document.getElementById('u269');

var u108 = document.getElementById('u108');
gv_vAlignTable['u108'] = 'center';
var u841 = document.getElementById('u841');
gv_vAlignTable['u841'] = 'center';
var u361 = document.getElementById('u361');

var u424 = document.getElementById('u424');
gv_vAlignTable['u424'] = 'top';
var u179 = document.getElementById('u179');

var u513 = document.getElementById('u513');

u513.style.cursor = 'pointer';
if (bIE) u513.attachEvent("onclick", Clicku513);
else u513.addEventListener("click", Clicku513, true);
function Clicku513(e)
{

if (true) {

	self.location.href="B2B返利审核管理.html" + GetQuerystring();

}

}

var u2 = document.getElementById('u2');

var u828 = document.getElementById('u828');

u828.style.cursor = 'pointer';
if (bIE) u828.attachEvent("onclick", Clicku828);
else u828.addEventListener("click", Clicku828, true);
function Clicku828(e)
{

if (true) {

	self.location.href="辅助余额表查询.html" + GetQuerystring();

}

}

var u13 = document.getElementById('u13');

var u671 = document.getElementById('u671');

u671.style.cursor = 'pointer';
if (bIE) u671.attachEvent("onclick", Clicku671);
else u671.addEventListener("click", Clicku671, true);
function Clicku671(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u271 = document.getElementById('u271');

var u124 = document.getElementById('u124');
gv_vAlignTable['u124'] = 'center';
var u238 = document.getElementById('u238');
gv_vAlignTable['u238'] = 'center';
var u330 = document.getElementById('u330');
gv_vAlignTable['u330'] = 'center';
var u830 = document.getElementById('u830');

var u640 = document.getElementById('u640');
gv_vAlignTable['u640'] = 'top';
var u148 = document.getElementById('u148');
gv_vAlignTable['u148'] = 'center';
var u182 = document.getElementById('u182');
gv_vAlignTable['u182'] = 'center';
var u458 = document.getElementById('u458');
gv_vAlignTable['u458'] = 'top';
var u603 = document.getElementById('u603');

u603.style.cursor = 'pointer';
if (bIE) u603.attachEvent("onclick", Clicku603);
else u603.addEventListener("click", Clicku603, true);
function Clicku603(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u26 = document.getElementById('u26');
gv_vAlignTable['u26'] = 'center';
var u550 = document.getElementById('u550');
gv_vAlignTable['u550'] = 'top';
var u368 = document.getElementById('u368');
gv_vAlignTable['u368'] = 'center';
var u868 = document.getElementById('u868');

u868.style.cursor = 'pointer';
if (bIE) u868.attachEvent("onclick", Clicku868);
else u868.addEventListener("click", Clicku868, true);
function Clicku868(e)
{

if (true) {

	self.location.href="财务报表管理.html" + GetQuerystring();

}

}

var u17 = document.getElementById('u17');

var u460 = document.getElementById('u460');
gv_vAlignTable['u460'] = 'top';
var u313 = document.getElementById('u313');

var u813 = document.getElementById('u813');

u813.style.cursor = 'pointer';
if (bIE) u813.attachEvent("onclick", Clicku813);
else u813.addEventListener("click", Clicku813, true);
function Clicku813(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u867 = document.getElementById('u867');
gv_vAlignTable['u867'] = 'center';
var u224 = document.getElementById('u224');
gv_vAlignTable['u224'] = 'center';
var u717 = document.getElementById('u717');

var u870 = document.getElementById('u870');
gv_vAlignTable['u870'] = 'center';
var u223 = document.getElementById('u223');

var u728 = document.getElementById('u728');
gv_vAlignTable['u728'] = 'top';
var u324 = document.getElementById('u324');
gv_vAlignTable['u324'] = 'center';
var u189 = document.getElementById('u189');

var u627 = document.getElementById('u627');

u627.style.cursor = 'pointer';
if (bIE) u627.attachEvent("onclick", Clicku627);
else u627.addEventListener("click", Clicku627, true);
function Clicku627(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u133 = document.getElementById('u133');

var u281 = document.getElementById('u281');

var u591 = document.getElementById('u591');

u591.style.cursor = 'pointer';
if (bIE) u591.attachEvent("onclick", Clicku591);
else u591.addEventListener("click", Clicku591, true);
function Clicku591(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u851 = document.getElementById('u851');

var u353 = document.getElementById('u353');

var u853 = document.getElementById('u853');

var u713 = document.getElementById('u713');

u713.style.cursor = 'pointer';
if (bIE) u713.attachEvent("onclick", Clicku713);
else u713.addEventListener("click", Clicku713, true);
function Clicku713(e)
{

if (true) {

	self.location.href="库存盘点_1.html" + GetQuerystring();

}

}

var u387 = document.getElementById('u387');

var u757 = document.getElementById('u757');

var u503 = document.getElementById('u503');

u503.style.cursor = 'pointer';
if (bIE) u503.attachEvent("onclick", Clicku503);
else u503.addEventListener("click", Clicku503, true);
function Clicku503(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u263 = document.getElementById('u263');

var u102 = document.getElementById('u102');
gv_vAlignTable['u102'] = 'center';
var u412 = document.getElementById('u412');
gv_vAlignTable['u412'] = 'top';
var u260 = document.getElementById('u260');
gv_vAlignTable['u260'] = 'center';
var u173 = document.getElementById('u173');

var u18 = document.getElementById('u18');
gv_vAlignTable['u18'] = 'center';
var u322 = document.getElementById('u322');
gv_vAlignTable['u322'] = 'center';
var u822 = document.getElementById('u822');

var u474 = document.getElementById('u474');
gv_vAlignTable['u474'] = 'top';
var u288 = document.getElementById('u288');
gv_vAlignTable['u288'] = 'center';
var u232 = document.getElementById('u232');
gv_vAlignTable['u232'] = 'center';
var u380 = document.getElementById('u380');
gv_vAlignTable['u380'] = 'center';
var u880 = document.getElementById('u880');
gv_vAlignTable['u880'] = 'top';
var u690 = document.getElementById('u690');

var u198 = document.getElementById('u198');
gv_vAlignTable['u198'] = 'center';
var u142 = document.getElementById('u142');
gv_vAlignTable['u142'] = 'center';
var u452 = document.getElementById('u452');
gv_vAlignTable['u452'] = 'top';
var u481 = document.getElementById('u481');

var u109 = document.getElementById('u109');

var u877 = document.getElementById('u877');
gv_vAlignTable['u877'] = 'top';
var u560 = document.getElementById('u560');
gv_vAlignTable['u560'] = 'top';
var u362 = document.getElementById('u362');
gv_vAlignTable['u362'] = 'center';
var u201 = document.getElementById('u201');

var u511 = document.getElementById('u511');

u511.style.cursor = 'pointer';
if (bIE) u511.attachEvent("onclick", Clicku511);
else u511.addEventListener("click", Clicku511, true);
function Clicku511(e)
{

if (true) {

	self.location.href="B2B返利管理.html" + GetQuerystring();

}

}

var u459 = document.getElementById('u459');

u459.style.cursor = 'pointer';
if (bIE) u459.attachEvent("onclick", Clicku459);
else u459.addEventListener("click", Clicku459, true);
function Clicku459(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u329 = document.getElementById('u329');

var u829 = document.getElementById('u829');

var u898 = document.getElementById('u898');

var u272 = document.getElementById('u272');
gv_vAlignTable['u272'] = 'center';
var u421 = document.getElementById('u421');

var u239 = document.getElementById('u239');

var u861 = document.getElementById('u861');
gv_vAlignTable['u861'] = 'center';
var u331 = document.getElementById('u331');

var u831 = document.getElementById('u831');

var u641 = document.getElementById('u641');

u641.style.cursor = 'pointer';
if (bIE) u641.attachEvent("onclick", Clicku641);
else u641.addEventListener("click", Clicku641, true);
function Clicku641(e)
{

if (true) {

	self.location.href="合同文件管理.html" + "";

}

}

var u149 = document.getElementById('u149');

var u183 = document.getElementById('u183');

var u10 = document.getElementById('u10');
gv_vAlignTable['u10'] = 'center';
var u551 = document.getElementById('u551');

u551.style.cursor = 'pointer';
if (bIE) u551.attachEvent("onclick", Clicku551);
else u551.addEventListener("click", Clicku551, true);
function Clicku551(e)
{

if (true) {

	self.location.href="发货单管理.html" + GetQuerystring();

}

}

var u369 = document.getElementById('u369');

var u208 = document.getElementById('u208');
gv_vAlignTable['u208'] = 'center';
var u165 = document.getElementById('u165');

var u279 = document.getElementById('u279');

var u528 = document.getElementById('u528');
gv_vAlignTable['u528'] = 'top';
var u3 = document.getElementById('u3');

var u8 = document.getElementById('u8');
gv_vAlignTable['u8'] = 'center';
var u23 = document.getElementById('u23');

var u371 = document.getElementById('u371');

var u871 = document.getElementById('u871');

var u520 = document.getElementById('u520');
gv_vAlignTable['u520'] = 'top';
var u338 = document.getElementById('u338');
gv_vAlignTable['u338'] = 'center';
var u838 = document.getElementById('u838');
gv_vAlignTable['u838'] = 'center';
var u14 = document.getElementById('u14');
gv_vAlignTable['u14'] = 'center';
var u846 = document.getElementById('u846');

var u134 = document.getElementById('u134');
gv_vAlignTable['u134'] = 'center';
var u234 = document.getElementById('u234');
gv_vAlignTable['u234'] = 'center';
var u740 = document.getElementById('u740');
gv_vAlignTable['u740'] = 'top';
var u248 = document.getElementById('u248');
gv_vAlignTable['u248'] = 'center';
var u282 = document.getElementById('u282');
gv_vAlignTable['u282'] = 'center';
var u558 = document.getElementById('u558');

var u36 = document.getElementById('u36');
gv_vAlignTable['u36'] = 'center';
var u86 = document.getElementById('u86');
gv_vAlignTable['u86'] = 'center';
var u650 = document.getElementById('u650');
gv_vAlignTable['u650'] = 'top';
var u854 = document.getElementById('u854');
gv_vAlignTable['u854'] = 'center';
var u192 = document.getElementById('u192');
gv_vAlignTable['u192'] = 'center';
var u468 = document.getElementById('u468');

var u27 = document.getElementById('u27');

var u264 = document.getElementById('u264');
gv_vAlignTable['u264'] = 'center';
var u103 = document.getElementById('u103');

var u413 = document.getElementById('u413');

u413.style.cursor = 'pointer';
if (bIE) u413.attachEvent("onclick", Clicku413);
else u413.addEventListener("click", Clicku413, true);
function Clicku413(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u878 = document.getElementById('u878');
gv_vAlignTable['u878'] = 'top';
var u174 = document.getElementById('u174');
gv_vAlignTable['u174'] = 'center';
var u323 = document.getElementById('u323');

var u823 = document.getElementById('u823');
gv_vAlignTable['u823'] = 'center';
var u600 = document.getElementById('u600');

if (window.OnLoad) OnLoad();
