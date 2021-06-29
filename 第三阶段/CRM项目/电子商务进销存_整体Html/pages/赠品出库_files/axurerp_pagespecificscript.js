
var PageName = '赠品出库';
var PageId = 'pd8b7f360c1a9452583b056af73a5ce7f'
var PageUrl = '赠品出库.html'
document.title = '赠品出库';

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

eval(GetDynamicPanelScript('u362', 2));

var u289 = document.getElementById('u289');
gv_vAlignTable['u289'] = 'top';
var u733 = document.getElementById('u733');
gv_vAlignTable['u733'] = 'center';
var u966 = document.getElementById('u966');

var u893 = document.getElementById('u893');
gv_vAlignTable['u893'] = 'center';
var u433 = document.getElementById('u433');
gv_vAlignTable['u433'] = 'center';
var u381 = document.getElementById('u381');
gv_vAlignTable['u381'] = 'center';
var u881 = document.getElementById('u881');
gv_vAlignTable['u881'] = 'center';
var u691 = document.getElementById('u691');

var u199 = document.getElementById('u199');
gv_vAlignTable['u199'] = 'top';
var u143 = document.getElementById('u143');
gv_vAlignTable['u143'] = 'top';
var u453 = document.getElementById('u453');
gv_vAlignTable['u453'] = 'center';
var u953 = document.getElementById('u953');
gv_vAlignTable['u953'] = 'center';
var u134 = document.getElementById('u134');

u134.style.cursor = 'pointer';
if (bIE) u134.attachEvent("onclick", Clicku134);
else u134.addEventListener("click", Clicku134, true);
function Clicku134(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u413 = document.getElementById('u413');
gv_vAlignTable['u413'] = 'center';
var u796 = document.getElementById('u796');

var u363 = document.getElementById('u363');

var u202 = document.getElementById('u202');

u202.style.cursor = 'pointer';
if (bIE) u202.attachEvent("onclick", Clicku202);
else u202.addEventListener("click", Clicku202, true);
function Clicku202(e)
{

if (true) {

	self.location.href="订单退款管理.html" + GetQuerystring();

}

}

var u512 = document.getElementById('u512');

var u1048 = document.getElementById('u1048');
gv_vAlignTable['u1048'] = 'center';
var u454 = document.getElementById('u454');

var u273 = document.getElementById('u273');
gv_vAlignTable['u273'] = 'top';
var u28 = document.getElementById('u28');

var u422 = document.getElementById('u422');

var u648 = document.getElementById('u648');
gv_vAlignTable['u648'] = 'center';
var u244 = document.getElementById('u244');

u244.style.cursor = 'pointer';
if (bIE) u244.attachEvent("onclick", Clicku244);
else u244.addEventListener("click", Clicku244, true);
function Clicku244(e)
{

if (true) {

	self.location.href="销售入库.html" + GetQuerystring();

}

}

var u388 = document.getElementById('u388');

var u888 = document.getElementById('u888');

var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u332 = document.getElementById('u332');

u332.style.cursor = 'pointer';
if (bIE) u332.attachEvent("onclick", Clicku332);
else u332.addEventListener("click", Clicku332, true);
function Clicku332(e)
{

if (true) {

	self.location.href="B2B订单审批管理.html" + GetQuerystring();

}

}

var u832 = document.getElementById('u832');

var u480 = document.getElementById('u480');

var u980 = document.getElementById('u980');

var u790 = document.getElementById('u790');

var u298 = document.getElementById('u298');

u298.style.cursor = 'pointer';
if (bIE) u298.attachEvent("onclick", Clicku298);
else u298.addEventListener("click", Clicku298, true);
function Clicku298(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u242 = document.getElementById('u242');

u242.style.cursor = 'pointer';
if (bIE) u242.attachEvent("onclick", Clicku242);
else u242.addEventListener("click", Clicku242, true);
function Clicku242(e)
{

if (true) {

	self.location.href="采购入库.html" + GetQuerystring();

}

}

var u552 = document.getElementById('u552');

var u391 = document.getElementById('u391');
gv_vAlignTable['u391'] = 'center';
var u328 = document.getElementById('u328');

u328.style.cursor = 'pointer';
if (bIE) u328.attachEvent("onclick", Clicku328);
else u328.addEventListener("click", Clicku328, true);
function Clicku328(e)
{

if (true) {

	self.location.href="B2B预存款管理.html" + GetQuerystring();

}

}

var u209 = document.getElementById('u209');
gv_vAlignTable['u209'] = 'top';
var u118 = document.getElementById('u118');

u118.style.cursor = 'pointer';
if (bIE) u118.attachEvent("onclick", Clicku118);
else u118.addEventListener("click", Clicku118, true);
function Clicku118(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u702 = document.getElementById('u702');

var u462 = document.getElementById('u462');

var u301 = document.getElementById('u301');
gv_vAlignTable['u301'] = 'top';
var u801 = document.getElementById('u801');
gv_vAlignTable['u801'] = 'center';
var u611 = document.getElementById('u611');
gv_vAlignTable['u611'] = 'center';
var u119 = document.getElementById('u119');
gv_vAlignTable['u119'] = 'top';
var u429 = document.getElementById('u429');
gv_vAlignTable['u429'] = 'center';
var u929 = document.getElementById('u929');
gv_vAlignTable['u929'] = 'center';
var u814 = document.getElementById('u814');

var u372 = document.getElementById('u372');

var u872 = document.getElementById('u872');

var u521 = document.getElementById('u521');
gv_vAlignTable['u521'] = 'center';
var u696 = document.getElementById('u696');

var u339 = document.getElementById('u339');
gv_vAlignTable['u339'] = 'center';
var u839 = document.getElementById('u839');
gv_vAlignTable['u839'] = 'center';
var u431 = document.getElementById('u431');
gv_vAlignTable['u431'] = 'center';
var u931 = document.getElementById('u931');
gv_vAlignTable['u931'] = 'top';
var u741 = document.getElementById('u741');
gv_vAlignTable['u741'] = 'center';
var u249 = document.getElementById('u249');
gv_vAlignTable['u249'] = 'top';
var u283 = document.getElementById('u283');
gv_vAlignTable['u283'] = 'top';
var u840 = document.getElementById('u840');

var u20 = document.getElementById('u20');

var u651 = document.getElementById('u651');

var u159 = document.getElementById('u159');
gv_vAlignTable['u159'] = 'top';
var u193 = document.getElementById('u193');
gv_vAlignTable['u193'] = 'top';
var u469 = document.getElementById('u469');
gv_vAlignTable['u469'] = 'center';
var u308 = document.getElementById('u308');

u308.style.cursor = 'pointer';
if (bIE) u308.attachEvent("onclick", Clicku308);
else u308.addEventListener("click", Clicku308, true);
function Clicku308(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u808 = document.getElementById('u808');

var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u265 = document.getElementById('u265');
gv_vAlignTable['u265'] = 'top';
var u104 = document.getElementById('u104');

u104.style.cursor = 'pointer';
if (bIE) u104.attachEvent("onclick", Clicku104);
else u104.addEventListener("click", Clicku104, true);
function Clicku104(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u710 = document.getElementById('u710');

var u218 = document.getElementById('u218');

u218.style.cursor = 'pointer';
if (bIE) u218.attachEvent("onclick", Clicku218);
else u218.addEventListener("click", Clicku218, true);
function Clicku218(e)
{

if (true) {

	self.location.href="库存盘点_1.html" + GetQuerystring();

}

}

var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'top';
var u228 = document.getElementById('u228');

u228.style.cursor = 'pointer';
if (bIE) u228.attachEvent("onclick", Clicku228);
else u228.addEventListener("click", Clicku228, true);
function Clicku228(e)
{

if (true) {

	self.location.href="售后出库.html" + GetQuerystring();

}

}

var u83 = document.getElementById('u83');
gv_vAlignTable['u83'] = 'top';
var u175 = document.getElementById('u175');
gv_vAlignTable['u175'] = 'top';
var u971 = document.getElementById('u971');
gv_vAlignTable['u971'] = 'top';
var u620 = document.getElementById('u620');

var u824 = document.getElementById('u824');

var u438 = document.getElementById('u438');

var u938 = document.getElementById('u938');

var u24 = document.getElementById('u24');

u24.style.cursor = 'pointer';
if (bIE) u24.attachEvent("onclick", Clicku24);
else u24.addEventListener("click", Clicku24, true);
function Clicku24(e)
{

if (true) {

	self.location.href="财务管理.html" + GetQuerystring();

}

}

var u269 = document.getElementById('u269');
gv_vAlignTable['u269'] = 'top';
var u234 = document.getElementById('u234');

var u958 = document.getElementById('u958');

var u348 = document.getElementById('u348');

var u848 = document.getElementById('u848');

var u658 = document.getElementById('u658');
gv_vAlignTable['u658'] = 'center';
var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u46 = document.getElementById('u46');

u46.style.cursor = 'pointer';
if (bIE) u46.attachEvent("onclick", Clicku46);
else u46.addEventListener("click", Clicku46, true);
function Clicku46(e)
{

if (true) {

	self.location.href="IP访问限制管理.html" + "";

}

}

var u96 = document.getElementById('u96');

u96.style.cursor = 'pointer';
if (bIE) u96.attachEvent("onclick", Clicku96);
else u96.addEventListener("click", Clicku96, true);
function Clicku96(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u144 = document.getElementById('u144');

var u750 = document.getElementById('u750');

var u954 = document.getElementById('u954');

var u292 = document.getElementById('u292');

u292.style.cursor = 'pointer';
if (bIE) u292.attachEvent("onclick", Clicku292);
else u292.addEventListener("click", Clicku292, true);
function Clicku292(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u568 = document.getElementById('u568');

var u379 = document.getElementById('u379');
gv_vAlignTable['u379'] = 'top';
var u866 = document.getElementById('u866');

var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'top';
var u87 = document.getElementById('u87');
gv_vAlignTable['u87'] = 'top';
var u254 = document.getElementById('u254');

u254.style.cursor = 'pointer';
if (bIE) u254.attachEvent("onclick", Clicku254);
else u254.addEventListener("click", Clicku254, true);
function Clicku254(e)
{

if (true) {

	self.location.href="入库单审核.html" + GetQuerystring();

}

}

var u364 = document.getElementById('u364');

var u203 = document.getElementById('u203');
gv_vAlignTable['u203'] = 'top';
var u478 = document.getElementById('u478');

var u978 = document.getElementById('u978');

var u274 = document.getElementById('u274');

u274.style.cursor = 'pointer';
if (bIE) u274.attachEvent("onclick", Clicku274);
else u274.addEventListener("click", Clicku274, true);
function Clicku274(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1057 = document.getElementById('u1057');

u1057.style.cursor = 'pointer';
if (bIE) u1057.attachEvent("onclick", Clicku1057);
else u1057.addEventListener("click", Clicku1057, true);
function Clicku1057(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u1056 = document.getElementById('u1056');
gv_vAlignTable['u1056'] = 'center';
var u423 = document.getElementById('u423');
gv_vAlignTable['u423'] = 'center';
var u976 = document.getElementById('u976');

var u768 = document.getElementById('u768');

var u1052 = document.getElementById('u1052');
gv_vAlignTable['u1052'] = 'center';
var u1051 = document.getElementById('u1051');

u1051.style.cursor = 'pointer';
if (bIE) u1051.attachEvent("onclick", Clicku1051);
else u1051.addEventListener("click", Clicku1051, true);
function Clicku1051(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u1050 = document.getElementById('u1050');
gv_vAlignTable['u1050'] = 'center';
var u389 = document.getElementById('u389');
gv_vAlignTable['u389'] = 'center';
var u889 = document.getElementById('u889');
gv_vAlignTable['u889'] = 'center';
var u333 = document.getElementById('u333');
gv_vAlignTable['u333'] = 'top';
var u833 = document.getElementById('u833');
gv_vAlignTable['u833'] = 'center';
var u481 = document.getElementById('u481');
gv_vAlignTable['u481'] = 'center';
var u386 = document.getElementById('u386');

var u791 = document.getElementById('u791');
gv_vAlignTable['u791'] = 'top';
var u299 = document.getElementById('u299');
gv_vAlignTable['u299'] = 'top';
var u502 = document.getElementById('u502');

var u243 = document.getElementById('u243');
gv_vAlignTable['u243'] = 'top';
var u553 = document.getElementById('u553');
gv_vAlignTable['u553'] = 'center';
var u463 = document.getElementById('u463');
gv_vAlignTable['u463'] = 'center';
var u302 = document.getElementById('u302');

u302.style.cursor = 'pointer';
if (bIE) u302.attachEvent("onclick", Clicku302);
else u302.addEventListener("click", Clicku302, true);
function Clicku302(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u802 = document.getElementById('u802');

var u612 = document.getElementById('u612');

var u919 = document.getElementById('u919');
gv_vAlignTable['u919'] = 'center';
var u373 = document.getElementById('u373');
gv_vAlignTable['u373'] = 'top';
var u38 = document.getElementById('u38');

var u88 = document.getElementById('u88');

u88.style.cursor = 'pointer';
if (bIE) u88.attachEvent("onclick", Clicku88);
else u88.addEventListener("click", Clicku88, true);
function Clicku88(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u154 = document.getElementById('u154');

u154.style.cursor = 'pointer';
if (bIE) u154.attachEvent("onclick", Clicku154);
else u154.addEventListener("click", Clicku154, true);
function Clicku154(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u354 = document.getElementById('u354');
gv_vAlignTable['u354'] = 'center';
var u488 = document.getElementById('u488');

var u988 = document.getElementById('u988');

var u29 = document.getElementById('u29');

var u432 = document.getElementById('u432');

var u932 = document.getElementById('u932');

var u580 = document.getElementById('u580');

var u398 = document.getElementById('u398');

var u876 = document.getElementById('u876');

var u342 = document.getElementById('u342');

var u842 = document.getElementById('u842');

var u652 = document.getElementById('u652');
gv_vAlignTable['u652'] = 'center';
var u194 = document.getElementById('u194');

var u309 = document.getElementById('u309');
gv_vAlignTable['u309'] = 'top';
var u809 = document.getElementById('u809');
gv_vAlignTable['u809'] = 'center';
var u749 = document.getElementById('u749');
gv_vAlignTable['u749'] = 'center';
var u562 = document.getElementById('u562');

var u401 = document.getElementById('u401');
gv_vAlignTable['u401'] = 'center';
var u901 = document.getElementById('u901');
gv_vAlignTable['u901'] = 'center';
var u711 = document.getElementById('u711');
gv_vAlignTable['u711'] = 'top';
var u219 = document.getElementById('u219');
gv_vAlignTable['u219'] = 'top';
var u529 = document.getElementById('u529');
gv_vAlignTable['u529'] = 'center';
var u374 = document.getElementById('u374');

var u472 = document.getElementById('u472');

var u972 = document.getElementById('u972');

var u325 = document.getElementById('u325');
gv_vAlignTable['u325'] = 'top';
var u825 = document.getElementById('u825');
gv_vAlignTable['u825'] = 'center';
var u443 = document.getElementById('u443');
gv_vAlignTable['u443'] = 'top';
var u439 = document.getElementById('u439');
gv_vAlignTable['u439'] = 'center';
var u939 = document.getElementById('u939');
gv_vAlignTable['u939'] = 'center';
var u722 = document.getElementById('u722');

var u882 = document.getElementById('u882');

var u235 = document.getElementById('u235');

var u349 = document.getElementById('u349');
gv_vAlignTable['u349'] = 'center';
var u849 = document.getElementById('u849');
gv_vAlignTable['u849'] = 'center';
var u883 = document.getElementById('u883');
gv_vAlignTable['u883'] = 'center';
var u763 = document.getElementById('u763');
gv_vAlignTable['u763'] = 'center';
var u30 = document.getElementById('u30');

u30.style.cursor = 'pointer';
if (bIE) u30.attachEvent("onclick", Clicku30);
else u30.addEventListener("click", Clicku30, true);
function Clicku30(e)
{

if (true) {

	self.location.href="EMS单据管理.html" + GetQuerystring();

}

}

var u80 = document.getElementById('u80');

u80.style.cursor = 'pointer';
if (bIE) u80.attachEvent("onclick", Clicku80);
else u80.addEventListener("click", Clicku80, true);
function Clicku80(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u145 = document.getElementById('u145');

var u751 = document.getElementById('u751');
gv_vAlignTable['u751'] = 'top';
var u259 = document.getElementById('u259');

var u293 = document.getElementById('u293');
gv_vAlignTable['u293'] = 'top';
var u569 = document.getElementById('u569');
gv_vAlignTable['u569'] = 'center';
var u408 = document.getElementById('u408');

var u908 = document.getElementById('u908');

var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
var u782 = document.getElementById('u782');

var u365 = document.getElementById('u365');
gv_vAlignTable['u365'] = 'top';
var u204 = document.getElementById('u204');

u204.style.cursor = 'pointer';
if (bIE) u204.attachEvent("onclick", Clicku204);
else u204.addEventListener("click", Clicku204, true);
function Clicku204(e)
{

if (true) {

	self.location.href="订单退款审核.html" + GetQuerystring();

}

}

var u479 = document.getElementById('u479');
gv_vAlignTable['u479'] = 'center';
var u164 = document.getElementById('u164');

u164.style.cursor = 'pointer';
if (bIE) u164.attachEvent("onclick", Clicku164);
else u164.addEventListener("click", Clicku164, true);
function Clicku164(e)
{

if (true) {

	self.location.href="请购单审核管理.html" + GetQuerystring();

}

}

var u818 = document.getElementById('u818');

var u628 = document.getElementById('u628');
gv_vAlignTable['u628'] = 'top';
var u12 = document.getElementById('u12');

u12.style.cursor = 'pointer';
if (bIE) u12.attachEvent("onclick", Clicku12);
else u12.addEventListener("click", Clicku12, true);
function Clicku12(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u43 = document.getElementById('u43');
gv_vAlignTable['u43'] = 'top';
var u93 = document.getElementById('u93');
gv_vAlignTable['u93'] = 'top';
var u571 = document.getElementById('u571');
gv_vAlignTable['u571'] = 'top';
var u114 = document.getElementById('u114');

u114.style.cursor = 'pointer';
if (bIE) u114.attachEvent("onclick", Clicku114);
else u114.addEventListener("click", Clicku114, true);
function Clicku114(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u233 = document.getElementById('u233');
gv_vAlignTable['u233'] = 'top';
var u424 = document.getElementById('u424');

var u924 = document.getElementById('u924');

var u186 = document.getElementById('u186');

u186.style.cursor = 'pointer';
if (bIE) u186.attachEvent("onclick", Clicku186);
else u186.addEventListener("click", Clicku186, true);
function Clicku186(e)
{

if (true) {

	self.location.href="应收_应付管理.html" + GetQuerystring();

}

}

var u538 = document.getElementById('u538');

var u1061 = document.getElementById('u1061');

var u1060 = document.getElementById('u1060');
gv_vAlignTable['u1060'] = 'center';
var u34 = document.getElementById('u34');

u34.style.cursor = 'pointer';
if (bIE) u34.attachEvent("onclick", Clicku34);
else u34.addEventListener("click", Clicku34, true);
function Clicku34(e)
{

if (true) {

	self.location.href="发货状态管理.html" + GetQuerystring();

}

}

var u84 = document.getElementById('u84');

u84.style.cursor = 'pointer';
if (bIE) u84.attachEvent("onclick", Clicku84);
else u84.addEventListener("click", Clicku84, true);
function Clicku84(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u334 = document.getElementById('u334');

u334.style.cursor = 'pointer';
if (bIE) u334.attachEvent("onclick", Clicku334);
else u334.addEventListener("click", Clicku334, true);
function Clicku334(e)
{

if (true) {

	self.location.href="B2B出库管理.html" + GetQuerystring();

}

}

var u834 = document.getElementById('u834');

var u448 = document.getElementById('u448');

var u482 = document.getElementById('u482');

var u758 = document.getElementById('u758');

var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u56 = document.getElementById('u56');

u56.style.cursor = 'pointer';
if (bIE) u56.attachEvent("onclick", Clicku56);
else u56.addEventListener("click", Clicku56, true);
function Clicku56(e)
{

if (true) {

	self.location.href="审批流程管理.html" + "";

}

}

var u622 = document.getElementById('u622');
gv_vAlignTable['u622'] = 'top';
var u296 = document.getElementById('u296');

var u554 = document.getElementById('u554');

var u392 = document.getElementById('u392');

var u668 = document.getElementById('u668');
gv_vAlignTable['u668'] = 'center';
var u47 = document.getElementById('u47');
gv_vAlignTable['u47'] = 'top';
var u97 = document.getElementById('u97');
gv_vAlignTable['u97'] = 'top';
var u663 = document.getElementById('u663');

var u464 = document.getElementById('u464');

var u303 = document.getElementById('u303');
gv_vAlignTable['u303'] = 'top';
var u803 = document.getElementById('u803');
gv_vAlignTable['u803'] = 'center';
var u613 = document.getElementById('u613');
gv_vAlignTable['u613'] = 'center';
var u732 = document.getElementById('u732');

var u670 = document.getElementById('u670');
gv_vAlignTable['u670'] = 'center';
var u892 = document.getElementById('u892');

var u523 = document.getElementById('u523');
gv_vAlignTable['u523'] = 'top';
var u489 = document.getElementById('u489');
gv_vAlignTable['u489'] = 'center';
var u989 = document.getElementById('u989');
gv_vAlignTable['u989'] = 'center';
var u137 = document.getElementById('u137');
gv_vAlignTable['u137'] = 'top';
var u933 = document.getElementById('u933');
gv_vAlignTable['u933'] = 'center';
var u581 = document.getElementById('u581');
gv_vAlignTable['u581'] = 'center';
var u399 = document.getElementById('u399');
gv_vAlignTable['u399'] = 'center';
var u899 = document.getElementById('u899');
gv_vAlignTable['u899'] = 'center';
var u343 = document.getElementById('u343');
gv_vAlignTable['u343'] = 'center';
var u843 = document.getElementById('u843');
gv_vAlignTable['u843'] = 'center';
var u653 = document.getElementById('u653');

u653.style.cursor = 'pointer';
if (bIE) u653.attachEvent("onclick", Clicku653);
else u653.addEventListener("click", Clicku653, true);
function Clicku653(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u975 = document.getElementById('u975');
gv_vAlignTable['u975'] = 'center';
var u195 = document.getElementById('u195');

var u578 = document.getElementById('u578');

var u174 = document.getElementById('u174');

u174.style.cursor = 'pointer';
if (bIE) u174.attachEvent("onclick", Clicku174);
else u174.addEventListener("click", Clicku174, true);
function Clicku174(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u267 = document.getElementById('u267');

var u402 = document.getElementById('u402');

var u902 = document.getElementById('u902');

var u712 = document.getElementById('u712');

var u196 = document.getElementById('u196');

u196.style.cursor = 'pointer';
if (bIE) u196.attachEvent("onclick", Clicku196);
else u196.addEventListener("click", Clicku196, true);
function Clicku196(e)
{

if (true) {

	self.location.href="充值订单管理.html" + GetQuerystring();

}

}

var u717 = document.getElementById('u717');
gv_vAlignTable['u717'] = 'center';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u473 = document.getElementById('u473');
gv_vAlignTable['u473'] = 'center';
var u973 = document.getElementById('u973');
gv_vAlignTable['u973'] = 'center';
var u98 = document.getElementById('u98');

u98.style.cursor = 'pointer';
if (bIE) u98.attachEvent("onclick", Clicku98);
else u98.addEventListener("click", Clicku98, true);
function Clicku98(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u326 = document.getElementById('u326');

u326.style.cursor = 'pointer';
if (bIE) u326.attachEvent("onclick", Clicku326);
else u326.addEventListener("click", Clicku326, true);
function Clicku326(e)
{

if (true) {

	self.location.href="B2B电子渠道审核管理.html" + GetQuerystring();

}

}

var u826 = document.getElementById('u826');

var u563 = document.getElementById('u563');
gv_vAlignTable['u563'] = 'center';
var u588 = document.getElementById('u588');

var u965 = document.getElementById('u965');
gv_vAlignTable['u965'] = 'center';
var u39 = document.getElementById('u39');

var u89 = document.getElementById('u89');
gv_vAlignTable['u89'] = 'top';
var u532 = document.getElementById('u532');

var u632 = document.getElementById('u632');

var u384 = document.getElementById('u384');

var u884 = document.getElementById('u884');

var u498 = document.getElementById('u498');

var u998 = document.getElementById('u998');

var u701 = document.getElementById('u701');
gv_vAlignTable['u701'] = 'top';
var u146 = document.getElementById('u146');

u146.style.cursor = 'pointer';
if (bIE) u146.attachEvent("onclick", Clicku146);
else u146.addEventListener("click", Clicku146, true);
function Clicku146(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u942 = document.getElementById('u942');

var u752 = document.getElementById('u752');

var u294 = document.getElementById('u294');

u294.style.cursor = 'pointer';
if (bIE) u294.attachEvent("onclick", Clicku294);
else u294.addEventListener("click", Clicku294, true);
function Clicku294(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u981 = document.getElementById('u981');
gv_vAlignTable['u981'] = 'center';
var u409 = document.getElementById('u409');
gv_vAlignTable['u409'] = 'center';
var u909 = document.getElementById('u909');
gv_vAlignTable['u909'] = 'center';
var u742 = document.getElementById('u742');

var u662 = document.getElementById('u662');
gv_vAlignTable['u662'] = 'center';
var u205 = document.getElementById('u205');
gv_vAlignTable['u205'] = 'top';
var u319 = document.getElementById('u319');
gv_vAlignTable['u319'] = 'top';
var u819 = document.getElementById('u819');
gv_vAlignTable['u819'] = 'center';
var u507 = document.getElementById('u507');
gv_vAlignTable['u507'] = 'top';
var u572 = document.getElementById('u572');

var u115 = document.getElementById('u115');
gv_vAlignTable['u115'] = 'top';
var u1076 = document.getElementById('u1076');
gv_vAlignTable['u1076'] = 'center';
var u425 = document.getElementById('u425');
gv_vAlignTable['u425'] = 'center';
var u925 = document.getElementById('u925');
gv_vAlignTable['u925'] = 'center';
var u1073 = document.getElementById('u1073');

var u539 = document.getElementById('u539');
gv_vAlignTable['u539'] = 'top';
var u1071 = document.getElementById('u1071');

var u1070 = document.getElementById('u1070');
gv_vAlignTable['u1070'] = 'center';
var u1084 = document.getElementById('u1084');

var u631 = document.getElementById('u631');
gv_vAlignTable['u631'] = 'top';
var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'top';
var u1080 = document.getElementById('u1080');

var u449 = document.getElementById('u449');
gv_vAlignTable['u449'] = 'center';
var u483 = document.getElementById('u483');
gv_vAlignTable['u483'] = 'center';
var u983 = document.getElementById('u983');
gv_vAlignTable['u983'] = 'center';
var u40 = document.getElementById('u40');

u40.style.cursor = 'pointer';
if (bIE) u40.attachEvent("onclick", Clicku40);
else u40.addEventListener("click", Clicku40, true);
function Clicku40(e)
{

if (true) {

	self.location.href="用户管理.html" + "";

}

}

var u90 = document.getElementById('u90');

var u245 = document.getElementById('u245');
gv_vAlignTable['u245'] = 'top';
var u359 = document.getElementById('u359');
gv_vAlignTable['u359'] = 'center';
var u393 = document.getElementById('u393');
gv_vAlignTable['u393'] = 'center';
var u669 = document.getElementById('u669');

u669.style.cursor = 'pointer';
if (bIE) u669.attachEvent("onclick", Clicku669);
else u669.addEventListener("click", Clicku669, true);
function Clicku669(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u508 = document.getElementById('u508');

var u290 = document.getElementById('u290');

u290.style.cursor = 'pointer';
if (bIE) u290.attachEvent("onclick", Clicku290);
else u290.addEventListener("click", Clicku290, true);
function Clicku290(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u31 = document.getElementById('u31');
gv_vAlignTable['u31'] = 'top';
var u81 = document.getElementById('u81');
gv_vAlignTable['u81'] = 'top';
var u155 = document.getElementById('u155');
gv_vAlignTable['u155'] = 'top';
var u465 = document.getElementById('u465');
gv_vAlignTable['u465'] = 'center';
var u304 = document.getElementById('u304');

u304.style.cursor = 'pointer';
if (bIE) u304.attachEvent("onclick", Clicku304);
else u304.addEventListener("click", Clicku304, true);
function Clicku304(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u804 = document.getElementById('u804');

var u579 = document.getElementById('u579');
gv_vAlignTable['u579'] = 'center';
var u418 = document.getElementById('u418');

var u918 = document.getElementById('u918');

var u6 = document.getElementById('u6');

var u22 = document.getElementById('u22');

u22.style.cursor = 'pointer';
if (bIE) u22.attachEvent("onclick", Clicku22);
else u22.addEventListener("click", Clicku22, true);
function Clicku22(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u53 = document.getElementById('u53');
gv_vAlignTable['u53'] = 'top';
var u375 = document.getElementById('u375');
gv_vAlignTable['u375'] = 'top';
var u214 = document.getElementById('u214');

u214.style.cursor = 'pointer';
if (bIE) u214.attachEvent("onclick", Clicku214);
else u214.addEventListener("click", Clicku214, true);
function Clicku214(e)
{

if (true) {

	self.location.href="出库管理.html" + GetQuerystring();

}

}

var u181 = document.getElementById('u181');
gv_vAlignTable['u181'] = 'top';
var u524 = document.getElementById('u524');

var u638 = document.getElementById('u638');

var u44 = document.getElementById('u44');

u44.style.cursor = 'pointer';
if (bIE) u44.attachEvent("onclick", Clicku44);
else u44.addEventListener("click", Clicku44, true);
function Clicku44(e)
{

if (true) {

	self.location.href="权限管理.html" + "";

}

}

var u94 = document.getElementById('u94');

u94.style.cursor = 'pointer';
if (bIE) u94.attachEvent("onclick", Clicku94);
else u94.addEventListener("click", Clicku94, true);
function Clicku94(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u730 = document.getElementById('u730');

var u934 = document.getElementById('u934');

var u548 = document.getElementById('u548');

var u286 = document.getElementById('u286');

u286.style.cursor = 'pointer';
if (bIE) u286.attachEvent("onclick", Clicku286);
else u286.addEventListener("click", Clicku286, true);
function Clicku286(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u865 = document.getElementById('u865');
gv_vAlignTable['u865'] = 'center';
var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'top';
var u85 = document.getElementById('u85');
gv_vAlignTable['u85'] = 'top';
var u66 = document.getElementById('u66');

var u344 = document.getElementById('u344');

var u844 = document.getElementById('u844');

var u654 = document.getElementById('u654');
gv_vAlignTable['u654'] = 'center';
var u492 = document.getElementById('u492');

var u992 = document.getElementById('u992');

var u57 = document.getElementById('u57');
gv_vAlignTable['u57'] = 'top';
var u517 = document.getElementById('u517');
gv_vAlignTable['u517'] = 'center';
var u949 = document.getElementById('u949');
gv_vAlignTable['u949'] = 'center';
var u564 = document.getElementById('u564');

var u403 = document.getElementById('u403');
gv_vAlignTable['u403'] = 'center';
var u903 = document.getElementById('u903');
gv_vAlignTable['u903'] = 'center';
var u678 = document.getElementById('u678');
gv_vAlignTable['u678'] = 'center';
var u770 = document.getElementById('u770');

var u974 = document.getElementById('u974');

var u623 = document.getElementById('u623');

var u385 = document.getElementById('u385');
gv_vAlignTable['u385'] = 'center';
var u589 = document.getElementById('u589');
gv_vAlignTable['u589'] = 'center';
var u501 = document.getElementById('u501');
gv_vAlignTable['u501'] = 'center';
var u168 = document.getElementById('u168');

u168.style.cursor = 'pointer';
if (bIE) u168.attachEvent("onclick", Clicku168);
else u168.addEventListener("click", Clicku168, true);
function Clicku168(e)
{

if (true) {

	self.location.href="要货申请单管理.html" + GetQuerystring();

}

}

var u533 = document.getElementById('u533');
gv_vAlignTable['u533'] = 'center';
var u681 = document.getElementById('u681');

u681.style.cursor = 'pointer';
if (bIE) u681.attachEvent("onclick", Clicku681);
else u681.addEventListener("click", Clicku681, true);
function Clicku681(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u885 = document.getElementById('u885');
gv_vAlignTable['u885'] = 'center';
var u499 = document.getElementById('u499');
gv_vAlignTable['u499'] = 'center';
var u999 = document.getElementById('u999');
gv_vAlignTable['u999'] = 'center';
var u1037 = document.getElementById('u1037');

u1037.style.cursor = 'pointer';
if (bIE) u1037.attachEvent("onclick", Clicku1037);
else u1037.addEventListener("click", Clicku1037, true);
function Clicku1037(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u147 = document.getElementById('u147');
gv_vAlignTable['u147'] = 'top';
var u943 = document.getElementById('u943');
gv_vAlignTable['u943'] = 'center';
var u753 = document.getElementById('u753');
gv_vAlignTable['u753'] = 'center';
var u1033 = document.getElementById('u1033');
gv_vAlignTable['u1033'] = 'top';
var u295 = document.getElementById('u295');
gv_vAlignTable['u295'] = 'top';
var u278 = document.getElementById('u278');

u278.style.cursor = 'pointer';
if (bIE) u278.attachEvent("onclick", Clicku278);
else u278.addEventListener("click", Clicku278, true);
function Clicku278(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u522 = document.getElementById('u522');

var u1039 = document.getElementById('u1039');

u1039.style.cursor = 'pointer';
if (bIE) u1039.attachEvent("onclick", Clicku1039);
else u1039.addEventListener("click", Clicku1039, true);
function Clicku1039(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u367 = document.getElementById('u367');
gv_vAlignTable['u367'] = 'top';
var u206 = document.getElementById('u206');

u206.style.cursor = 'pointer';
if (bIE) u206.attachEvent("onclick", Clicku206);
else u206.addEventListener("click", Clicku206, true);
function Clicku206(e)
{

if (true) {

	self.location.href="佣金结算管理.html" + GetQuerystring();

}

}

var u959 = document.getElementById('u959');
gv_vAlignTable['u959'] = 'center';
var u573 = document.getElementById('u573');
gv_vAlignTable['u573'] = 'center';
var u58 = document.getElementById('u58');

u58.style.cursor = 'pointer';
if (bIE) u58.attachEvent("onclick", Clicku58);
else u58.addEventListener("click", Clicku58, true);
function Clicku58(e)
{

if (true) {

	self.location.href="日志管理.html" + "";

}

}

var u426 = document.getElementById('u426');

var u926 = document.getElementById('u926');

var u875 = document.getElementById('u875');
gv_vAlignTable['u875'] = 'center';
var u688 = document.getElementById('u688');
gv_vAlignTable['u688'] = 'center';
var u49 = document.getElementById('u49');
gv_vAlignTable['u49'] = 'top';
var u99 = document.getElementById('u99');
gv_vAlignTable['u99'] = 'top';
var u336 = document.getElementById('u336');
gv_vAlignTable['u336'] = 'top';
var u836 = document.getElementById('u836');

var u484 = document.getElementById('u484');

var u984 = document.getElementById('u984');

var u598 = document.getElementById('u598');

var u285 = document.getElementById('u285');
gv_vAlignTable['u285'] = 'top';
var u542 = document.getElementById('u542');

var u394 = document.getElementById('u394');

var u894 = document.getElementById('u894');

var u509 = document.getElementById('u509');
gv_vAlignTable['u509'] = 'center';
var u156 = document.getElementById('u156');

u156.style.cursor = 'pointer';
if (bIE) u156.attachEvent("onclick", Clicku156);
else u156.addEventListener("click", Clicku156, true);
function Clicku156(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u466 = document.getElementById('u466');

var u601 = document.getElementById('u601');
gv_vAlignTable['u601'] = 'center';
var u805 = document.getElementById('u805');
gv_vAlignTable['u805'] = 'center';
var u442 = document.getElementById('u442');

var u419 = document.getElementById('u419');
gv_vAlignTable['u419'] = 'center';
var u799 = document.getElementById('u799');
gv_vAlignTable['u799'] = 'center';
var u729 = document.getElementById('u729');
gv_vAlignTable['u729'] = 'center';
var u207 = document.getElementById('u207');
gv_vAlignTable['u207'] = 'top';
var u672 = document.getElementById('u672');
gv_vAlignTable['u672'] = 'center';
var u215 = document.getElementById('u215');
gv_vAlignTable['u215'] = 'top';
var u525 = document.getElementById('u525');
gv_vAlignTable['u525'] = 'center';
var u1066 = document.getElementById('u1066');
gv_vAlignTable['u1066'] = 'center';
var u1065 = document.getElementById('u1065');

var u639 = document.getElementById('u639');

var u762 = document.getElementById('u762');

var u859 = document.getElementById('u859');
gv_vAlignTable['u859'] = 'center';
var u435 = document.getElementById('u435');
gv_vAlignTable['u435'] = 'center';
var u935 = document.getElementById('u935');
gv_vAlignTable['u935'] = 'center';
var u549 = document.getElementById('u549');
gv_vAlignTable['u549'] = 'center';
var u583 = document.getElementById('u583');
gv_vAlignTable['u583'] = 'center';
var u0 = document.getElementById('u0');

var u50 = document.getElementById('u50');

u50.style.cursor = 'pointer';
if (bIE) u50.attachEvent("onclick", Clicku50);
else u50.addEventListener("click", Clicku50, true);
function Clicku50(e)
{

if (true) {

	self.location.href="合同文件管理.html" + "";

}

}

var u345 = document.getElementById('u345');
gv_vAlignTable['u345'] = 'center';
var u845 = document.getElementById('u845');
gv_vAlignTable['u845'] = 'center';
var u459 = document.getElementById('u459');
gv_vAlignTable['u459'] = 'top';
var u197 = document.getElementById('u197');
gv_vAlignTable['u197'] = 'top';
var u769 = document.getElementById('u769');
gv_vAlignTable['u769'] = 'center';
var u608 = document.getElementById('u608');

var u41 = document.getElementById('u41');
gv_vAlignTable['u41'] = 'top';
var u91 = document.getElementById('u91');

var u781 = document.getElementById('u781');
gv_vAlignTable['u781'] = 'center';
var u255 = document.getElementById('u255');
gv_vAlignTable['u255'] = 'top';
var u565 = document.getElementById('u565');
gv_vAlignTable['u565'] = 'center';
var u404 = document.getElementById('u404');

var u904 = document.getElementById('u904');

var u185 = document.getElementById('u185');
gv_vAlignTable['u185'] = 'top';
var u518 = document.getElementById('u518');

var u7 = document.getElementById('u7');

var u32 = document.getElementById('u32');

u32.style.cursor = 'pointer';
if (bIE) u32.attachEvent("onclick", Clicku32);
else u32.addEventListener("click", Clicku32, true);
function Clicku32(e)
{

if (true) {

	self.location.href="发货单管理.html" + GetQuerystring();

}

}

var u82 = document.getElementById('u82');

u82.style.cursor = 'pointer';
if (bIE) u82.attachEvent("onclick", Clicku82);
else u82.addEventListener("click", Clicku82, true);
function Clicku82(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u63 = document.getElementById('u63');
gv_vAlignTable['u63'] = 'top';
var u475 = document.getElementById('u475');
gv_vAlignTable['u475'] = 'top';
var u314 = document.getElementById('u314');

u314.style.cursor = 'pointer';
if (bIE) u314.attachEvent("onclick", Clicku314);
else u314.addEventListener("click", Clicku314, true);
function Clicku314(e)
{

if (true) {

	self.location.href="B2B签报管理.html" + GetQuerystring();

}

}

var u213 = document.getElementById('u213');
gv_vAlignTable['u213'] = 'top';
var u624 = document.getElementById('u624');

var u738 = document.getElementById('u738');

var u54 = document.getElementById('u54');

u54.style.cursor = 'pointer';
if (bIE) u54.attachEvent("onclick", Clicku54);
else u54.addEventListener("click", Clicku54, true);
function Clicku54(e)
{

if (true) {

	self.location.href="组织机构管理.html" + "";

}

}

var u928 = document.getElementById('u928');

var u621 = document.getElementById('u621');
gv_vAlignTable['u621'] = 'center';
var u534 = document.getElementById('u534');

var u107 = document.getElementById('u107');

var u682 = document.getElementById('u682');
gv_vAlignTable['u682'] = 'center';
var u886 = document.getElementById('u886');

var u45 = document.getElementById('u45');
gv_vAlignTable['u45'] = 'top';
var u95 = document.getElementById('u95');
gv_vAlignTable['u95'] = 'top';
var u76 = document.getElementById('u76');

u76.style.cursor = 'pointer';
if (bIE) u76.attachEvent("onclick", Clicku76);
else u76.addEventListener("click", Clicku76, true);
function Clicku76(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u444 = document.getElementById('u444');

var u944 = document.getElementById('u944');

var u754 = document.getElementById('u754');

var u592 = document.getElementById('u592');

var u67 = document.getElementById('u67');
gv_vAlignTable['u67'] = 'top';
var u731 = document.getElementById('u731');
gv_vAlignTable['u731'] = 'top';
var u977 = document.getElementById('u977');
gv_vAlignTable['u977'] = 'center';
var u664 = document.getElementById('u664');
gv_vAlignTable['u664'] = 'center';
var u503 = document.getElementById('u503');
gv_vAlignTable['u503'] = 'center';
var u778 = document.getElementById('u778');

var u574 = document.getElementById('u574');

var u117 = document.getElementById('u117');
gv_vAlignTable['u117'] = 'top';
var u723 = document.getElementById('u723');
gv_vAlignTable['u723'] = 'center';
var u689 = document.getElementById('u689');

u689.style.cursor = 'pointer';
if (bIE) u689.attachEvent("onclick", Clicku689);
else u689.addEventListener("click", Clicku689, true);
function Clicku689(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u633 = document.getElementById('u633');

u633.style.cursor = 'pointer';
if (bIE) u633.attachEvent("onclick", Clicku633);
else u633.addEventListener("click", Clicku633, true);
function Clicku633(e)
{

if (true) {

	self.location.href="出库的详细信息_1.html" + GetQuerystring();

}

}

var u837 = document.getElementById('u837');
gv_vAlignTable['u837'] = 'center';
var u485 = document.getElementById('u485');
gv_vAlignTable['u485'] = 'center';
var u985 = document.getElementById('u985');
gv_vAlignTable['u985'] = 'center';
var u599 = document.getElementById('u599');
gv_vAlignTable['u599'] = 'center';
var u543 = document.getElementById('u543');
gv_vAlignTable['u543'] = 'center';
var u395 = document.getElementById('u395');
gv_vAlignTable['u395'] = 'top';
var u895 = document.getElementById('u895');
gv_vAlignTable['u895'] = 'center';
var u157 = document.getElementById('u157');
gv_vAlignTable['u157'] = 'top';
var u467 = document.getElementById('u467');
gv_vAlignTable['u467'] = 'center';
var u602 = document.getElementById('u602');

var u806 = document.getElementById('u806');

var u1007 = document.getElementById('u1007');
gv_vAlignTable['u1007'] = 'center';
var u1006 = document.getElementById('u1006');

var u1005 = document.getElementById('u1005');
gv_vAlignTable['u1005'] = 'center';
var u1004 = document.getElementById('u1004');

var u1003 = document.getElementById('u1003');
gv_vAlignTable['u1003'] = 'center';
var u1002 = document.getElementById('u1002');

var u1001 = document.getElementById('u1001');
gv_vAlignTable['u1001'] = 'center';
var u1000 = document.getElementById('u1000');

var u673 = document.getElementById('u673');

u673.style.cursor = 'pointer';
if (bIE) u673.attachEvent("onclick", Clicku673);
else u673.addEventListener("click", Clicku673, true);
function Clicku673(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u68 = document.getElementById('u68');

var u526 = document.getElementById('u526');

var u1009 = document.getElementById('u1009');
gv_vAlignTable['u1009'] = 'center';
var u1008 = document.getElementById('u1008');

var u788 = document.getElementById('u788');

var u979 = document.getElementById('u979');
gv_vAlignTable['u979'] = 'center';
var u59 = document.getElementById('u59');
gv_vAlignTable['u59'] = 'top';
var u436 = document.getElementById('u436');

var u936 = document.getElementById('u936');

var u584 = document.getElementById('u584');

var u698 = document.getElementById('u698');

var u923 = document.getElementById('u923');
gv_vAlignTable['u923'] = 'center';
var u642 = document.getElementById('u642');
gv_vAlignTable['u642'] = 'center';
var u846 = document.getElementById('u846');

var u494 = document.getElementById('u494');

var u994 = document.getElementById('u994');

var u609 = document.getElementById('u609');
gv_vAlignTable['u609'] = 'center';
var u276 = document.getElementById('u276');

u276.style.cursor = 'pointer';
if (bIE) u276.attachEvent("onclick", Clicku276);
else u276.addEventListener("click", Clicku276, true);
function Clicku276(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u721 = document.getElementById('u721');
gv_vAlignTable['u721'] = 'center';
var u256 = document.getElementById('u256');

u256.style.cursor = 'pointer';
if (bIE) u256.attachEvent("onclick", Clicku256);
else u256.addEventListener("click", Clicku256, true);
function Clicku256(e)
{

if (true) {

	self.location.href="出库单审核.html" + GetQuerystring();

}

}

var u566 = document.getElementById('u566');

var u405 = document.getElementById('u405');
gv_vAlignTable['u405'] = 'center';
var u905 = document.getElementById('u905');
gv_vAlignTable['u905'] = 'center';
var u519 = document.getElementById('u519');
gv_vAlignTable['u519'] = 'center';
var u421 = document.getElementById('u421');
gv_vAlignTable['u421'] = 'center';
var u772 = document.getElementById('u772');

var u315 = document.getElementById('u315');
gv_vAlignTable['u315'] = 'top';
var u815 = document.getElementById('u815');
gv_vAlignTable['u815'] = 'center';
var u625 = document.getElementById('u625');
gv_vAlignTable['u625'] = 'top';
var u739 = document.getElementById('u739');
gv_vAlignTable['u739'] = 'center';
var u535 = document.getElementById('u535');
gv_vAlignTable['u535'] = 'center';
var u649 = document.getElementById('u649');

u649.style.cursor = 'pointer';
if (bIE) u649.attachEvent("onclick", Clicku649);
else u649.addEventListener("click", Clicku649, true);
function Clicku649(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u683 = document.getElementById('u683');

var u887 = document.getElementById('u887');
gv_vAlignTable['u887'] = 'center';
var u531 = document.getElementById('u531');
gv_vAlignTable['u531'] = 'center';
var u60 = document.getElementById('u60');

var u169 = document.getElementById('u169');
gv_vAlignTable['u169'] = 'top';
var u445 = document.getElementById('u445');
gv_vAlignTable['u445'] = 'center';
var u945 = document.getElementById('u945');
gv_vAlignTable['u945'] = 'center';
var u559 = document.getElementById('u559');
gv_vAlignTable['u559'] = 'center';
var u297 = document.getElementById('u297');

var u100 = document.getElementById('u100');

u100.style.cursor = 'pointer';
if (bIE) u100.attachEvent("onclick", Clicku100);
else u100.addEventListener("click", Clicku100, true);
function Clicku100(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u51 = document.getElementById('u51');
gv_vAlignTable['u51'] = 'top';
var u355 = document.getElementById('u355');
gv_vAlignTable['u355'] = 'top';
var u855 = document.getElementById('u855');
gv_vAlignTable['u855'] = 'center';
var u665 = document.getElementById('u665');

u665.style.cursor = 'pointer';
if (bIE) u665.attachEvent("onclick", Clicku665);
else u665.addEventListener("click", Clicku665, true);
function Clicku665(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u504 = document.getElementById('u504');

var u337 = document.getElementById('u337');
gv_vAlignTable['u337'] = 'top';
var u779 = document.getElementById('u779');
gv_vAlignTable['u779'] = 'center';
var u618 = document.getElementById('u618');

var u42 = document.getElementById('u42');

u42.style.cursor = 'pointer';
if (bIE) u42.attachEvent("onclick", Clicku42);
else u42.addEventListener("click", Clicku42, true);
function Clicku42(e)
{

if (true) {

	self.location.href="角色管理.html" + "";

}

}

var u92 = document.getElementById('u92');

u92.style.cursor = 'pointer';
if (bIE) u92.attachEvent("onclick", Clicku92);
else u92.addEventListener("click", Clicku92, true);
function Clicku92(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u73 = document.getElementById('u73');
gv_vAlignTable['u73'] = 'top';
var u575 = document.getElementById('u575');
gv_vAlignTable['u575'] = 'center';
var u414 = document.getElementById('u414');

var u914 = document.getElementById('u914');

var u724 = document.getElementById('u724');

var u864 = document.getElementById('u864');

var u64 = document.getElementById('u64');

var u634 = document.getElementById('u634');
gv_vAlignTable['u634'] = 'center';
var u748 = document.getElementById('u748');

var u486 = document.getElementById('u486');

var u986 = document.getElementById('u986');

var u55 = document.getElementById('u55');
gv_vAlignTable['u55'] = 'top';
var u544 = document.getElementById('u544');

var u396 = document.getElementById('u396');

var u896 = document.getElementById('u896');

var u77 = document.getElementById('u77');
gv_vAlignTable['u77'] = 'top';
var u764 = document.getElementById('u764');

var u307 = document.getElementById('u307');
gv_vAlignTable['u307'] = 'top';
var u807 = document.getElementById('u807');
gv_vAlignTable['u807'] = 'center';
var u1017 = document.getElementById('u1017');
gv_vAlignTable['u1017'] = 'top';
var u1016 = document.getElementById('u1016');

var u1015 = document.getElementById('u1015');

var u1014 = document.getElementById('u1014');
gv_vAlignTable['u1014'] = 'top';
var u1013 = document.getElementById('u1013');
gv_vAlignTable['u1013'] = 'center';
var u1012 = document.getElementById('u1012');

var u1011 = document.getElementById('u1011');
gv_vAlignTable['u1011'] = 'top';
var u1010 = document.getElementById('u1010');

var u674 = document.getElementById('u674');
gv_vAlignTable['u674'] = 'center';
var u217 = document.getElementById('u217');
gv_vAlignTable['u217'] = 'top';
var u75 = document.getElementById('u75');
gv_vAlignTable['u75'] = 'top';
var u1019 = document.getElementById('u1019');

var u570 = document.getElementById('u570');

var u237 = document.getElementById('u237');
gv_vAlignTable['u237'] = 'top';
var u789 = document.getElementById('u789');
gv_vAlignTable['u789'] = 'center';
var u1027 = document.getElementById('u1027');
gv_vAlignTable['u1027'] = 'center';
var u127 = document.getElementById('u127');
gv_vAlignTable['u127'] = 'top';
var u1024 = document.getElementById('u1024');

u1024.style.cursor = 'pointer';
if (bIE) u1024.attachEvent("onclick", Clicku1024);
else u1024.addEventListener("click", Clicku1024, true);
function Clicku1024(e)
{

if (true) {

	self.location.href="出库添加信息.html" + GetQuerystring();

}

}

var u437 = document.getElementById('u437');
gv_vAlignTable['u437'] = 'center';
var u937 = document.getElementById('u937');
gv_vAlignTable['u937'] = 'center';
var u306 = document.getElementById('u306');

u306.style.cursor = 'pointer';
if (bIE) u306.attachEvent("onclick", Clicku306);
else u306.addEventListener("click", Clicku306, true);
function Clicku306(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u585 = document.getElementById('u585');
gv_vAlignTable['u585'] = 'center';
var u699 = document.getElementById('u699');
gv_vAlignTable['u699'] = 'top';
var u643 = document.getElementById('u643');

var u847 = document.getElementById('u847');
gv_vAlignTable['u847'] = 'center';
var u495 = document.getElementById('u495');
gv_vAlignTable['u495'] = 'center';
var u347 = document.getElementById('u347');
gv_vAlignTable['u347'] = 'center';
var u1087 = document.getElementById('u1087');
gv_vAlignTable['u1087'] = 'center';
var u1086 = document.getElementById('u1086');

var u1085 = document.getElementById('u1085');

u1085.style.cursor = 'pointer';
if (bIE) u1085.attachEvent("onclick", Clicku1085);
else u1085.addEventListener("click", Clicku1085, true);
function Clicku1085(e)
{

if (true) {

	self.location.href="入库单审核.html" + GetQuerystring();

}

}

var u257 = document.getElementById('u257');
gv_vAlignTable['u257'] = 'top';
var u1083 = document.getElementById('u1083');
gv_vAlignTable['u1083'] = 'center';
var u567 = document.getElementById('u567');
gv_vAlignTable['u567'] = 'center';
var u406 = document.getElementById('u406');

var u906 = document.getElementById('u906');

var u874 = document.getElementById('u874');

var u1089 = document.getElementById('u1089');

var u1088 = document.getElementById('u1088');

u1088.style.cursor = 'pointer';
if (bIE) u1088.attachEvent("onclick", Clicku1088);
else u1088.addEventListener("click", Clicku1088, true);
function Clicku1088(e)
{

if (true) {

	self.location.href="出库单审核.html" + GetQuerystring();

}

}

var u773 = document.getElementById('u773');
gv_vAlignTable['u773'] = 'center';
var u78 = document.getElementById('u78');

u78.style.cursor = 'pointer';
if (bIE) u78.attachEvent("onclick", Clicku78);
else u78.addEventListener("click", Clicku78, true);
function Clicku78(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u816 = document.getElementById('u816');

var u626 = document.getElementById('u626');
gv_vAlignTable['u626'] = 'top';
var u610 = document.getElementById('u610');

var u284 = document.getElementById('u284');

u284.style.cursor = 'pointer';
if (bIE) u284.attachEvent("onclick", Clicku284);
else u284.addEventListener("click", Clicku284, true);
function Clicku284(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u69 = document.getElementById('u69');

var u536 = document.getElementById('u536');

var u727 = document.getElementById('u727');
gv_vAlignTable['u727'] = 'center';
var u684 = document.getElementById('u684');
gv_vAlignTable['u684'] = 'center';
var u190 = document.getElementById('u190');

u190.style.cursor = 'pointer';
if (bIE) u190.attachEvent("onclick", Clicku190);
else u190.addEventListener("click", Clicku190, true);
function Clicku190(e)
{

if (true) {

	self.location.href="成本核算管理.html" + GetQuerystring();

}

}

var u446 = document.getElementById('u446');

var u946 = document.getElementById('u946');

var u594 = document.getElementById('u594');

var u720 = document.getElementById('u720');

var u709 = document.getElementById('u709');
gv_vAlignTable['u709'] = 'top';
var u128 = document.getElementById('u128');

var u356 = document.getElementById('u356');
gv_vAlignTable['u356'] = 'top';
var u856 = document.getElementById('u856');

var u666 = document.getElementById('u666');
gv_vAlignTable['u666'] = 'center';
var u505 = document.getElementById('u505');
gv_vAlignTable['u505'] = 'center';
var u619 = document.getElementById('u619');
gv_vAlignTable['u619'] = 'top';
var u33 = document.getElementById('u33');
gv_vAlignTable['u33'] = 'top';
var u247 = document.getElementById('u247');
gv_vAlignTable['u247'] = 'top';
var u798 = document.getElementById('u798');

var u576 = document.getElementById('u576');

var u415 = document.getElementById('u415');
gv_vAlignTable['u415'] = 'center';
var u915 = document.getElementById('u915');
gv_vAlignTable['u915'] = 'center';
var u725 = document.getElementById('u725');
gv_vAlignTable['u725'] = 'center';
var u783 = document.getElementById('u783');
gv_vAlignTable['u783'] = 'center';
var u316 = document.getElementById('u316');

u316.style.cursor = 'pointer';
if (bIE) u316.attachEvent("onclick", Clicku316);
else u316.addEventListener("click", Clicku316, true);
function Clicku316(e)
{

if (true) {

	self.location.href="B2B返利管理.html" + GetQuerystring();

}

}

var u635 = document.getElementById('u635');

u635.style.cursor = 'pointer';
if (bIE) u635.attachEvent("onclick", Clicku635);
else u635.addEventListener("click", Clicku635, true);
function Clicku635(e)
{

if (true) {

	self.location.href="02其他出库订单已出库查看.html" + GetQuerystring();

}

}

var u141 = document.getElementById('u141');
gv_vAlignTable['u141'] = 'top';
var u487 = document.getElementById('u487');
gv_vAlignTable['u487'] = 'center';
var u987 = document.getElementById('u987');
gv_vAlignTable['u987'] = 'center';
var u70 = document.getElementById('u70');

u70.style.cursor = 'pointer';
if (bIE) u70.attachEvent("onclick", Clicku70);
else u70.addEventListener("click", Clicku70, true);
function Clicku70(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u510 = document.getElementById('u510');

var u184 = document.getElementById('u184');

u184.style.cursor = 'pointer';
if (bIE) u184.attachEvent("onclick", Clicku184);
else u184.addEventListener("click", Clicku184, true);
function Clicku184(e)
{

if (true) {

	self.location.href="基础资料管理.html" + GetQuerystring();

}

}

var u659 = document.getElementById('u659');

var u397 = document.getElementById('u397');
gv_vAlignTable['u397'] = 'center';
var u897 = document.getElementById('u897');
gv_vAlignTable['u897'] = 'center';
var u200 = document.getElementById('u200');

u200.style.cursor = 'pointer';
if (bIE) u200.attachEvent("onclick", Clicku200);
else u200.addEventListener("click", Clicku200, true);
function Clicku200(e)
{

if (true) {

	self.location.href="手工充值审核.html" + GetQuerystring();

}

}

var u61 = document.getElementById('u61');

var u858 = document.getElementById('u858');

var u455 = document.getElementById('u455');
gv_vAlignTable['u455'] = 'center';
var u955 = document.getElementById('u955');
gv_vAlignTable['u955'] = 'center';
var u765 = document.getElementById('u765');
gv_vAlignTable['u765'] = 'center';
var u604 = document.getElementById('u604');

var u1082 = document.getElementById('u1082');

var u110 = document.getElementById('u110');

u110.style.cursor = 'pointer';
if (bIE) u110.attachEvent("onclick", Clicku110);
else u110.addEventListener("click", Clicku110, true);
function Clicku110(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1026 = document.getElementById('u1026');

u1026.style.cursor = 'pointer';
if (bIE) u1026.attachEvent("onclick", Clicku1026);
else u1026.addEventListener("click", Clicku1026, true);
function Clicku1026(e)
{

if (true) {

	self.location.href="出库的详细信息_1.html" + GetQuerystring();

}

}

var u1025 = document.getElementById('u1025');
gv_vAlignTable['u1025'] = 'center';
var u52 = document.getElementById('u52');

u52.style.cursor = 'pointer';
if (bIE) u52.attachEvent("onclick", Clicku52);
else u52.addEventListener("click", Clicku52, true);
function Clicku52(e)
{

if (true) {

	self.location.href="佣金结算规则管理.html" + "";

}

}

var u1023 = document.getElementById('u1023');
gv_vAlignTable['u1023'] = 'top';
var u1022 = document.getElementById('u1022');
gv_vAlignTable['u1022'] = 'top';
var u1021 = document.getElementById('u1021');

var u1020 = document.getElementById('u1020');
gv_vAlignTable['u1020'] = 'top';
var u675 = document.getElementById('u675');

var u514 = document.getElementById('u514');

var u106 = document.getElementById('u106');

var u1029 = document.getElementById('u1029');
gv_vAlignTable['u1029'] = 'center';
var u1028 = document.getElementById('u1028');

u1028.style.cursor = 'pointer';
if (bIE) u1028.attachEvent("onclick", Clicku1028);
else u1028.addEventListener("click", Clicku1028, true);
function Clicku1028(e)
{

if (true) {

	self.location.href="05其他出库单退回待出库页面.html" + GetQuerystring();

}

}

var u74 = document.getElementById('u74');

u74.style.cursor = 'pointer';
if (bIE) u74.attachEvent("onclick", Clicku74);
else u74.addEventListener("click", Clicku74, true);
function Clicku74(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u661 = document.getElementById('u661');

u661.style.cursor = 'pointer';
if (bIE) u661.attachEvent("onclick", Clicku661);
else u661.addEventListener("click", Clicku661, true);
function Clicku661(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u734 = document.getElementById('u734');

var u240 = document.getElementById('u240');

var u586 = document.getElementById('u586');

var u65 = document.getElementById('u65');
gv_vAlignTable['u65'] = 'top';
var u300 = document.getElementById('u300');

u300.style.cursor = 'pointer';
if (bIE) u300.attachEvent("onclick", Clicku300);
else u300.addEventListener("click", Clicku300, true);
function Clicku300(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u216 = document.getElementById('u216');

var u644 = document.getElementById('u644');
gv_vAlignTable['u644'] = 'center';
var u743 = document.getElementById('u743');
gv_vAlignTable['u743'] = 'center';
var u150 = document.getElementById('u150');

var u496 = document.getElementById('u496');

var u996 = document.getElementById('u996');

var u771 = document.getElementById('u771');
gv_vAlignTable['u771'] = 'top';
var u1097 = document.getElementById('u1097');

var u1096 = document.getElementById('u1096');
gv_vAlignTable['u1096'] = 'center';
var u1095 = document.getElementById('u1095');

var u1094 = document.getElementById('u1094');

u1094.style.cursor = 'pointer';
if (bIE) u1094.attachEvent("onclick", Clicku1094);
else u1094.addEventListener("click", Clicku1094, true);
function Clicku1094(e)
{

if (true) {

	self.location.href="采购入库.html" + GetQuerystring();

}

}

var u1093 = document.getElementById('u1093');

var u1092 = document.getElementById('u1092');
gv_vAlignTable['u1092'] = 'center';
var u407 = document.getElementById('u407');
gv_vAlignTable['u407'] = 'center';
var u907 = document.getElementById('u907');
gv_vAlignTable['u907'] = 'center';
var u793 = document.getElementById('u793');
gv_vAlignTable['u793'] = 'center';
var u1099 = document.getElementById('u1099');
gv_vAlignTable['u1099'] = 'center';
var u1098 = document.getElementById('u1098');

var u774 = document.getElementById('u774');

var u317 = document.getElementById('u317');
gv_vAlignTable['u317'] = 'top';
var u817 = document.getElementById('u817');
gv_vAlignTable['u817'] = 'center';
var u227 = document.getElementById('u227');
gv_vAlignTable['u227'] = 'top';
var u537 = document.getElementById('u537');
gv_vAlignTable['u537'] = 'center';
var u685 = document.getElementById('u685');

u685.style.cursor = 'pointer';
if (bIE) u685.attachEvent("onclick", Clicku685);
else u685.addEventListener("click", Clicku685, true);
function Clicku685(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u176 = document.getElementById('u176');

u176.style.cursor = 'pointer';
if (bIE) u176.attachEvent("onclick", Clicku176);
else u176.addEventListener("click", Clicku176, true);
function Clicku176(e)
{

if (true) {

	self.location.href="采购退货计划单管理.html" + GetQuerystring();

}

}

var u191 = document.getElementById('u191');
gv_vAlignTable['u191'] = 'top';
var u447 = document.getElementById('u447');
gv_vAlignTable['u447'] = 'center';
var u947 = document.getElementById('u947');
gv_vAlignTable['u947'] = 'center';
var u561 = document.getElementById('u561');
gv_vAlignTable['u561'] = 'center';
var u595 = document.getElementById('u595');
gv_vAlignTable['u595'] = 'center';
var u1047 = document.getElementById('u1047');

u1047.style.cursor = 'pointer';
if (bIE) u1047.attachEvent("onclick", Clicku1047);
else u1047.addEventListener("click", Clicku1047, true);
function Clicku1047(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u357 = document.getElementById('u357');

var u630 = document.getElementById('u630');
gv_vAlignTable['u630'] = 'center';
var u667 = document.getElementById('u667');

var u506 = document.getElementById('u506');

var u1077 = document.getElementById('u1077');

var u116 = document.getElementById('u116');

u116.style.cursor = 'pointer';
if (bIE) u116.attachEvent("onclick", Clicku116);
else u116.addEventListener("click", Clicku116, true);
function Clicku116(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1075 = document.getElementById('u1075');

var u1074 = document.getElementById('u1074');

u1074.style.cursor = 'pointer';
if (bIE) u1074.attachEvent("onclick", Clicku1074);
else u1074.addEventListener("click", Clicku1074, true);
function Clicku1074(e)
{

if (true) {

	self.location.href="库存盘点_1.html" + GetQuerystring();

}

}

var u1072 = document.getElementById('u1072');
gv_vAlignTable['u1072'] = 'center';
var u577 = document.getElementById('u577');
gv_vAlignTable['u577'] = 'center';
var u416 = document.getElementById('u416');

var u916 = document.getElementById('u916');

var u726 = document.getElementById('u726');

var u1079 = document.getElementById('u1079');
gv_vAlignTable['u1079'] = 'center';
var u1078 = document.getElementById('u1078');

var u922 = document.getElementById('u922');

var u79 = document.getElementById('u79');
gv_vAlignTable['u79'] = 'top';
var u693 = document.getElementById('u693');
gv_vAlignTable['u693'] = 'top';
var u636 = document.getElementById('u636');
gv_vAlignTable['u636'] = 'center';
var u784 = document.getElementById('u784');

var u1091 = document.getElementById('u1091');

var u477 = document.getElementById('u477');
gv_vAlignTable['u477'] = 'center';
var u963 = document.getElementById('u963');
gv_vAlignTable['u963'] = 'center';
var u546 = document.getElementById('u546');

var u694 = document.getElementById('u694');

var u420 = document.getElementById('u420');

var u456 = document.getElementById('u456');

var u956 = document.getElementById('u956');

var u766 = document.getElementById('u766');

var u605 = document.getElementById('u605');
gv_vAlignTable['u605'] = 'center';
var u111 = document.getElementById('u111');
gv_vAlignTable['u111'] = 'top';
var u1036 = document.getElementById('u1036');

var u1035 = document.getElementById('u1035');
gv_vAlignTable['u1035'] = 'top';
var u1034 = document.getElementById('u1034');

var u461 = document.getElementById('u461');
gv_vAlignTable['u461'] = 'center';
var u1032 = document.getElementById('u1032');

var u1031 = document.getElementById('u1031');
gv_vAlignTable['u1031'] = 'center';
var u1030 = document.getElementById('u1030');

u1030.style.cursor = 'pointer';
if (bIE) u1030.attachEvent("onclick", Clicku1030);
else u1030.addEventListener("click", Clicku1030, true);
function Clicku1030(e)
{

if (true) {

	self.location.href="04其他出库单出库完毕页面.html" + GetQuerystring();

}

}

var u676 = document.getElementById('u676');
gv_vAlignTable['u676'] = 'center';
var u515 = document.getElementById('u515');
gv_vAlignTable['u515'] = 'center';
var u226 = document.getElementById('u226');

u226.style.cursor = 'pointer';
if (bIE) u226.attachEvent("onclick", Clicku226);
else u226.addEventListener("click", Clicku226, true);
function Clicku226(e)
{

if (true) {

	self.location.href="销售出库.html" + GetQuerystring();

}

}

var u530 = document.getElementById('u530');

var u1038 = document.getElementById('u1038');
gv_vAlignTable['u1038'] = 'center';
var u735 = document.getElementById('u735');
gv_vAlignTable['u735'] = 'center';
var u878 = document.getElementById('u878');

var u241 = document.getElementById('u241');

var u587 = document.getElementById('u587');
gv_vAlignTable['u587'] = 'top';
var u645 = document.getElementById('u645');

u645.style.cursor = 'pointer';
if (bIE) u645.attachEvent("onclick", Clicku645);
else u645.addEventListener("click", Clicku645, true);
function Clicku645(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u151 = document.getElementById('u151');

var u497 = document.getElementById('u497');
gv_vAlignTable['u497'] = 'center';
var u997 = document.getElementById('u997');
gv_vAlignTable['u997'] = 'center';
var u593 = document.getElementById('u593');
gv_vAlignTable['u593'] = 'center';
var u800 = document.getElementById('u800');

var u71 = document.getElementById('u71');
gv_vAlignTable['u71'] = 'top';
var u555 = document.getElementById('u555');
gv_vAlignTable['u555'] = 'top';
var u377 = document.getElementById('u377');
gv_vAlignTable['u377'] = 'top';
var u704 = document.getElementById('u704');

var u863 = document.getElementById('u863');
gv_vAlignTable['u863'] = 'center';
var u210 = document.getElementById('u210');

var u62 = document.getElementById('u62');

var u775 = document.getElementById('u775');
gv_vAlignTable['u775'] = 'center';
var u614 = document.getElementById('u614');

var u120 = document.getElementById('u120');

var u340 = document.getElementById('u340');

var u686 = document.getElementById('u686');
gv_vAlignTable['u686'] = 'center';
var u158 = document.getElementById('u158');

u158.style.cursor = 'pointer';
if (bIE) u158.attachEvent("onclick", Clicku158);
else u158.addEventListener("click", Clicku158, true);
function Clicku158(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u126 = document.getElementById('u126');

var u995 = document.getElementById('u995');
gv_vAlignTable['u995'] = 'center';
var u759 = document.getElementById('u759');
gv_vAlignTable['u759'] = 'center';
var u383 = document.getElementById('u383');
gv_vAlignTable['u383'] = 'center';
var u250 = document.getElementById('u250');

u250.style.cursor = 'pointer';
if (bIE) u250.attachEvent("onclick", Clicku250);
else u250.addEventListener("click", Clicku250, true);
function Clicku250(e)
{

if (true) {

	self.location.href="其他入库[如活动赠品].html" + GetQuerystring();

}

}

var u596 = document.getElementById('u596');

var u964 = document.getElementById('u964');

var u167 = document.getElementById('u167');
gv_vAlignTable['u167'] = 'top';
var u471 = document.getElementById('u471');
gv_vAlignTable['u471'] = 'center';
var u160 = document.getElementById('u160');

var u236 = document.getElementById('u236');

u236.style.cursor = 'pointer';
if (bIE) u236.attachEvent("onclick", Clicku236);
else u236.addEventListener("click", Clicku236, true);
function Clicku236(e)
{

if (true) {

	self.location.href="移库管理_1.html" + GetQuerystring();

}

}

var u493 = document.getElementById('u493');
gv_vAlignTable['u493'] = 'center';
var u417 = document.getElementById('u417');
gv_vAlignTable['u417'] = 'center';
var u917 = document.getElementById('u917');
gv_vAlignTable['u917'] = 'center';
var u305 = document.getElementById('u305');
gv_vAlignTable['u305'] = 'top';
var u277 = document.getElementById('u277');
gv_vAlignTable['u277'] = 'top';
var u1018 = document.getElementById('u1018');
gv_vAlignTable['u1018'] = 'top';
var u327 = document.getElementById('u327');
gv_vAlignTable['u327'] = 'top';
var u827 = document.getElementById('u827');
gv_vAlignTable['u827'] = 'center';
var u637 = document.getElementById('u637');
gv_vAlignTable['u637'] = 'top';
var u346 = document.getElementById('u346');

var u785 = document.getElementById('u785');
gv_vAlignTable['u785'] = 'center';
var u940 = document.getElementById('u940');

var u291 = document.getElementById('u291');
gv_vAlignTable['u291'] = 'top';
var u547 = document.getElementById('u547');
gv_vAlignTable['u547'] = 'center';
var u695 = document.getElementById('u695');
gv_vAlignTable['u695'] = 'top';
var u873 = document.getElementById('u873');
gv_vAlignTable['u873'] = 'center';
var u1090 = document.getElementById('u1090');
gv_vAlignTable['u1090'] = 'center';
var u457 = document.getElementById('u457');
gv_vAlignTable['u457'] = 'center';
var u957 = document.getElementById('u957');
gv_vAlignTable['u957'] = 'center';
var u767 = document.getElementById('u767');
gv_vAlignTable['u767'] = 'center';
var u606 = document.getElementById('u606');

var u112 = document.getElementById('u112');

u112.style.cursor = 'pointer';
if (bIE) u112.attachEvent("onclick", Clicku112);
else u112.addEventListener("click", Clicku112, true);
function Clicku112(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1046 = document.getElementById('u1046');
gv_vAlignTable['u1046'] = 'center';
var u1045 = document.getElementById('u1045');

u1045.style.cursor = 'pointer';
if (bIE) u1045.attachEvent("onclick", Clicku1045);
else u1045.addEventListener("click", Clicku1045, true);
function Clicku1045(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u1044 = document.getElementById('u1044');
gv_vAlignTable['u1044'] = 'center';
var u1043 = document.getElementById('u1043');

u1043.style.cursor = 'pointer';
if (bIE) u1043.attachEvent("onclick", Clicku1043);
else u1043.addEventListener("click", Clicku1043, true);
function Clicku1043(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u1042 = document.getElementById('u1042');
gv_vAlignTable['u1042'] = 'center';
var u1041 = document.getElementById('u1041');

u1041.style.cursor = 'pointer';
if (bIE) u1041.attachEvent("onclick", Clicku1041);
else u1041.addEventListener("click", Clicku1041, true);
function Clicku1041(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u1040 = document.getElementById('u1040');
gv_vAlignTable['u1040'] = 'center';
var u677 = document.getElementById('u677');

u677.style.cursor = 'pointer';
if (bIE) u677.attachEvent("onclick", Clicku677);
else u677.addEventListener("click", Clicku677, true);
function Clicku677(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u516 = document.getElementById('u516');

var u1049 = document.getElementById('u1049');

u1049.style.cursor = 'pointer';
if (bIE) u1049.attachEvent("onclick", Clicku1049);
else u1049.addEventListener("click", Clicku1049, true);
function Clicku1049(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u760 = document.getElementById('u760');

var u136 = document.getElementById('u136');

u136.style.cursor = 'pointer';
if (bIE) u136.attachEvent("onclick", Clicku136);
else u136.addEventListener("click", Clicku136, true);
function Clicku136(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u736 = document.getElementById('u736');

var u390 = document.getElementById('u390');

var u890 = document.getElementById('u890');

var u177 = document.getElementById('u177');
gv_vAlignTable['u177'] = 'top';
var u646 = document.getElementById('u646');
gv_vAlignTable['u646'] = 'center';
var u152 = document.getElementById('u152');

u152.style.cursor = 'pointer';
if (bIE) u152.attachEvent("onclick", Clicku152);
else u152.addEventListener("click", Clicku152, true);
function Clicku152(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u794 = document.getElementById('u794');

var u246 = document.getElementById('u246');

u246.style.cursor = 'pointer';
if (bIE) u246.attachEvent("onclick", Clicku246);
else u246.addEventListener("click", Clicku246, true);
function Clicku246(e)
{

if (true) {

	self.location.href="售后入库.html" + GetQuerystring();

}

}

var u556 = document.getElementById('u556');

var u705 = document.getElementById('u705');
gv_vAlignTable['u705'] = 'top';
var u719 = document.getElementById('u719');
gv_vAlignTable['u719'] = 'center';
var u211 = document.getElementById('u211');

var u776 = document.getElementById('u776');

var u615 = document.getElementById('u615');
gv_vAlignTable['u615'] = 'center';
var u121 = document.getElementById('u121');

var u948 = document.getElementById('u948');

var u341 = document.getElementById('u341');
gv_vAlignTable['u341'] = 'center';
var u687 = document.getElementById('u687');

var u745 = document.getElementById('u745');
gv_vAlignTable['u745'] = 'center';
var u251 = document.getElementById('u251');
gv_vAlignTable['u251'] = 'top';
var u597 = document.getElementById('u597');
gv_vAlignTable['u597'] = 'center';
var u400 = document.getElementById('u400');

var u900 = document.getElementById('u900');

var u655 = document.getElementById('u655');

var u105 = document.getElementById('u105');
gv_vAlignTable['u105'] = 'top';
var u161 = document.getElementById('u161');

var u310 = document.getElementById('u310');

u310.style.cursor = 'pointer';
if (bIE) u310.attachEvent("onclick", Clicku310);
else u310.addEventListener("click", Clicku310, true);
function Clicku310(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u810 = document.getElementById('u810');

var u72 = document.getElementById('u72');

u72.style.cursor = 'pointer';
if (bIE) u72.attachEvent("onclick", Clicku72);
else u72.addEventListener("click", Clicku72, true);
function Clicku72(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u660 = document.getElementById('u660');
gv_vAlignTable['u660'] = 'center';
var u714 = document.getElementById('u714');

var u220 = document.getElementById('u220');

var u130 = document.getElementById('u130');

u130.style.cursor = 'pointer';
if (bIE) u130.attachEvent("onclick", Clicku130);
else u130.addEventListener("click", Clicku130, true);
function Clicku130(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u440 = document.getElementById('u440');

var u786 = document.getElementById('u786');

var u258 = document.getElementById('u258');

var u350 = document.getElementById('u350');
gv_vAlignTable['u350'] = 'top';
var u850 = document.getElementById('u850');

var u792 = document.getElementById('u792');

var u607 = document.getElementById('u607');
gv_vAlignTable['u607'] = 'center';
var u113 = document.getElementById('u113');
gv_vAlignTable['u113'] = 'top';
var u170 = document.getElementById('u170');

u170.style.cursor = 'pointer';
if (bIE) u170.attachEvent("onclick", Clicku170);
else u170.addEventListener("click", Clicku170, true);
function Clicku170(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u427 = document.getElementById('u427');
gv_vAlignTable['u427'] = 'top';
var u927 = document.getElementById('u927');
gv_vAlignTable['u927'] = 'center';
var u560 = document.getElementById('u560');

var u187 = document.getElementById('u187');
gv_vAlignTable['u187'] = 'top';
var u891 = document.getElementById('u891');
gv_vAlignTable['u891'] = 'top';
var u647 = document.getElementById('u647');

var u1055 = document.getElementById('u1055');

u1055.style.cursor = 'pointer';
if (bIE) u1055.attachEvent("onclick", Clicku1055);
else u1055.addEventListener("click", Clicku1055, true);
function Clicku1055(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u582 = document.getElementById('u582');

var u153 = document.getElementById('u153');
gv_vAlignTable['u153'] = 'top';
var u795 = document.getElementById('u795');
gv_vAlignTable['u795'] = 'center';
var u1064 = document.getElementById('u1064');

u1064.style.cursor = 'pointer';
if (bIE) u1064.attachEvent("onclick", Clicku1064);
else u1064.addEventListener("click", Clicku1064, true);
function Clicku1064(e)
{

if (true) {

	self.location.href="采购入库.html" + GetQuerystring();

}

}

var u1063 = document.getElementById('u1063');

var u1062 = document.getElementById('u1062');
gv_vAlignTable['u1062'] = 'center';
var u366 = document.getElementById('u366');

var u557 = document.getElementById('u557');
gv_vAlignTable['u557'] = 'center';
var u706 = document.getElementById('u706');

var u1069 = document.getElementById('u1069');

var u1068 = document.getElementById('u1068');
gv_vAlignTable['u1068'] = 'center';
var u212 = document.getElementById('u212');

u212.style.cursor = 'pointer';
if (bIE) u212.attachEvent("onclick", Clicku212);
else u212.addEventListener("click", Clicku212, true);
function Clicku212(e)
{

if (true) {

	self.location.href="入库管理.html" + GetQuerystring();

}

}

var u761 = document.getElementById('u761');
gv_vAlignTable['u761'] = 'center';
var u692 = document.getElementById('u692');

var u777 = document.getElementById('u777');
gv_vAlignTable['u777'] = 'center';
var u616 = document.getElementById('u616');

var u122 = document.getElementById('u122');

var u680 = document.getElementById('u680');
gv_vAlignTable['u680'] = 'center';
var u476 = document.getElementById('u476');

var u780 = document.getElementById('u780');

var u962 = document.getElementById('u962');

var u545 = document.getElementById('u545');
gv_vAlignTable['u545'] = 'center';
var u180 = document.getElementById('u180');

u180.style.cursor = 'pointer';
if (bIE) u180.attachEvent("onclick", Clicku180);
else u180.addEventListener("click", Clicku180, true);
function Clicku180(e)
{

if (true) {

	self.location.href="采购退货单管理.html" + GetQuerystring();

}

}

var u490 = document.getElementById('u490');

var u990 = document.getElementById('u990');

var u746 = document.getElementById('u746');

var u252 = document.getElementById('u252');

var u656 = document.getElementById('u656');
gv_vAlignTable['u656'] = 'center';
var u629 = document.getElementById('u629');

var u225 = document.getElementById('u225');
gv_vAlignTable['u225'] = 'top';
var u311 = document.getElementById('u311');
gv_vAlignTable['u311'] = 'top';
var u811 = document.getElementById('u811');
gv_vAlignTable['u811'] = 'top';
var u797 = document.getElementById('u797');
gv_vAlignTable['u797'] = 'center';
var u129 = document.getElementById('u129');

var u715 = document.getElementById('u715');
gv_vAlignTable['u715'] = 'center';
var u266 = document.getElementById('u266');

var u221 = document.getElementById('u221');
gv_vAlignTable['u221'] = 'top';
var u140 = document.getElementById('u140');

u140.style.cursor = 'pointer';
if (bIE) u140.attachEvent("onclick", Clicku140);
else u140.addEventListener("click", Clicku140, true);
function Clicku140(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u335 = document.getElementById('u335');
gv_vAlignTable['u335'] = 'top';
var u131 = document.getElementById('u131');
gv_vAlignTable['u131'] = 'top';
var u879 = document.getElementById('u879');
gv_vAlignTable['u879'] = 'center';
var u441 = document.getElementById('u441');
gv_vAlignTable['u441'] = 'center';
var u787 = document.getElementById('u787');
gv_vAlignTable['u787'] = 'center';
var u376 = document.getElementById('u376');

var u862 = document.getElementById('u862');

var u351 = document.getElementById('u351');

var u697 = document.getElementById('u697');
gv_vAlignTable['u697'] = 'top';
var u500 = document.getElementById('u500');

var u755 = document.getElementById('u755');
gv_vAlignTable['u755'] = 'center';
var u261 = document.getElementById('u261');
gv_vAlignTable['u261'] = 'top';
var u410 = document.getElementById('u410');

var u910 = document.getElementById('u910');

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u360 = document.getElementById('u360');

u360.style.cursor = 'pointer';
if (bIE) u360.attachEvent("onclick", Clicku360);
else u360.addEventListener("click", Clicku360, true);
function Clicku360(e)
{

if (true) {

	SetPanelStateu362("pd1u362");

}

}

var u171 = document.getElementById('u171');
gv_vAlignTable['u171'] = 'top';
var u320 = document.getElementById('u320');

u320.style.cursor = 'pointer';
if (bIE) u320.attachEvent("onclick", Clicku320);
else u320.addEventListener("click", Clicku320, true);
function Clicku320(e)
{

if (true) {

	self.location.href="B2B价保管理.html" + GetQuerystring();

}

}

var u820 = document.getElementById('u820');

var u138 = document.getElementById('u138');

u138.style.cursor = 'pointer';
if (bIE) u138.attachEvent("onclick", Clicku138);
else u138.addEventListener("click", Clicku138, true);
function Clicku138(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u382 = document.getElementById('u382');

var u230 = document.getElementById('u230');

u230.style.cursor = 'pointer';
if (bIE) u230.attachEvent("onclick", Clicku230);
else u230.addEventListener("click", Clicku230, true);
function Clicku230(e)
{

if (true) {

	self.location.href="借机出库.html" + GetQuerystring();

}

}

var u540 = document.getElementById('u540');

var u358 = document.getElementById('u358');

u358.style.cursor = 'pointer';
if (bIE) u358.attachEvent("onclick", Clicku358);
else u358.addEventListener("click", Clicku358, true);
function Clicku358(e)
{

if (true) {

	SetPanelStateu362("pd0u362");

}

}

var u166 = document.getElementById('u166');

u166.style.cursor = 'pointer';
if (bIE) u166.attachEvent("onclick", Clicku166);
else u166.addEventListener("click", Clicku166, true);
function Clicku166(e)
{

if (true) {

	self.location.href="产品单管理.html" + GetQuerystring();

}

}

var u16 = document.getElementById('u16');

var u450 = document.getElementById('u450');

var u950 = document.getElementById('u950');

var u268 = document.getElementById('u268');

u268.style.cursor = 'pointer';
if (bIE) u268.attachEvent("onclick", Clicku268);
else u268.addEventListener("click", Clicku268, true);
function Clicku268(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u708 = document.getElementById('u708');

var u707 = document.getElementById('u707');
gv_vAlignTable['u707'] = 'top';
var u860 = document.getElementById('u860');

var u178 = document.getElementById('u178');

u178.style.cursor = 'pointer';
if (bIE) u178.attachEvent("onclick", Clicku178);
else u178.addEventListener("click", Clicku178, true);
function Clicku178(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u617 = document.getElementById('u617');
gv_vAlignTable['u617'] = 'center';
var u123 = document.getElementById('u123');
gv_vAlignTable['u123'] = 'top';
var u275 = document.getElementById('u275');
gv_vAlignTable['u275'] = 'top';
var u527 = document.getElementById('u527');
gv_vAlignTable['u527'] = 'center';
var u260 = document.getElementById('u260');

var u491 = document.getElementById('u491');
gv_vAlignTable['u491'] = 'top';
var u991 = document.getElementById('u991');
gv_vAlignTable['u991'] = 'top';
var u747 = document.getElementById('u747');
gv_vAlignTable['u747'] = 'center';
var u253 = document.getElementById('u253');

var u657 = document.getElementById('u657');

u657.style.cursor = 'pointer';
if (bIE) u657.attachEvent("onclick", Clicku657);
else u657.addEventListener("click", Clicku657, true);
function Clicku657(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u163 = document.getElementById('u163');
gv_vAlignTable['u163'] = 'top';
var u312 = document.getElementById('u312');

var u812 = document.getElementById('u812');

var u135 = document.getElementById('u135');
gv_vAlignTable['u135'] = 'top';
var u716 = document.getElementById('u716');

var u222 = document.getElementById('u222');

var u188 = document.getElementById('u188');

u188.style.cursor = 'pointer';
if (bIE) u188.attachEvent("onclick", Clicku188);
else u188.addEventListener("click", Clicku188, true);
function Clicku188(e)
{

if (true) {

	self.location.href="总账管理.html" + GetQuerystring();

}

}

var u132 = document.getElementById('u132');

u132.style.cursor = 'pointer';
if (bIE) u132.attachEvent("onclick", Clicku132);
else u132.addEventListener("click", Clicku132, true);
function Clicku132(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u941 = document.getElementById('u941');
gv_vAlignTable['u941'] = 'center';
var u857 = document.getElementById('u857');
gv_vAlignTable['u857'] = 'center';
var u280 = document.getElementById('u280');

var u700 = document.getElementById('u700');

var u590 = document.getElementById('u590');

var u718 = document.getElementById('u718');

var u352 = document.getElementById('u352');
gv_vAlignTable['u352'] = 'center';
var u852 = document.getElementById('u852');

var u756 = document.getElementById('u756');

var u262 = document.getElementById('u262');

var u101 = document.getElementById('u101');
gv_vAlignTable['u101'] = 'top';
var u411 = document.getElementById('u411');
gv_vAlignTable['u411'] = 'top';
var u911 = document.getElementById('u911');
gv_vAlignTable['u911'] = 'top';
var u229 = document.getElementById('u229');
gv_vAlignTable['u229'] = 'top';
var u172 = document.getElementById('u172');

u172.style.cursor = 'pointer';
if (bIE) u172.attachEvent("onclick", Clicku172);
else u172.addEventListener("click", Clicku172, true);
function Clicku172(e)
{

if (true) {

	self.location.href="采购结算单管理.html" + GetQuerystring();

}

}

var u703 = document.getElementById('u703');
gv_vAlignTable['u703'] = 'top';
var u321 = document.getElementById('u321');
gv_vAlignTable['u321'] = 'top';
var u821 = document.getElementById('u821');
gv_vAlignTable['u821'] = 'center';
var u139 = document.getElementById('u139');
gv_vAlignTable['u139'] = 'top';
var u967 = document.getElementById('u967');
gv_vAlignTable['u967'] = 'center';
var u270 = document.getElementById('u270');

u270.style.cursor = 'pointer';
if (bIE) u270.attachEvent("onclick", Clicku270);
else u270.addEventListener("click", Clicku270, true);
function Clicku270(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u231 = document.getElementById('u231');
gv_vAlignTable['u231'] = 'top';
var u744 = document.getElementById('u744');

var u541 = document.getElementById('u541');
gv_vAlignTable['u541'] = 'center';
var u737 = document.getElementById('u737');
gv_vAlignTable['u737'] = 'center';
var u451 = document.getElementById('u451');
gv_vAlignTable['u451'] = 'center';
var u951 = document.getElementById('u951');
gv_vAlignTable['u951'] = 'top';
var u600 = document.getElementById('u600');

var u108 = document.getElementById('u108');

u108.style.cursor = 'pointer';
if (bIE) u108.attachEvent("onclick", Clicku108);
else u108.addEventListener("click", Clicku108, true);
function Clicku108(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u841 = document.getElementById('u841');
gv_vAlignTable['u841'] = 'center';
var u361 = document.getElementById('u361');
gv_vAlignTable['u361'] = 'center';
var u861 = document.getElementById('u861');
gv_vAlignTable['u861'] = 'center';
var u179 = document.getElementById('u179');
gv_vAlignTable['u179'] = 'top';
var u513 = document.getElementById('u513');
gv_vAlignTable['u513'] = 'center';
var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
var u828 = document.getElementById('u828');

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u835 = document.getElementById('u835');
gv_vAlignTable['u835'] = 'center';
var u671 = document.getElementById('u671');

var u271 = document.getElementById('u271');
gv_vAlignTable['u271'] = 'top';
var u124 = document.getElementById('u124');

var u920 = document.getElementById('u920');

var u238 = document.getElementById('u238');

u238.style.cursor = 'pointer';
if (bIE) u238.attachEvent("onclick", Clicku238);
else u238.addEventListener("click", Clicku238, true);
function Clicku238(e)
{

if (true) {

	self.location.href="移库审核.html" + GetQuerystring();

}

}

var u330 = document.getElementById('u330');

u330.style.cursor = 'pointer';
if (bIE) u330.attachEvent("onclick", Clicku330);
else u330.addEventListener("click", Clicku330, true);
function Clicku330(e)
{

if (true) {

	self.location.href="B2B订单管理.html" + GetQuerystring();

}

}

var u830 = document.getElementById('u830');

var u640 = document.getElementById('u640');
gv_vAlignTable['u640'] = 'center';
var u148 = document.getElementById('u148');

u148.style.cursor = 'pointer';
if (bIE) u148.attachEvent("onclick", Clicku148);
else u148.addEventListener("click", Clicku148, true);
function Clicku148(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u182 = document.getElementById('u182');

var u458 = document.getElementById('u458');

var u603 = document.getElementById('u603');
gv_vAlignTable['u603'] = 'top';
var u26 = document.getElementById('u26');

u26.style.cursor = 'pointer';
if (bIE) u26.attachEvent("onclick", Clicku26);
else u26.addEventListener("click", Clicku26, true);
function Clicku26(e)
{

if (true) {

	self.location.href="系统管理.html" + GetQuerystring();

}

}

var u550 = document.getElementById('u550');

var u1067 = document.getElementById('u1067');

var u368 = document.getElementById('u368');

var u868 = document.getElementById('u868');

var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u460 = document.getElementById('u460');

var u960 = document.getElementById('u960');

var u313 = document.getElementById('u313');

var u813 = document.getElementById('u813');
gv_vAlignTable['u813'] = 'center';
var u867 = document.getElementById('u867');
gv_vAlignTable['u867'] = 'center';
var u224 = document.getElementById('u224');

u224.style.cursor = 'pointer';
if (bIE) u224.attachEvent("onclick", Clicku224);
else u224.addEventListener("click", Clicku224, true);
function Clicku224(e)
{

if (true) {

	self.location.href="采购退库.html" + GetQuerystring();

}

}

var u370 = document.getElementById('u370');

var u870 = document.getElementById('u870');

var u223 = document.getElementById('u223');

var u728 = document.getElementById('u728');

var u324 = document.getElementById('u324');

u324.style.cursor = 'pointer';
if (bIE) u324.attachEvent("onclick", Clicku324);
else u324.addEventListener("click", Clicku324, true);
function Clicku324(e)
{

if (true) {

	self.location.href="B2B电子渠道库存管理.html" + GetQuerystring();

}

}

var u189 = document.getElementById('u189');
gv_vAlignTable['u189'] = 'top';
var u627 = document.getElementById('u627');

var u133 = document.getElementById('u133');
gv_vAlignTable['u133'] = 'top';
var u1054 = document.getElementById('u1054');
gv_vAlignTable['u1054'] = 'center';
var u1053 = document.getElementById('u1053');

u1053.style.cursor = 'pointer';
if (bIE) u1053.attachEvent("onclick", Clicku1053);
else u1053.addEventListener("click", Clicku1053, true);
function Clicku1053(e)
{

if (true) {

	self.location.href="03其他出库单出库页面.html" + GetQuerystring();

}

}

var u281 = document.getElementById('u281');

var u591 = document.getElementById('u591');
gv_vAlignTable['u591'] = 'center';
var u851 = document.getElementById('u851');
gv_vAlignTable['u851'] = 'top';
var u1059 = document.getElementById('u1059');

var u1058 = document.getElementById('u1058');
gv_vAlignTable['u1058'] = 'center';
var u353 = document.getElementById('u353');

var u853 = document.getElementById('u853');
gv_vAlignTable['u853'] = 'center';
var u434 = document.getElementById('u434');

var u713 = document.getElementById('u713');
gv_vAlignTable['u713'] = 'center';
var u387 = document.getElementById('u387');
gv_vAlignTable['u387'] = 'center';
var u757 = document.getElementById('u757');
gv_vAlignTable['u757'] = 'center';
var u263 = document.getElementById('u263');
gv_vAlignTable['u263'] = 'top';
var u102 = document.getElementById('u102');

u102.style.cursor = 'pointer';
if (bIE) u102.attachEvent("onclick", Clicku102);
else u102.addEventListener("click", Clicku102, true);
function Clicku102(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u412 = document.getElementById('u412');

var u912 = document.getElementById('u912');

var u173 = document.getElementById('u173');
gv_vAlignTable['u173'] = 'top';
var u18 = document.getElementById('u18');

var u969 = document.getElementById('u969');
gv_vAlignTable['u969'] = 'center';
var u322 = document.getElementById('u322');

u322.style.cursor = 'pointer';
if (bIE) u322.attachEvent("onclick", Clicku322);
else u322.addEventListener("click", Clicku322, true);
function Clicku322(e)
{

if (true) {

	self.location.href="B2B价保审核管理.html" + GetQuerystring();

}

}

var u822 = document.getElementById('u822');

var u474 = document.getElementById('u474');

var u288 = document.getElementById('u288');

u288.style.cursor = 'pointer';
if (bIE) u288.attachEvent("onclick", Clicku288);
else u288.addEventListener("click", Clicku288, true);
function Clicku288(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u982 = document.getElementById('u982');

var u232 = document.getElementById('u232');

u232.style.cursor = 'pointer';
if (bIE) u232.attachEvent("onclick", Clicku232);
else u232.addEventListener("click", Clicku232, true);
function Clicku232(e)
{

if (true) {

	self.location.href="其他出库[如活动赠品].html" + GetQuerystring();

}

}

var u380 = document.getElementById('u380');

var u880 = document.getElementById('u880');

var u690 = document.getElementById('u690');
gv_vAlignTable['u690'] = 'center';
var u198 = document.getElementById('u198');

u198.style.cursor = 'pointer';
if (bIE) u198.attachEvent("onclick", Clicku198);
else u198.addEventListener("click", Clicku198, true);
function Clicku198(e)
{

if (true) {

	self.location.href="手工充值管理.html" + GetQuerystring();

}

}

var u142 = document.getElementById('u142');

u142.style.cursor = 'pointer';
if (bIE) u142.attachEvent("onclick", Clicku142);
else u142.addEventListener("click", Clicku142, true);
function Clicku142(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u452 = document.getElementById('u452');

var u952 = document.getElementById('u952');

var u109 = document.getElementById('u109');
gv_vAlignTable['u109'] = 'top';
var u877 = document.getElementById('u877');
gv_vAlignTable['u877'] = 'center';
var u362 = document.getElementById('u362');

var u201 = document.getElementById('u201');
gv_vAlignTable['u201'] = 'top';
var u511 = document.getElementById('u511');
gv_vAlignTable['u511'] = 'center';
var u329 = document.getElementById('u329');
gv_vAlignTable['u329'] = 'top';
var u829 = document.getElementById('u829');
gv_vAlignTable['u829'] = 'center';
var u898 = document.getElementById('u898');

var u272 = document.getElementById('u272');

u272.style.cursor = 'pointer';
if (bIE) u272.attachEvent("onclick", Clicku272);
else u272.addEventListener("click", Clicku272, true);
function Clicku272(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u287 = document.getElementById('u287');
gv_vAlignTable['u287'] = 'top';
var u125 = document.getElementById('u125');
gv_vAlignTable['u125'] = 'top';
var u921 = document.getElementById('u921');
gv_vAlignTable['u921'] = 'center';
var u239 = document.getElementById('u239');
gv_vAlignTable['u239'] = 'top';
var u331 = document.getElementById('u331');
gv_vAlignTable['u331'] = 'top';
var u831 = document.getElementById('u831');
gv_vAlignTable['u831'] = 'top';
var u641 = document.getElementById('u641');

u641.style.cursor = 'pointer';
if (bIE) u641.attachEvent("onclick", Clicku641);
else u641.addEventListener("click", Clicku641, true);
function Clicku641(e)
{

if (true) {

	self.location.href="01其他出库订单待出库查看.html" + GetQuerystring();

}

}

var u149 = document.getElementById('u149');
gv_vAlignTable['u149'] = 'top';
var u183 = document.getElementById('u183');

var u48 = document.getElementById('u48');

u48.style.cursor = 'pointer';
if (bIE) u48.attachEvent("onclick", Clicku48);
else u48.addEventListener("click", Clicku48, true);
function Clicku48(e)
{

if (true) {

	self.location.href="合同类别管理.html" + "";

}

}

var u10 = document.getElementById('u10');

u10.style.cursor = 'pointer';
if (bIE) u10.attachEvent("onclick", Clicku10);
else u10.addEventListener("click", Clicku10, true);
function Clicku10(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u208 = document.getElementById('u208');

u208.style.cursor = 'pointer';
if (bIE) u208.attachEvent("onclick", Clicku208);
else u208.addEventListener("click", Clicku208, true);
function Clicku208(e)
{

if (true) {

	self.location.href="佣金结算审核.html" + GetQuerystring();

}

}

var u551 = document.getElementById('u551');
gv_vAlignTable['u551'] = 'center';
var u369 = document.getElementById('u369');
gv_vAlignTable['u369'] = 'top';
var u869 = document.getElementById('u869');
gv_vAlignTable['u869'] = 'center';
var u165 = document.getElementById('u165');
gv_vAlignTable['u165'] = 'top';
var u961 = document.getElementById('u961');
gv_vAlignTable['u961'] = 'center';
var u279 = document.getElementById('u279');
gv_vAlignTable['u279'] = 'top';
var u528 = document.getElementById('u528');

var u428 = document.getElementById('u428');

var u8 = document.getElementById('u8');

u8.style.cursor = 'pointer';
if (bIE) u8.attachEvent("onclick", Clicku8);
else u8.addEventListener("click", Clicku8, true);
function Clicku8(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u993 = document.getElementById('u993');
gv_vAlignTable['u993'] = 'center';
var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
var u318 = document.getElementById('u318');

u318.style.cursor = 'pointer';
if (bIE) u318.attachEvent("onclick", Clicku318);
else u318.addEventListener("click", Clicku318, true);
function Clicku318(e)
{

if (true) {

	self.location.href="B2B返利审核管理.html" + GetQuerystring();

}

}

var u371 = document.getElementById('u371');
gv_vAlignTable['u371'] = 'top';
var u871 = document.getElementById('u871');
gv_vAlignTable['u871'] = 'top';
var u520 = document.getElementById('u520');

var u338 = document.getElementById('u338');

var u838 = document.getElementById('u838');

var u14 = document.getElementById('u14');

u14.style.cursor = 'pointer';
if (bIE) u14.attachEvent("onclick", Clicku14);
else u14.addEventListener("click", Clicku14, true);
function Clicku14(e)
{

if (true) {

}

}

var u162 = document.getElementById('u162');

u162.style.cursor = 'pointer';
if (bIE) u162.attachEvent("onclick", Clicku162);
else u162.addEventListener("click", Clicku162, true);
function Clicku162(e)
{

if (true) {

	self.location.href="请购单管理.html" + GetQuerystring();

}

}

var u430 = document.getElementById('u430');

var u930 = document.getElementById('u930');

var u740 = document.getElementById('u740');

var u248 = document.getElementById('u248');

u248.style.cursor = 'pointer';
if (bIE) u248.attachEvent("onclick", Clicku248);
else u248.addEventListener("click", Clicku248, true);
function Clicku248(e)
{

if (true) {

	self.location.href="还机入库.html" + GetQuerystring();

}

}

var u282 = document.getElementById('u282');

u282.style.cursor = 'pointer';
if (bIE) u282.attachEvent("onclick", Clicku282);
else u282.addEventListener("click", Clicku282, true);
function Clicku282(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u558 = document.getElementById('u558');

var u36 = document.getElementById('u36');

u36.style.cursor = 'pointer';
if (bIE) u36.attachEvent("onclick", Clicku36);
else u36.addEventListener("click", Clicku36, true);
function Clicku36(e)
{

if (true) {

	self.location.href="物流地域维护管理.html" + GetQuerystring();

}

}

var u86 = document.getElementById('u86');

u86.style.cursor = 'pointer';
if (bIE) u86.attachEvent("onclick", Clicku86);
else u86.addEventListener("click", Clicku86, true);
function Clicku86(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u679 = document.getElementById('u679');

var u650 = document.getElementById('u650');
gv_vAlignTable['u650'] = 'center';
var u854 = document.getElementById('u854');

var u192 = document.getElementById('u192');

u192.style.cursor = 'pointer';
if (bIE) u192.attachEvent("onclick", Clicku192);
else u192.addEventListener("click", Clicku192, true);
function Clicku192(e)
{

if (true) {

	self.location.href="财务报表管理.html" + GetQuerystring();

}

}

var u468 = document.getElementById('u468');

var u968 = document.getElementById('u968');

var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'top';
var u264 = document.getElementById('u264');

var u103 = document.getElementById('u103');
gv_vAlignTable['u103'] = 'top';
var u1081 = document.getElementById('u1081');
gv_vAlignTable['u1081'] = 'center';
var u378 = document.getElementById('u378');

var u913 = document.getElementById('u913');
gv_vAlignTable['u913'] = 'center';
var u470 = document.getElementById('u470');

var u970 = document.getElementById('u970');

var u323 = document.getElementById('u323');
gv_vAlignTable['u323'] = 'top';
var u823 = document.getElementById('u823');
gv_vAlignTable['u823'] = 'center';
if (window.OnLoad) OnLoad();
