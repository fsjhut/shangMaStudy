
var PageName = '其他入库(如活动赠品)';
var PageId = 'pe96c8fe628c346bface5768058f3f141'
var PageUrl = '其他入库[如活动赠品].html'
document.title = '其他入库(如活动赠品)';

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

eval(GetDynamicPanelScript('u376', 2));

var u289 = document.getElementById('u289');
gv_vAlignTable['u289'] = 'top';
var u733 = document.getElementById('u733');

var u966 = document.getElementById('u966');

var u233 = document.getElementById('u233');
gv_vAlignTable['u233'] = 'top';
var u381 = document.getElementById('u381');
gv_vAlignTable['u381'] = 'top';
var u881 = document.getElementById('u881');
gv_vAlignTable['u881'] = 'center';
var u691 = document.getElementById('u691');
gv_vAlignTable['u691'] = 'center';
var u199 = document.getElementById('u199');
gv_vAlignTable['u199'] = 'top';
var u143 = document.getElementById('u143');
gv_vAlignTable['u143'] = 'top';
var u453 = document.getElementById('u453');
gv_vAlignTable['u453'] = 'center';
var u953 = document.getElementById('u953');
gv_vAlignTable['u953'] = 'center';
var u1257 = document.getElementById('u1257');

var u1256 = document.getElementById('u1256');

u1256.style.cursor = 'pointer';
if (bIE) u1256.attachEvent("onclick", Clicku1256);
else u1256.addEventListener("click", Clicku1256, true);
function Clicku1256(e)
{

if (true) {

	self.location.href="采购退库.html" + GetQuerystring();

}

}

var u134 = document.getElementById('u134');

u134.style.cursor = 'pointer';
if (bIE) u134.attachEvent("onclick", Clicku134);
else u134.addEventListener("click", Clicku134, true);
function Clicku134(e)
{

if (true) {

	self.location.href="手工充值审核.html" + GetQuerystring();

}

}

var u1253 = document.getElementById('u1253');

var u1252 = document.getElementById('u1252');
gv_vAlignTable['u1252'] = 'center';
var u1251 = document.getElementById('u1251');

var u363 = document.getElementById('u363');
gv_vAlignTable['u363'] = 'center';
var u202 = document.getElementById('u202');

u202.style.cursor = 'pointer';
if (bIE) u202.attachEvent("onclick", Clicku202);
else u202.addEventListener("click", Clicku202, true);
function Clicku202(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u512 = document.getElementById('u512');

var u175 = document.getElementById('u175');

var u1259 = document.getElementById('u1259');

u1259.style.cursor = 'pointer';
if (bIE) u1259.attachEvent("onclick", Clicku1259);
else u1259.addEventListener("click", Clicku1259, true);
function Clicku1259(e)
{

if (true) {

	self.location.href="销售出库.html" + GetQuerystring();

}

}

var u1258 = document.getElementById('u1258');
gv_vAlignTable['u1258'] = 'center';
var u454 = document.getElementById('u454');

var u273 = document.getElementById('u273');

var u28 = document.getElementById('u28');

u28.style.cursor = 'pointer';
if (bIE) u28.attachEvent("onclick", Clicku28);
else u28.addEventListener("click", Clicku28, true);
function Clicku28(e)
{

if (true) {

	self.location.href="统计查询.html" + GetQuerystring();

}

}

var u422 = document.getElementById('u422');

var u922 = document.getElementById('u922');

var u1191 = document.getElementById('u1191');
gv_vAlignTable['u1191'] = 'top';
var u1190 = document.getElementById('u1190');
gv_vAlignTable['u1190'] = 'top';
var u388 = document.getElementById('u388');

var u888 = document.getElementById('u888');

var u780 = document.getElementById('u780');
gv_vAlignTable['u780'] = 'center';
var u1227 = document.getElementById('u1227');

u1227.style.cursor = 'pointer';
if (bIE) u1227.attachEvent("onclick", Clicku1227);
else u1227.addEventListener("click", Clicku1227, true);
function Clicku1227(e)
{

if (true) {

	self.location.href="04其他入库单入库完毕查看.html" + GetQuerystring();

}

}

var u332 = document.getElementById('u332');

var u832 = document.getElementById('u832');

var u184 = document.getElementById('u184');

u184.style.cursor = 'pointer';
if (bIE) u184.attachEvent("onclick", Clicku184);
else u184.addEventListener("click", Clicku184, true);
function Clicku184(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u980 = document.getElementById('u980');

var u790 = document.getElementById('u790');
gv_vAlignTable['u790'] = 'center';
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

	self.location.href="审批流程管理.html" + "";

}

}

var u552 = document.getElementById('u552');

var u391 = document.getElementById('u391');
gv_vAlignTable['u391'] = 'top';
var u328 = document.getElementById('u328');

u328.style.cursor = 'pointer';
if (bIE) u328.attachEvent("onclick", Clicku328);
else u328.addEventListener("click", Clicku328, true);
function Clicku328(e)
{

if (true) {

	self.location.href="入库单审核.html" + GetQuerystring();

}

}

var u209 = document.getElementById('u209');
gv_vAlignTable['u209'] = 'top';
var u571 = document.getElementById('u571');
gv_vAlignTable['u571'] = 'center';
var u702 = document.getElementById('u702');

var u462 = document.getElementById('u462');

var u301 = document.getElementById('u301');
gv_vAlignTable['u301'] = 'top';
var u801 = document.getElementById('u801');
gv_vAlignTable['u801'] = 'top';
var u674 = document.getElementById('u674');

var u119 = document.getElementById('u119');
gv_vAlignTable['u119'] = 'top';
var u429 = document.getElementById('u429');
gv_vAlignTable['u429'] = 'center';
var u929 = document.getElementById('u929');
gv_vAlignTable['u929'] = 'center';
var u809 = document.getElementById('u809');
gv_vAlignTable['u809'] = 'top';
var u372 = document.getElementById('u372');

u372.style.cursor = 'pointer';
if (bIE) u372.attachEvent("onclick", Clicku372);
else u372.addEventListener("click", Clicku372, true);
function Clicku372(e)
{

if (true) {

	SetPanelStateu376("pd0u376");

}

}

var u743 = document.getElementById('u743');
gv_vAlignTable['u743'] = 'top';
var u521 = document.getElementById('u521');
gv_vAlignTable['u521'] = 'center';
var u339 = document.getElementById('u339');

var u839 = document.getElementById('u839');
gv_vAlignTable['u839'] = 'center';
var u431 = document.getElementById('u431');
gv_vAlignTable['u431'] = 'center';
var u931 = document.getElementById('u931');
gv_vAlignTable['u931'] = 'center';
var u741 = document.getElementById('u741');
gv_vAlignTable['u741'] = 'top';
var u249 = document.getElementById('u249');

var u283 = document.getElementById('u283');
gv_vAlignTable['u283'] = 'top';
var u840 = document.getElementById('u840');

var u1271 = document.getElementById('u1271');

var u1270 = document.getElementById('u1270');
gv_vAlignTable['u1270'] = 'center';
var u20 = document.getElementById('u20');

var u651 = document.getElementById('u651');
gv_vAlignTable['u651'] = 'center';
var u159 = document.getElementById('u159');
gv_vAlignTable['u159'] = 'top';
var u193 = document.getElementById('u193');
gv_vAlignTable['u193'] = 'top';
var u469 = document.getElementById('u469');
gv_vAlignTable['u469'] = 'center';
var u308 = document.getElementById('u308');

var u808 = document.getElementById('u808');

var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u265 = document.getElementById('u265');
gv_vAlignTable['u265'] = 'top';
var u104 = document.getElementById('u104');

var u950 = document.getElementById('u950');

var u710 = document.getElementById('u710');

var u218 = document.getElementById('u218');

u218.style.cursor = 'pointer';
if (bIE) u218.attachEvent("onclick", Clicku218);
else u218.addEventListener("click", Clicku218, true);
function Clicku218(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u402 = document.getElementById('u402');

var u528 = document.getElementById('u528');

var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'top';
var u533 = document.getElementById('u533');
gv_vAlignTable['u533'] = 'center';
var u83 = document.getElementById('u83');
gv_vAlignTable['u83'] = 'top';
var u471 = document.getElementById('u471');
gv_vAlignTable['u471'] = 'center';
var u971 = document.getElementById('u971');
gv_vAlignTable['u971'] = 'center';
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
var u530 = document.getElementById('u530');

var u958 = document.getElementById('u958');

var u348 = document.getElementById('u348');

u348.style.cursor = 'pointer';
if (bIE) u348.attachEvent("onclick", Clicku348);
else u348.addEventListener("click", Clicku348, true);
function Clicku348(e)
{

if (true) {

	self.location.href="Resources/reload.html#" + encodeURI(PageUrl + GetQuerystring());

}

}

var u382 = document.getElementById('u382');

var u658 = document.getElementById('u658');

var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u213 = document.getElementById('u213');
gv_vAlignTable['u213'] = 'top';
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

var u364 = document.getElementById('u364');
gv_vAlignTable['u364'] = 'top';
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
gv_vAlignTable['u1057'] = 'center';
var u1056 = document.getElementById('u1056');

var u423 = document.getElementById('u423');
gv_vAlignTable['u423'] = 'center';
var u923 = document.getElementById('u923');
gv_vAlignTable['u923'] = 'center';
var u1053 = document.getElementById('u1053');
gv_vAlignTable['u1053'] = 'center';
var u1052 = document.getElementById('u1052');

var u1051 = document.getElementById('u1051');
gv_vAlignTable['u1051'] = 'center';
var u1093 = document.getElementById('u1093');
gv_vAlignTable['u1093'] = 'center';
var u850 = document.getElementById('u850');

var u389 = document.getElementById('u389');
gv_vAlignTable['u389'] = 'top';
var u889 = document.getElementById('u889');
gv_vAlignTable['u889'] = 'center';
var u333 = document.getElementById('u333');

var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u1194 = document.getElementById('u1194');

u1194.style.cursor = 'pointer';
if (bIE) u1194.attachEvent("onclick", Clicku1194);
else u1194.addEventListener("click", Clicku1194, true);
function Clicku1194(e)
{

if (true) {

	self.location.href="04其他入库单入库完毕查看.html" + GetQuerystring();

}

}

var u1193 = document.getElementById('u1193');
gv_vAlignTable['u1193'] = 'center';
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
gv_vAlignTable['u553'] = 'top';
var u167 = document.getElementById('u167');

var u302 = document.getElementById('u302');

var u802 = document.getElementById('u802');

var u612 = document.getElementById('u612');

var u982 = document.getElementById('u982');

var u1273 = document.getElementById('u1273');

var u373 = document.getElementById('u373');
gv_vAlignTable['u373'] = 'center';
var u38 = document.getElementById('u38');

u38.style.cursor = 'pointer';
if (bIE) u38.attachEvent("onclick", Clicku38);
else u38.addEventListener("click", Clicku38, true);
function Clicku38(e)
{

if (true) {

	self.location.href="售后报表查询.html" + GetQuerystring();

}

}

var u88 = document.getElementById('u88');

var u154 = document.getElementById('u154');

var u354 = document.getElementById('u354');

var u488 = document.getElementById('u488');

var u988 = document.getElementById('u988');

var u1278 = document.getElementById('u1278');
gv_vAlignTable['u1278'] = 'center';
var u29 = document.getElementById('u29');
gv_vAlignTable['u29'] = 'top';
var u432 = document.getElementById('u432');

var u932 = document.getElementById('u932');

var u480 = document.getElementById('u480');

var u580 = document.getElementById('u580');

var u398 = document.getElementById('u398');

var u876 = document.getElementById('u876');

var u342 = document.getElementById('u342');

u342.style.cursor = 'pointer';
if (bIE) u342.attachEvent("onclick", Clicku342);
else u342.addEventListener("click", Clicku342, true);
function Clicku342(e)
{

if (true) {

	self.location.href="销售入库.html" + GetQuerystring();

}

}

var u842 = document.getElementById('u842');

var u652 = document.getElementById('u652');

var u194 = document.getElementById('u194');

u194.style.cursor = 'pointer';
if (bIE) u194.attachEvent("onclick", Clicku194);
else u194.addEventListener("click", Clicku194, true);
function Clicku194(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u309 = document.getElementById('u309');
gv_vAlignTable['u309'] = 'top';
var u1157 = document.getElementById('u1157');
gv_vAlignTable['u1157'] = 'center';
var u286 = document.getElementById('u286');

var u1239 = document.getElementById('u1239');

u1239.style.cursor = 'pointer';
if (bIE) u1239.attachEvent("onclick", Clicku1239);
else u1239.addEventListener("click", Clicku1239, true);
function Clicku1239(e)
{

if (true) {

	self.location.href="销售入库.html" + GetQuerystring();

}

}

var u266 = document.getElementById('u266');

u266.style.cursor = 'pointer';
if (bIE) u266.attachEvent("onclick", Clicku266);
else u266.addEventListener("click", Clicku266, true);
function Clicku266(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u105 = document.getElementById('u105');

var u901 = document.getElementById('u901');
gv_vAlignTable['u901'] = 'center';
var u711 = document.getElementById('u711');
gv_vAlignTable['u711'] = 'center';
var u219 = document.getElementById('u219');
gv_vAlignTable['u219'] = 'top';
var u529 = document.getElementById('u529');
gv_vAlignTable['u529'] = 'center';
var u374 = document.getElementById('u374');

u374.style.cursor = 'pointer';
if (bIE) u374.attachEvent("onclick", Clicku374);
else u374.addEventListener("click", Clicku374, true);
function Clicku374(e)
{

if (true) {

	SetPanelStateu376("pd1u376");

}

}

var u622 = document.getElementById('u622');

var u176 = document.getElementById('u176');

u176.style.cursor = 'pointer';
if (bIE) u176.attachEvent("onclick", Clicku176);
else u176.addEventListener("click", Clicku176, true);
function Clicku176(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u46 = document.getElementById('u46');

u46.style.cursor = 'pointer';
if (bIE) u46.attachEvent("onclick", Clicku46);
else u46.addEventListener("click", Clicku46, true);
function Clicku46(e)
{

if (true) {

	self.location.href="产品单管理.html" + GetQuerystring();

}

}

var u325 = document.getElementById('u325');
gv_vAlignTable['u325'] = 'top';
var u825 = document.getElementById('u825');
gv_vAlignTable['u825'] = 'center';
var u443 = document.getElementById('u443');
gv_vAlignTable['u443'] = 'top';
var u439 = document.getElementById('u439');
gv_vAlignTable['u439'] = 'center';
var u939 = document.getElementById('u939');
gv_vAlignTable['u939'] = 'top';
var u722 = document.getElementById('u722');

var u396 = document.getElementById('u396');

var u1290 = document.getElementById('u1290');

u1290.style.cursor = 'pointer';
if (bIE) u1290.attachEvent("onclick", Clicku1290);
else u1290.addEventListener("click", Clicku1290, true);
function Clicku1290(e)
{

if (true) {

	self.location.href="库存盘点_1.html" + GetQuerystring();

}

}

var u882 = document.getElementById('u882');

var u976 = document.getElementById('u976');

var u235 = document.getElementById('u235');
gv_vAlignTable['u235'] = 'top';
var u349 = document.getElementById('u349');
gv_vAlignTable['u349'] = 'top';
var u383 = document.getElementById('u383');
gv_vAlignTable['u383'] = 'top';
var u883 = document.getElementById('u883');
gv_vAlignTable['u883'] = 'center';
var u763 = document.getElementById('u763');

var u30 = document.getElementById('u30');

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

var u259 = document.getElementById('u259');
gv_vAlignTable['u259'] = 'top';
var u293 = document.getElementById('u293');
gv_vAlignTable['u293'] = 'top';
var u569 = document.getElementById('u569');
gv_vAlignTable['u569'] = 'center';
var u408 = document.getElementById('u408');

var u992 = document.getElementById('u992');

var u1142 = document.getElementById('u1142');

var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
var u365 = document.getElementById('u365');

var u204 = document.getElementById('u204');

u204.style.cursor = 'pointer';
if (bIE) u204.attachEvent("onclick", Clicku204);
else u204.addEventListener("click", Clicku204, true);
function Clicku204(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u479 = document.getElementById('u479');
gv_vAlignTable['u479'] = 'center';
var u318 = document.getElementById('u318');

u318.style.cursor = 'pointer';
if (bIE) u318.attachEvent("onclick", Clicku318);
else u318.addEventListener("click", Clicku318, true);
function Clicku318(e)
{

if (true) {

	self.location.href="销售出库.html" + GetQuerystring();

}

}

var u818 = document.getElementById('u818');

var u628 = document.getElementById('u628');

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
var u275 = document.getElementById('u275');
gv_vAlignTable['u275'] = 'top';
var u114 = document.getElementById('u114');

u114.style.cursor = 'pointer';
if (bIE) u114.attachEvent("onclick", Clicku114);
else u114.addEventListener("click", Clicku114, true);
function Clicku114(e)
{

if (true) {

	self.location.href="B2B价保审核管理.html" + GetQuerystring();

}

}

var u1066 = document.getElementById('u1066');

var u720 = document.getElementById('u720');

var u924 = document.getElementById('u924');

var u186 = document.getElementById('u186');

u186.style.cursor = 'pointer';
if (bIE) u186.attachEvent("onclick", Clicku186);
else u186.addEventListener("click", Clicku186, true);
function Clicku186(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u538 = document.getElementById('u538');

var u1061 = document.getElementById('u1061');
gv_vAlignTable['u1061'] = 'center';
var u1060 = document.getElementById('u1060');

var u34 = document.getElementById('u34');

u34.style.cursor = 'pointer';
if (bIE) u34.attachEvent("onclick", Clicku34);
else u34.addEventListener("click", Clicku34, true);
function Clicku34(e)
{

if (true) {

	self.location.href="库存报表查询.html" + GetQuerystring();

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

	self.location.href="移库管理_1.html" + GetQuerystring();

}

}

var u834 = document.getElementById('u834');

var u448 = document.getElementById('u448');

var u482 = document.getElementById('u482');

var u758 = document.getElementById('u758');
gv_vAlignTable['u758'] = 'center';
var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u56 = document.getElementById('u56');

u56.style.cursor = 'pointer';
if (bIE) u56.attachEvent("onclick", Clicku56);
else u56.addEventListener("click", Clicku56, true);
function Clicku56(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u244 = document.getElementById('u244');

u244.style.cursor = 'pointer';
if (bIE) u244.attachEvent("onclick", Clicku244);
else u244.addEventListener("click", Clicku244, true);
function Clicku244(e)
{

if (true) {

	self.location.href="日志管理.html" + "";

}

}

var u296 = document.getElementById('u296');

u296.style.cursor = 'pointer';
if (bIE) u296.attachEvent("onclick", Clicku296);
else u296.addEventListener("click", Clicku296, true);
function Clicku296(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u554 = document.getElementById('u554');

var u392 = document.getElementById('u392');

var u668 = document.getElementById('u668');

var u47 = document.getElementById('u47');
gv_vAlignTable['u47'] = 'top';
var u97 = document.getElementById('u97');
gv_vAlignTable['u97'] = 'top';
var u464 = document.getElementById('u464');

var u303 = document.getElementById('u303');

var u803 = document.getElementById('u803');
gv_vAlignTable['u803'] = 'top';
var u613 = document.getElementById('u613');
gv_vAlignTable['u613'] = 'center';
var u732 = document.getElementById('u732');
gv_vAlignTable['u732'] = 'top';
var u670 = document.getElementById('u670');

var u892 = document.getElementById('u892');

var u523 = document.getElementById('u523');
gv_vAlignTable['u523'] = 'center';
var u489 = document.getElementById('u489');
gv_vAlignTable['u489'] = 'center';
var u989 = document.getElementById('u989');
gv_vAlignTable['u989'] = 'center';
var u718 = document.getElementById('u718');

var u433 = document.getElementById('u433');
gv_vAlignTable['u433'] = 'center';
var u933 = document.getElementById('u933');
gv_vAlignTable['u933'] = 'center';
var u581 = document.getElementById('u581');
gv_vAlignTable['u581'] = 'center';
var u1246 = document.getElementById('u1246');

var u399 = document.getElementById('u399');
gv_vAlignTable['u399'] = 'top';
var u899 = document.getElementById('u899');
gv_vAlignTable['u899'] = 'center';
var u1241 = document.getElementById('u1241');
gv_vAlignTable['u1241'] = 'center';
var u1018 = document.getElementById('u1018');

var u343 = document.getElementById('u343');
gv_vAlignTable['u343'] = 'top';
var u843 = document.getElementById('u843');
gv_vAlignTable['u843'] = 'top';
var u653 = document.getElementById('u653');
gv_vAlignTable['u653'] = 'center';
var u975 = document.getElementById('u975');
gv_vAlignTable['u975'] = 'center';
var u195 = document.getElementById('u195');
gv_vAlignTable['u195'] = 'top';
var u1308 = document.getElementById('u1308');

var u578 = document.getElementById('u578');

var u1249 = document.getElementById('u1249');

var u1248 = document.getElementById('u1248');

u1248.style.cursor = 'pointer';
if (bIE) u1248.attachEvent("onclick", Clicku1248);
else u1248.addEventListener("click", Clicku1248, true);
function Clicku1248(e)
{

if (true) {

	self.location.href="Resources/reload.html#" + encodeURI(PageUrl + GetQuerystring());

}

}

var u267 = document.getElementById('u267');
gv_vAlignTable['u267'] = 'top';
var u106 = document.getElementById('u106');

u106.style.cursor = 'pointer';
if (bIE) u106.attachEvent("onclick", Clicku106);
else u106.addEventListener("click", Clicku106, true);
function Clicku106(e)
{

if (true) {

	self.location.href="B2B签报管理.html" + GetQuerystring();

}

}

var u902 = document.getElementById('u902');

var u712 = document.getElementById('u712');

var u1222 = document.getElementById('u1222');
gv_vAlignTable['u1222'] = 'center';
var u522 = document.getElementById('u522');

var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u177 = document.getElementById('u177');
gv_vAlignTable['u177'] = 'top';
var u48 = document.getElementById('u48');

u48.style.cursor = 'pointer';
if (bIE) u48.attachEvent("onclick", Clicku48);
else u48.addEventListener("click", Clicku48, true);
function Clicku48(e)
{

if (true) {

	self.location.href="要货申请单管理.html" + GetQuerystring();

}

}

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

var u826 = document.getElementById('u826');

var u1229 = document.getElementById('u1229');

u1229.style.cursor = 'pointer';
if (bIE) u1229.attachEvent("onclick", Clicku1229);
else u1229.addEventListener("click", Clicku1229, true);
function Clicku1229(e)
{

if (true) {

	self.location.href="04其他入库单入库完毕查看.html" + GetQuerystring();

}

}

var u1228 = document.getElementById('u1228');
gv_vAlignTable['u1228'] = 'center';
var u563 = document.getElementById('u563');
gv_vAlignTable['u563'] = 'center';
var u588 = document.getElementById('u588');

var u965 = document.getElementById('u965');
gv_vAlignTable['u965'] = 'center';
var u1204 = document.getElementById('u1204');

var u39 = document.getElementById('u39');
gv_vAlignTable['u39'] = 'top';
var u89 = document.getElementById('u89');

var u532 = document.getElementById('u532');

var u680 = document.getElementById('u680');

var u884 = document.getElementById('u884');

var u498 = document.getElementById('u498');

var u998 = document.getElementById('u998');

var u146 = document.getElementById('u146');

u146.style.cursor = 'pointer';
if (bIE) u146.attachEvent("onclick", Clicku146);
else u146.addEventListener("click", Clicku146, true);
function Clicku146(e)
{

if (true) {

	self.location.href="EMS单据管理.html" + GetQuerystring();

}

}

var u942 = document.getElementById('u942');

var u752 = document.getElementById('u752');
gv_vAlignTable['u752'] = 'center';
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

var u501 = document.getElementById('u501');
gv_vAlignTable['u501'] = 'center';
var u319 = document.getElementById('u319');
gv_vAlignTable['u319'] = 'top';
var u819 = document.getElementById('u819');
gv_vAlignTable['u819'] = 'top';
var u507 = document.getElementById('u507');
gv_vAlignTable['u507'] = 'center';
var u1101 = document.getElementById('u1101');
gv_vAlignTable['u1101'] = 'center';
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

var u115 = document.getElementById('u115');
gv_vAlignTable['u115'] = 'top';
var u1076 = document.getElementById('u1076');

var u425 = document.getElementById('u425');
gv_vAlignTable['u425'] = 'center';
var u925 = document.getElementById('u925');
gv_vAlignTable['u925'] = 'center';
var u1073 = document.getElementById('u1073');
gv_vAlignTable['u1073'] = 'center';
var u539 = document.getElementById('u539');
gv_vAlignTable['u539'] = 'center';
var u1071 = document.getElementById('u1071');
gv_vAlignTable['u1071'] = 'center';
var u1070 = document.getElementById('u1070');

var u1084 = document.getElementById('u1084');

var u631 = document.getElementById('u631');
gv_vAlignTable['u631'] = 'center';
var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'top';
var u449 = document.getElementById('u449');
gv_vAlignTable['u449'] = 'center';
var u483 = document.getElementById('u483');
gv_vAlignTable['u483'] = 'center';
var u983 = document.getElementById('u983');
gv_vAlignTable['u983'] = 'center';
var u40 = document.getElementById('u40');

var u90 = document.getElementById('u90');

u90.style.cursor = 'pointer';
if (bIE) u90.attachEvent("onclick", Clicku90);
else u90.addEventListener("click", Clicku90, true);
function Clicku90(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u463 = document.getElementById('u463');
gv_vAlignTable['u463'] = 'center';
var u245 = document.getElementById('u245');
gv_vAlignTable['u245'] = 'top';
var u359 = document.getElementById('u359');
gv_vAlignTable['u359'] = 'center';
var u393 = document.getElementById('u393');
gv_vAlignTable['u393'] = 'top';
var u669 = document.getElementById('u669');
gv_vAlignTable['u669'] = 'center';
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

var u81 = document.getElementById('u81');
gv_vAlignTable['u81'] = 'top';
var u155 = document.getElementById('u155');

var u465 = document.getElementById('u465');
gv_vAlignTable['u465'] = 'top';
var u304 = document.getElementById('u304');

u304.style.cursor = 'pointer';
if (bIE) u304.attachEvent("onclick", Clicku304);
else u304.addEventListener("click", Clicku304, true);
function Clicku304(e)
{

if (true) {

	self.location.href="入库管理.html" + GetQuerystring();

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
gv_vAlignTable['u375'] = 'center';
var u214 = document.getElementById('u214');

u214.style.cursor = 'pointer';
if (bIE) u214.attachEvent("onclick", Clicku214);
else u214.addEventListener("click", Clicku214, true);
function Clicku214(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u181 = document.getElementById('u181');
gv_vAlignTable['u181'] = 'top';
var u524 = document.getElementById('u524');

var u1309 = document.getElementById('u1309');

u1309.style.cursor = 'pointer';
if (bIE) u1309.attachEvent("onclick", Clicku1309);
else u1309.addEventListener("click", Clicku1309, true);
function Clicku1309(e)
{

if (true) {

	self.location.href="单据单价更新.html" + GetQuerystring();

}

}

var u638 = document.getElementById('u638');

var u44 = document.getElementById('u44');

u44.style.cursor = 'pointer';
if (bIE) u44.attachEvent("onclick", Clicku44);
else u44.addEventListener("click", Clicku44, true);
function Clicku44(e)
{

if (true) {

	self.location.href="请购单审核管理.html" + GetQuerystring();

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

var u582 = document.getElementById('u582');

var u865 = document.getElementById('u865');
gv_vAlignTable['u865'] = 'center';
var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'top';
var u85 = document.getElementById('u85');
gv_vAlignTable['u85'] = 'top';
var u66 = document.getElementById('u66');

var u344 = document.getElementById('u344');

u344.style.cursor = 'pointer';
if (bIE) u344.attachEvent("onclick", Clicku344);
else u344.addEventListener("click", Clicku344, true);
function Clicku344(e)
{

if (true) {

	self.location.href="售后入库.html" + GetQuerystring();

}

}

var u844 = document.getElementById('u844');

var u654 = document.getElementById('u654');

var u196 = document.getElementById('u196');

var u768 = document.getElementById('u768');
gv_vAlignTable['u768'] = 'center';
var u57 = document.getElementById('u57');
gv_vAlignTable['u57'] = 'top';
var u517 = document.getElementById('u517');
gv_vAlignTable['u517'] = 'center';
var u1287 = document.getElementById('u1287');

u1287.style.cursor = 'pointer';
if (bIE) u1287.attachEvent("onclick", Clicku1287);
else u1287.addEventListener("click", Clicku1287, true);
function Clicku1287(e)
{

if (true) {

	self.location.href="盘点列表.html" + GetQuerystring();

}

}

var u949 = document.getElementById('u949');
gv_vAlignTable['u949'] = 'center';
var u564 = document.getElementById('u564');

var u403 = document.getElementById('u403');
gv_vAlignTable['u403'] = 'center';
var u903 = document.getElementById('u903');
gv_vAlignTable['u903'] = 'center';
var u678 = document.getElementById('u678');

var u1127 = document.getElementById('u1127');
gv_vAlignTable['u1127'] = 'center';
var u770 = document.getElementById('u770');
gv_vAlignTable['u770'] = 'center';
var u974 = document.getElementById('u974');

var u623 = document.getElementById('u623');
gv_vAlignTable['u623'] = 'center';
var u1182 = document.getElementById('u1182');
gv_vAlignTable['u1182'] = 'top';
var u385 = document.getElementById('u385');
gv_vAlignTable['u385'] = 'top';
var u1180 = document.getElementById('u1180');

var u1275 = document.getElementById('u1275');

var u589 = document.getElementById('u589');
gv_vAlignTable['u589'] = 'center';
var u168 = document.getElementById('u168');

var u473 = document.getElementById('u473');
gv_vAlignTable['u473'] = 'center';
var u681 = document.getElementById('u681');
gv_vAlignTable['u681'] = 'center';
var u885 = document.getElementById('u885');
gv_vAlignTable['u885'] = 'center';
var u499 = document.getElementById('u499');
gv_vAlignTable['u499'] = 'center';
var u999 = document.getElementById('u999');
gv_vAlignTable['u999'] = 'center';
var u542 = document.getElementById('u542');

var u1037 = document.getElementById('u1037');
gv_vAlignTable['u1037'] = 'center';
var u147 = document.getElementById('u147');
gv_vAlignTable['u147'] = 'top';
var u943 = document.getElementById('u943');
gv_vAlignTable['u943'] = 'center';
var u753 = document.getElementById('u753');

u753.style.cursor = 'pointer';
if (bIE) u753.attachEvent("onclick", Clicku753);
else u753.addEventListener("click", Clicku753, true);
function Clicku753(e)
{

if (true) {

	self.location.href="01其他入库订单待入库查看.html" + GetQuerystring();

}

}

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

var u838 = document.getElementById('u838');

var u663 = document.getElementById('u663');
gv_vAlignTable['u663'] = 'top';
var u206 = document.getElementById('u206');

u206.style.cursor = 'pointer';
if (bIE) u206.attachEvent("onclick", Clicku206);
else u206.addEventListener("click", Clicku206, true);
function Clicku206(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

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

	self.location.href="采购退货计划单管理.html" + GetQuerystring();

}

}

var u426 = document.getElementById('u426');

var u926 = document.getElementById('u926');

var u875 = document.getElementById('u875');
gv_vAlignTable['u875'] = 'center';
var u688 = document.getElementById('u688');

var u49 = document.getElementById('u49');
gv_vAlignTable['u49'] = 'top';
var u99 = document.getElementById('u99');
gv_vAlignTable['u99'] = 'top';
var u632 = document.getElementById('u632');

var u836 = document.getElementById('u836');

var u1307 = document.getElementById('u1307');
gv_vAlignTable['u1307'] = 'center';
var u484 = document.getElementById('u484');

var u984 = document.getElementById('u984');

var u1304 = document.getElementById('u1304');

var u598 = document.getElementById('u598');

var u611 = document.getElementById('u611');
gv_vAlignTable['u611'] = 'center';
var u1301 = document.getElementById('u1301');

u1301.style.cursor = 'pointer';
if (bIE) u1301.attachEvent("onclick", Clicku1301);
else u1301.addEventListener("click", Clicku1301, true);
function Clicku1301(e)
{

if (true) {

	self.location.href="出库单审核.html" + GetQuerystring();

}

}

var u285 = document.getElementById('u285');
gv_vAlignTable['u285'] = 'top';
var u246 = document.getElementById('u246');

u246.style.cursor = 'pointer';
if (bIE) u246.attachEvent("onclick", Clicku246);
else u246.addEventListener("click", Clicku246, true);
function Clicku246(e)
{

if (true) {

	self.location.href="系统参数管理.html" + GetQuerystring();

}

}

var u401 = document.getElementById('u401');
gv_vAlignTable['u401'] = 'center';
var u394 = document.getElementById('u394');

var u894 = document.getElementById('u894');

var u509 = document.getElementById('u509');
gv_vAlignTable['u509'] = 'top';
var u156 = document.getElementById('u156');

u156.style.cursor = 'pointer';
if (bIE) u156.attachEvent("onclick", Clicku156);
else u156.addEventListener("click", Clicku156, true);
function Clicku156(e)
{

if (true) {

	self.location.href="基础资料管理.html" + GetQuerystring();

}

}

var u466 = document.getElementById('u466');

var u601 = document.getElementById('u601');
gv_vAlignTable['u601'] = 'center';
var u805 = document.getElementById('u805');
gv_vAlignTable['u805'] = 'top';
var u442 = document.getElementById('u442');

var u419 = document.getElementById('u419');
gv_vAlignTable['u419'] = 'center';
var u799 = document.getElementById('u799');
gv_vAlignTable['u799'] = 'top';
var u729 = document.getElementById('u729');
gv_vAlignTable['u729'] = 'top';
var u1280 = document.getElementById('u1280');

var u672 = document.getElementById('u672');

var u215 = document.getElementById('u215');
gv_vAlignTable['u215'] = 'top';
var u525 = document.getElementById('u525');
gv_vAlignTable['u525'] = 'center';
var u1288 = document.getElementById('u1288');

var u1065 = document.getElementById('u1065');
gv_vAlignTable['u1065'] = 'center';
var u639 = document.getElementById('u639');
gv_vAlignTable['u639'] = 'center';
var u762 = document.getElementById('u762');
gv_vAlignTable['u762'] = 'center';
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

	self.location.href="调拨要货单管理.html" + GetQuerystring();

}

}

var u345 = document.getElementById('u345');
gv_vAlignTable['u345'] = 'top';
var u845 = document.getElementById('u845');
gv_vAlignTable['u845'] = 'center';
var u459 = document.getElementById('u459');
gv_vAlignTable['u459'] = 'center';
var u197 = document.getElementById('u197');

var u769 = document.getElementById('u769');

var u608 = document.getElementById('u608');

var u41 = document.getElementById('u41');

var u91 = document.getElementById('u91');
gv_vAlignTable['u91'] = 'top';
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

	self.location.href="采购报表查询.html" + GetQuerystring();

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
gv_vAlignTable['u475'] = 'center';
var u314 = document.getElementById('u314');

var u814 = document.getElementById('u814');

var u624 = document.getElementById('u624');

var u738 = document.getElementById('u738');
gv_vAlignTable['u738'] = 'top';
var u1144 = document.getElementById('u1144');

var u54 = document.getElementById('u54');

u54.style.cursor = 'pointer';
if (bIE) u54.attachEvent("onclick", Clicku54);
else u54.addEventListener("click", Clicku54, true);
function Clicku54(e)
{

if (true) {

	self.location.href="采购结算单管理.html" + GetQuerystring();

}

}

var u928 = document.getElementById('u928');

var u621 = document.getElementById('u621');
gv_vAlignTable['u621'] = 'center';
var u534 = document.getElementById('u534');

var u648 = document.getElementById('u648');

var u682 = document.getElementById('u682');

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
gv_vAlignTable['u754'] = 'center';
var u592 = document.getElementById('u592');

var u67 = document.getElementById('u67');
gv_vAlignTable['u67'] = 'top';
var u731 = document.getElementById('u731');
gv_vAlignTable['u731'] = 'center';
var u977 = document.getElementById('u977');
gv_vAlignTable['u977'] = 'center';
var u664 = document.getElementById('u664');

var u207 = document.getElementById('u207');
gv_vAlignTable['u207'] = 'top';
var u778 = document.getElementById('u778');
gv_vAlignTable['u778'] = 'center';
var u574 = document.getElementById('u574');

var u117 = document.getElementById('u117');
gv_vAlignTable['u117'] = 'top';
var u723 = document.getElementById('u723');
gv_vAlignTable['u723'] = 'center';
var u1237 = document.getElementById('u1237');

var u1236 = document.getElementById('u1236');

u1236.style.cursor = 'pointer';
if (bIE) u1236.attachEvent("onclick", Clicku1236);
else u1236.addEventListener("click", Clicku1236, true);
function Clicku1236(e)
{

if (true) {

	self.location.href="采购入库.html" + GetQuerystring();

}

}

var u1235 = document.getElementById('u1235');

var u1234 = document.getElementById('u1234');
gv_vAlignTable['u1234'] = 'center';
var u689 = document.getElementById('u689');
gv_vAlignTable['u689'] = 'center';
var u633 = document.getElementById('u633');
gv_vAlignTable['u633'] = 'center';
var u837 = document.getElementById('u837');
gv_vAlignTable['u837'] = 'center';
var u485 = document.getElementById('u485');
gv_vAlignTable['u485'] = 'center';
var u985 = document.getElementById('u985');
gv_vAlignTable['u985'] = 'center';
var u1314 = document.getElementById('u1314');
gv_vAlignTable['u1314'] = 'center';
var u599 = document.getElementById('u599');
gv_vAlignTable['u599'] = 'center';
var u1312 = document.getElementById('u1312');

u1312.style.cursor = 'pointer';
if (bIE) u1312.attachEvent("onclick", Clicku1312);
else u1312.addEventListener("click", Clicku1312, true);
function Clicku1312(e)
{

if (true) {

	self.location.href="单据详情.html" + GetQuerystring();

}

}

var u1311 = document.getElementById('u1311');
gv_vAlignTable['u1311'] = 'center';
var u1310 = document.getElementById('u1310');

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

var u562 = document.getElementById('u562');

var u1006 = document.getElementById('u1006');

var u1005 = document.getElementById('u1005');
gv_vAlignTable['u1005'] = 'center';
var u1004 = document.getElementById('u1004');

var u1003 = document.getElementById('u1003');
gv_vAlignTable['u1003'] = 'center';
var u1002 = document.getElementById('u1002');

var u1125 = document.getElementById('u1125');
gv_vAlignTable['u1125'] = 'center';
var u1000 = document.getElementById('u1000');

var u673 = document.getElementById('u673');
gv_vAlignTable['u673'] = 'center';
var u68 = document.getElementById('u68');

var u526 = document.getElementById('u526');

var u1009 = document.getElementById('u1009');
gv_vAlignTable['u1009'] = 'center';
var u1008 = document.getElementById('u1008');

var u788 = document.getElementById('u788');
gv_vAlignTable['u788'] = 'center';
var u1129 = document.getElementById('u1129');
gv_vAlignTable['u1129'] = 'center';
var u59 = document.getElementById('u59');
gv_vAlignTable['u59'] = 'top';
var u436 = document.getElementById('u436');

var u936 = document.getElementById('u936');

var u1181 = document.getElementById('u1181');
gv_vAlignTable['u1181'] = 'center';
var u584 = document.getElementById('u584');

var u698 = document.getElementById('u698');

var u642 = document.getElementById('u642');

var u846 = document.getElementById('u846');

var u494 = document.getElementById('u494');

var u994 = document.getElementById('u994');

var u609 = document.getElementById('u609');
gv_vAlignTable['u609'] = 'center';
var u721 = document.getElementById('u721');
gv_vAlignTable['u721'] = 'center';
var u256 = document.getElementById('u256');

var u566 = document.getElementById('u566');

var u701 = document.getElementById('u701');
gv_vAlignTable['u701'] = 'center';
var u905 = document.getElementById('u905');
gv_vAlignTable['u905'] = 'center';
var u1265 = document.getElementById('u1265');

u1265.style.cursor = 'pointer';
if (bIE) u1265.attachEvent("onclick", Clicku1265);
else u1265.addEventListener("click", Clicku1265, true);
function Clicku1265(e)
{

if (true) {

	self.location.href="借机出库.html" + GetQuerystring();

}

}

var u519 = document.getElementById('u519');
gv_vAlignTable['u519'] = 'center';
var u369 = document.getElementById('u369');
gv_vAlignTable['u369'] = 'top';
var u772 = document.getElementById('u772');
gv_vAlignTable['u772'] = 'center';
var u315 = document.getElementById('u315');

var u815 = document.getElementById('u815');
gv_vAlignTable['u815'] = 'top';
var u625 = document.getElementById('u625');
gv_vAlignTable['u625'] = 'center';
var u739 = document.getElementById('u739');

var u535 = document.getElementById('u535');
gv_vAlignTable['u535'] = 'center';
var u946 = document.getElementById('u946');

var u649 = document.getElementById('u649');
gv_vAlignTable['u649'] = 'center';
var u683 = document.getElementById('u683');
gv_vAlignTable['u683'] = 'center';
var u887 = document.getElementById('u887');
gv_vAlignTable['u887'] = 'center';
var u531 = document.getElementById('u531');
gv_vAlignTable['u531'] = 'top';
var u60 = document.getElementById('u60');

u60.style.cursor = 'pointer';
if (bIE) u60.attachEvent("onclick", Clicku60);
else u60.addEventListener("click", Clicku60, true);
function Clicku60(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u849 = document.getElementById('u849');
gv_vAlignTable['u849'] = 'center';
var u169 = document.getElementById('u169');
gv_vAlignTable['u169'] = 'top';
var u445 = document.getElementById('u445');
gv_vAlignTable['u445'] = 'center';
var u945 = document.getElementById('u945');
gv_vAlignTable['u945'] = 'center';
var u559 = document.getElementById('u559');
gv_vAlignTable['u559'] = 'center';
var u297 = document.getElementById('u297');
gv_vAlignTable['u297'] = 'top';
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

var u572 = document.getElementById('u572');

var u51 = document.getElementById('u51');
gv_vAlignTable['u51'] = 'top';
var u355 = document.getElementById('u355');
gv_vAlignTable['u355'] = 'center';
var u855 = document.getElementById('u855');
gv_vAlignTable['u855'] = 'center';
var u665 = document.getElementById('u665');
gv_vAlignTable['u665'] = 'center';
var u504 = document.getElementById('u504');

var u337 = document.getElementById('u337');
gv_vAlignTable['u337'] = 'top';
var u779 = document.getElementById('u779');

u779.style.cursor = 'pointer';
if (bIE) u779.attachEvent("onclick", Clicku779);
else u779.addEventListener("click", Clicku779, true);
function Clicku779(e)
{

if (true) {

	self.location.href="02其他入库订单已入库查看.html" + GetQuerystring();

}

}

var u618 = document.getElementById('u618');

var u107 = document.getElementById('u107');
gv_vAlignTable['u107'] = 'top';
var u42 = document.getElementById('u42');

u42.style.cursor = 'pointer';
if (bIE) u42.attachEvent("onclick", Clicku42);
else u42.addEventListener("click", Clicku42, true);
function Clicku42(e)
{

if (true) {

	self.location.href="请购单管理.html" + GetQuerystring();

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

var u575 = document.getElementById('u575');
gv_vAlignTable['u575'] = 'top';
var u414 = document.getElementById('u414');

var u914 = document.getElementById('u914');

var u724 = document.getElementById('u724');

var u864 = document.getElementById('u864');

var u64 = document.getElementById('u64');

var u634 = document.getElementById('u634');

var u748 = document.getElementById('u748');
gv_vAlignTable['u748'] = 'center';
var u486 = document.getElementById('u486');

var u986 = document.getElementById('u986');

var u55 = document.getElementById('u55');
gv_vAlignTable['u55'] = 'top';
var u544 = document.getElementById('u544');

var u692 = document.getElementById('u692');

var u896 = document.getElementById('u896');

var u77 = document.getElementById('u77');
gv_vAlignTable['u77'] = 'top';
var u764 = document.getElementById('u764');
gv_vAlignTable['u764'] = 'center';
var u307 = document.getElementById('u307');
gv_vAlignTable['u307'] = 'top';
var u807 = document.getElementById('u807');
gv_vAlignTable['u807'] = 'top';
var u384 = document.getElementById('u384');

var u1017 = document.getElementById('u1017');
gv_vAlignTable['u1017'] = 'center';
var u1016 = document.getElementById('u1016');

var u972 = document.getElementById('u972');

var u1014 = document.getElementById('u1014');

var u1013 = document.getElementById('u1013');
gv_vAlignTable['u1013'] = 'center';
var u1012 = document.getElementById('u1012');

var u1011 = document.getElementById('u1011');
gv_vAlignTable['u1011'] = 'top';
var u1010 = document.getElementById('u1010');

var u472 = document.getElementById('u472');

var u217 = document.getElementById('u217');
gv_vAlignTable['u217'] = 'top';
var u75 = document.getElementById('u75');
gv_vAlignTable['u75'] = 'top';
var u1019 = document.getElementById('u1019');
gv_vAlignTable['u1019'] = 'center';
var u570 = document.getElementById('u570');

var u237 = document.getElementById('u237');
gv_vAlignTable['u237'] = 'top';
var u789 = document.getElementById('u789');

u789.style.cursor = 'pointer';
if (bIE) u789.attachEvent("onclick", Clicku789);
else u789.addEventListener("click", Clicku789, true);
function Clicku789(e)
{

if (true) {

	self.location.href="01其他入库订单待入库查看.html" + GetQuerystring();

}

}

var u1027 = document.getElementById('u1027');
gv_vAlignTable['u1027'] = 'center';
var u111 = document.getElementById('u111');
gv_vAlignTable['u111'] = 'top';
var u127 = document.getElementById('u127');
gv_vAlignTable['u127'] = 'top';
var u1024 = document.getElementById('u1024');

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

	self.location.href="出库管理.html" + GetQuerystring();

}

}

var u585 = document.getElementById('u585');
gv_vAlignTable['u585'] = 'center';
var u699 = document.getElementById('u699');
gv_vAlignTable['u699'] = 'center';
var u152 = document.getElementById('u152');

u152.style.cursor = 'pointer';
if (bIE) u152.attachEvent("onclick", Clicku152);
else u152.addEventListener("click", Clicku152, true);
function Clicku152(e)
{

if (true) {

	self.location.href="物流地域维护管理.html" + GetQuerystring();

}

}

var u347 = document.getElementById('u347');
gv_vAlignTable['u347'] = 'top';
var u847 = document.getElementById('u847');
gv_vAlignTable['u847'] = 'center';
var u495 = document.getElementById('u495');
gv_vAlignTable['u495'] = 'center';
var u995 = document.getElementById('u995');
gv_vAlignTable['u995'] = 'center';
var u833 = document.getElementById('u833');
gv_vAlignTable['u833'] = 'center';
var u1087 = document.getElementById('u1087');
gv_vAlignTable['u1087'] = 'center';
var u1086 = document.getElementById('u1086');

var u1085 = document.getElementById('u1085');
gv_vAlignTable['u1085'] = 'center';
var u257 = document.getElementById('u257');

var u1083 = document.getElementById('u1083');
gv_vAlignTable['u1083'] = 'top';
var u567 = document.getElementById('u567');
gv_vAlignTable['u567'] = 'center';
var u406 = document.getElementById('u406');

var u1080 = document.getElementById('u1080');

var u874 = document.getElementById('u874');

var u1089 = document.getElementById('u1089');
gv_vAlignTable['u1089'] = 'center';
var u1088 = document.getElementById('u1088');

var u773 = document.getElementById('u773');

u773.style.cursor = 'pointer';
if (bIE) u773.attachEvent("onclick", Clicku773);
else u773.addEventListener("click", Clicku773, true);
function Clicku773(e)
{

if (true) {

	self.location.href="02其他入库订单已入库查看.html" + GetQuerystring();

}

}

var u78 = document.getElementById('u78');

var u816 = document.getElementById('u816');

var u626 = document.getElementById('u626');

var u1107 = document.getElementById('u1107');
gv_vAlignTable['u1107'] = 'top';
var u1106 = document.getElementById('u1106');

var u1105 = document.getElementById('u1105');
gv_vAlignTable['u1105'] = 'center';
var u1104 = document.getElementById('u1104');

var u610 = document.getElementById('u610');

var u1102 = document.getElementById('u1102');

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

var u1100 = document.getElementById('u1100');

var u69 = document.getElementById('u69');
gv_vAlignTable['u69'] = 'top';
var u536 = document.getElementById('u536');

var u727 = document.getElementById('u727');
gv_vAlignTable['u727'] = 'center';
var u1109 = document.getElementById('u1109');
gv_vAlignTable['u1109'] = 'center';
var u684 = document.getElementById('u684');

var u190 = document.getElementById('u190');

u190.style.cursor = 'pointer';
if (bIE) u190.attachEvent("onclick", Clicku190);
else u190.addEventListener("click", Clicku190, true);
function Clicku190(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u446 = document.getElementById('u446');

var u137 = document.getElementById('u137');
gv_vAlignTable['u137'] = 'top';
var u594 = document.getElementById('u594');

var u798 = document.getElementById('u798');

var u709 = document.getElementById('u709');
gv_vAlignTable['u709'] = 'center';
var u128 = document.getElementById('u128');

var u356 = document.getElementById('u356');

var u856 = document.getElementById('u856');

var u666 = document.getElementById('u666');

var u505 = document.getElementById('u505');
gv_vAlignTable['u505'] = 'center';
var u619 = document.getElementById('u619');
gv_vAlignTable['u619'] = 'top';
var u33 = document.getElementById('u33');
gv_vAlignTable['u33'] = 'top';
var u247 = document.getElementById('u247');
gv_vAlignTable['u247'] = 'top';
var u576 = document.getElementById('u576');

var u415 = document.getElementById('u415');
gv_vAlignTable['u415'] = 'center';
var u915 = document.getElementById('u915');
gv_vAlignTable['u915'] = 'top';
var u725 = document.getElementById('u725');
gv_vAlignTable['u725'] = 'center';
var u783 = document.getElementById('u783');

u783.style.cursor = 'pointer';
if (bIE) u783.attachEvent("onclick", Clicku783);
else u783.addEventListener("click", Clicku783, true);
function Clicku783(e)
{

if (true) {

	self.location.href="01其他入库订单待入库查看.html" + GetQuerystring();

}

}

var u316 = document.getElementById('u316');

u316.style.cursor = 'pointer';
if (bIE) u316.attachEvent("onclick", Clicku316);
else u316.addEventListener("click", Clicku316, true);
function Clicku316(e)
{

if (true) {

	self.location.href="采购退库.html" + GetQuerystring();

}

}

var u635 = document.getElementById('u635');
gv_vAlignTable['u635'] = 'center';
var u1128 = document.getElementById('u1128');

var u749 = document.getElementById('u749');
gv_vAlignTable['u749'] = 'top';
var u487 = document.getElementById('u487');
gv_vAlignTable['u487'] = 'top';
var u987 = document.getElementById('u987');
gv_vAlignTable['u987'] = 'top';
var u70 = document.getElementById('u70');

var u510 = document.getElementById('u510');

var u659 = document.getElementById('u659');
gv_vAlignTable['u659'] = 'center';
var u397 = document.getElementById('u397');
gv_vAlignTable['u397'] = 'top';
var u897 = document.getElementById('u897');
gv_vAlignTable['u897'] = 'center';
var u200 = document.getElementById('u200');

u200.style.cursor = 'pointer';
if (bIE) u200.attachEvent("onclick", Clicku200);
else u200.addEventListener("click", Clicku200, true);
function Clicku200(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u61 = document.getElementById('u61');
gv_vAlignTable['u61'] = 'top';
var u858 = document.getElementById('u858');

var u455 = document.getElementById('u455');
gv_vAlignTable['u455'] = 'center';
var u955 = document.getElementById('u955');
gv_vAlignTable['u955'] = 'center';
var u765 = document.getElementById('u765');

u765.style.cursor = 'pointer';
if (bIE) u765.attachEvent("onclick", Clicku765);
else u765.addEventListener("click", Clicku765, true);
function Clicku765(e)
{

if (true) {

	self.location.href="01其他入库订单待入库查看.html" + GetQuerystring();

}

}

var u604 = document.getElementById('u604');

var u1082 = document.getElementById('u1082');

var u378 = document.getElementById('u378');

var u1026 = document.getElementById('u1026');

var u1025 = document.getElementById('u1025');
gv_vAlignTable['u1025'] = 'center';
var u52 = document.getElementById('u52');

u52.style.cursor = 'pointer';
if (bIE) u52.attachEvent("onclick", Clicku52);
else u52.addEventListener("click", Clicku52, true);
function Clicku52(e)
{

if (true) {

	self.location.href="采购单管理.html" + GetQuerystring();

}

}

var u1023 = document.getElementById('u1023');
gv_vAlignTable['u1023'] = 'center';
var u1022 = document.getElementById('u1022');

var u1021 = document.getElementById('u1021');
gv_vAlignTable['u1021'] = 'center';
var u1020 = document.getElementById('u1020');

var u675 = document.getElementById('u675');
gv_vAlignTable['u675'] = 'center';
var u514 = document.getElementById('u514');

var u1029 = document.getElementById('u1029');
gv_vAlignTable['u1029'] = 'center';
var u1028 = document.getElementById('u1028');

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
gv_vAlignTable['u661'] = 'center';
var u1201 = document.getElementById('u1201');
gv_vAlignTable['u1201'] = 'top';
var u908 = document.getElementById('u908');

var u734 = document.getElementById('u734');

var u240 = document.getElementById('u240');

u240.style.cursor = 'pointer';
if (bIE) u240.attachEvent("onclick", Clicku240);
else u240.addEventListener("click", Clicku240, true);
function Clicku240(e)
{

if (true) {

	self.location.href="组织结构管理.html" + "";

}

}

var u586 = document.getElementById('u586');

var u65 = document.getElementById('u65');

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

u216.style.cursor = 'pointer';
if (bIE) u216.attachEvent("onclick", Clicku216);
else u216.addEventListener("click", Clicku216, true);
function Clicku216(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u644 = document.getElementById('u644');

var u150 = document.getElementById('u150');

u150.style.cursor = 'pointer';
if (bIE) u150.attachEvent("onclick", Clicku150);
else u150.addEventListener("click", Clicku150, true);
function Clicku150(e)
{

if (true) {

	self.location.href="发货状态管理.html" + GetQuerystring();

}

}

var u496 = document.getElementById('u496');

var u996 = document.getElementById('u996');

var u771 = document.getElementById('u771');

u771.style.cursor = 'pointer';
if (bIE) u771.attachEvent("onclick", Clicku771);
else u771.addEventListener("click", Clicku771, true);
function Clicku771(e)
{

if (true) {

	self.location.href="01其他入库订单待入库查看.html" + GetQuerystring();

}

}

var u1097 = document.getElementById('u1097');
gv_vAlignTable['u1097'] = 'center';
var u1096 = document.getElementById('u1096');

var u1095 = document.getElementById('u1095');
gv_vAlignTable['u1095'] = 'center';
var u1094 = document.getElementById('u1094');

var u921 = document.getElementById('u921');
gv_vAlignTable['u921'] = 'center';
var u1092 = document.getElementById('u1092');

var u407 = document.getElementById('u407');
gv_vAlignTable['u407'] = 'center';
var u1090 = document.getElementById('u1090');

var u1225 = document.getElementById('u1225');

u1225.style.cursor = 'pointer';
if (bIE) u1225.attachEvent("onclick", Clicku1225);
else u1225.addEventListener("click", Clicku1225, true);
function Clicku1225(e)
{

if (true) {

	self.location.href="03其他入库单入库查看.html" + GetQuerystring();

}

}

var u1224 = document.getElementById('u1224');
gv_vAlignTable['u1224'] = 'center';
var u1223 = document.getElementById('u1223');

u1223.style.cursor = 'pointer';
if (bIE) u1223.attachEvent("onclick", Clicku1223);
else u1223.addEventListener("click", Clicku1223, true);
function Clicku1223(e)
{

if (true) {

	self.location.href="04其他入库单入库完毕查看.html" + GetQuerystring();

}

}

var u793 = document.getElementById('u793');
gv_vAlignTable['u793'] = 'top';
var u1099 = document.getElementById('u1099');
gv_vAlignTable['u1099'] = 'center';
var u1098 = document.getElementById('u1098');

var u1238 = document.getElementById('u1238');
gv_vAlignTable['u1238'] = 'center';
var u774 = document.getElementById('u774');
gv_vAlignTable['u774'] = 'center';
var u317 = document.getElementById('u317');
gv_vAlignTable['u317'] = 'top';
var u817 = document.getElementById('u817');
gv_vAlignTable['u817'] = 'top';
var u1117 = document.getElementById('u1117');
gv_vAlignTable['u1117'] = 'center';
var u1116 = document.getElementById('u1116');

var u1115 = document.getElementById('u1115');
gv_vAlignTable['u1115'] = 'center';
var u1114 = document.getElementById('u1114');

var u1113 = document.getElementById('u1113');
gv_vAlignTable['u1113'] = 'center';
var u1112 = document.getElementById('u1112');

var u1111 = document.getElementById('u1111');
gv_vAlignTable['u1111'] = 'center';
var u1110 = document.getElementById('u1110');

var u227 = document.getElementById('u227');

var u1262 = document.getElementById('u1262');

u1262.style.cursor = 'pointer';
if (bIE) u1262.attachEvent("onclick", Clicku1262);
else u1262.addEventListener("click", Clicku1262, true);
function Clicku1262(e)
{

if (true) {

	self.location.href="售后出库.html" + GetQuerystring();

}

}

var u537 = document.getElementById('u537');
gv_vAlignTable['u537'] = 'center';
var u1298 = document.getElementById('u1298');

u1298.style.cursor = 'pointer';
if (bIE) u1298.attachEvent("onclick", Clicku1298);
else u1298.addEventListener("click", Clicku1298, true);
function Clicku1298(e)
{

if (true) {

	self.location.href="入库单审核.html" + GetQuerystring();

}

}

var u1119 = document.getElementById('u1119');
gv_vAlignTable['u1119'] = 'center';
var u685 = document.getElementById('u685');
gv_vAlignTable['u685'] = 'top';
var u191 = document.getElementById('u191');
gv_vAlignTable['u191'] = 'top';
var u1269 = document.getElementById('u1269');

var u447 = document.getElementById('u447');
gv_vAlignTable['u447'] = 'center';
var u947 = document.getElementById('u947');
gv_vAlignTable['u947'] = 'center';
var u561 = document.getElementById('u561');
gv_vAlignTable['u561'] = 'center';
var u595 = document.getElementById('u595');
gv_vAlignTable['u595'] = 'center';
var u205 = document.getElementById('u205');
gv_vAlignTable['u205'] = 'top';
var u1244 = document.getElementById('u1244');
gv_vAlignTable['u1244'] = 'center';
var u1047 = document.getElementById('u1047');
gv_vAlignTable['u1047'] = 'center';
var u357 = document.getElementById('u357');
gv_vAlignTable['u357'] = 'center';
var u630 = document.getElementById('u630');

var u667 = document.getElementById('u667');
gv_vAlignTable['u667'] = 'center';
var u506 = document.getElementById('u506');

var u1077 = document.getElementById('u1077');
gv_vAlignTable['u1077'] = 'center';
var u116 = document.getElementById('u116');

u116.style.cursor = 'pointer';
if (bIE) u116.attachEvent("onclick", Clicku116);
else u116.addEventListener("click", Clicku116, true);
function Clicku116(e)
{

if (true) {

	self.location.href="B2B电子渠道库存管理.html" + GetQuerystring();

}

}

var u1075 = document.getElementById('u1075');
gv_vAlignTable['u1075'] = 'center';
var u1074 = document.getElementById('u1074');

var u1187 = document.getElementById('u1187');

var u1072 = document.getElementById('u1072');

var u1185 = document.getElementById('u1185');
gv_vAlignTable['u1185'] = 'top';
var u1184 = document.getElementById('u1184');

var u367 = document.getElementById('u367');

var u577 = document.getElementById('u577');
gv_vAlignTable['u577'] = 'center';
var u416 = document.getElementById('u416');

var u916 = document.getElementById('u916');

var u726 = document.getElementById('u726');

var u1079 = document.getElementById('u1079');
gv_vAlignTable['u1079'] = 'center';
var u1078 = document.getElementById('u1078');

var u1189 = document.getElementById('u1189');

var u1188 = document.getElementById('u1188');
gv_vAlignTable['u1188'] = 'top';
var u79 = document.getElementById('u79');

var u693 = document.getElementById('u693');
gv_vAlignTable['u693'] = 'center';
var u636 = document.getElementById('u636');

var u1207 = document.getElementById('u1207');
gv_vAlignTable['u1207'] = 'top';
var u1206 = document.getElementById('u1206');

var u1205 = document.getElementById('u1205');
gv_vAlignTable['u1205'] = 'top';
var u784 = document.getElementById('u784');
gv_vAlignTable['u784'] = 'center';
var u1203 = document.getElementById('u1203');
gv_vAlignTable['u1203'] = 'top';
var u1091 = document.getElementById('u1091');
gv_vAlignTable['u1091'] = 'center';
var u477 = document.getElementById('u477');
gv_vAlignTable['u477'] = 'center';
var u1200 = document.getElementById('u1200');

var u963 = document.getElementById('u963');
gv_vAlignTable['u963'] = 'top';
var u546 = document.getElementById('u546');

var u1209 = document.getElementById('u1209');

u1209.style.cursor = 'pointer';
if (bIE) u1209.attachEvent("onclick", Clicku1209);
else u1209.addEventListener("click", Clicku1209, true);
function Clicku1209(e)
{

if (true) {

	self.location.href="03其他入库单入库查看.html" + GetQuerystring();

}

}

var u694 = document.getElementById('u694');

var u420 = document.getElementById('u420');

var u456 = document.getElementById('u456');

var u956 = document.getElementById('u956');

var u766 = document.getElementById('u766');
gv_vAlignTable['u766'] = 'center';
var u605 = document.getElementById('u605');
gv_vAlignTable['u605'] = 'center';
var u719 = document.getElementById('u719');
gv_vAlignTable['u719'] = 'center';
var u1036 = document.getElementById('u1036');

var u1035 = document.getElementById('u1035');
gv_vAlignTable['u1035'] = 'top';
var u1034 = document.getElementById('u1034');

var u1033 = document.getElementById('u1033');
gv_vAlignTable['u1033'] = 'center';
var u1032 = document.getElementById('u1032');

var u1031 = document.getElementById('u1031');
gv_vAlignTable['u1031'] = 'center';
var u1030 = document.getElementById('u1030');

var u676 = document.getElementById('u676');

var u515 = document.getElementById('u515');
gv_vAlignTable['u515'] = 'center';
var u226 = document.getElementById('u226');

var u1039 = document.getElementById('u1039');
gv_vAlignTable['u1039'] = 'center';
var u1038 = document.getElementById('u1038');

var u907 = document.getElementById('u907');
gv_vAlignTable['u907'] = 'center';
var u735 = document.getElementById('u735');
gv_vAlignTable['u735'] = 'top';
var u878 = document.getElementById('u878');

var u1306 = document.getElementById('u1306');

u1306.style.cursor = 'pointer';
if (bIE) u1306.attachEvent("onclick", Clicku1306);
else u1306.addEventListener("click", Clicku1306, true);
function Clicku1306(e)
{

if (true) {

	self.location.href="无单价单据维护.html" + GetQuerystring();

}

}

var u241 = document.getElementById('u241');
gv_vAlignTable['u241'] = 'top';
var u587 = document.getElementById('u587');
gv_vAlignTable['u587'] = 'center';
var u1303 = document.getElementById('u1303');
gv_vAlignTable['u1303'] = 'center';
var u141 = document.getElementById('u141');
gv_vAlignTable['u141'] = 'top';
var u645 = document.getElementById('u645');
gv_vAlignTable['u645'] = 'center';
var u336 = document.getElementById('u336');

u336.style.cursor = 'pointer';
if (bIE) u336.attachEvent("onclick", Clicku336);
else u336.addEventListener("click", Clicku336, true);
function Clicku336(e)
{

if (true) {

	self.location.href="移库审核.html" + GetQuerystring();

}

}

var u759 = document.getElementById('u759');

u759.style.cursor = 'pointer';
if (bIE) u759.attachEvent("onclick", Clicku759);
else u759.addEventListener("click", Clicku759, true);
function Clicku759(e)
{

if (true) {

	self.location.href="01其他入库订单待入库查看.html" + GetQuerystring();

}

}

var u497 = document.getElementById('u497');
gv_vAlignTable['u497'] = 'center';
var u997 = document.getElementById('u997');
gv_vAlignTable['u997'] = 'center';
var u593 = document.getElementById('u593');
gv_vAlignTable['u593'] = 'center';
var u800 = document.getElementById('u800');

var u71 = document.getElementById('u71');
gv_vAlignTable['u71'] = 'top';
var u405 = document.getElementById('u405');
gv_vAlignTable['u405'] = 'center';
var u555 = document.getElementById('u555');
gv_vAlignTable['u555'] = 'center';
var u377 = document.getElementById('u377');

var u704 = document.getElementById('u704');

var u863 = document.getElementById('u863');
gv_vAlignTable['u863'] = 'center';
var u210 = document.getElementById('u210');

var u62 = document.getElementById('u62');

u62.style.cursor = 'pointer';
if (bIE) u62.attachEvent("onclick", Clicku62);
else u62.addEventListener("click", Clicku62, true);
function Clicku62(e)
{

if (true) {

	self.location.href="采购退货单管理.html" + GetQuerystring();

}

}

var u775 = document.getElementById('u775');

var u614 = document.getElementById('u614');

var u1139 = document.getElementById('u1139');
gv_vAlignTable['u1139'] = 'center';
var u228 = document.getElementById('u228');

u228.style.cursor = 'pointer';
if (bIE) u228.attachEvent("onclick", Clicku228);
else u228.addEventListener("click", Clicku228, true);
function Clicku228(e)
{

if (true) {

	self.location.href="用户管理.html" + "";

}

}

var u120 = document.getElementById('u120');

u120.style.cursor = 'pointer';
if (bIE) u120.attachEvent("onclick", Clicku120);
else u120.addEventListener("click", Clicku120, true);
function Clicku120(e)
{

if (true) {

	self.location.href="B2B预存款管理.html" + GetQuerystring();

}

}

var u1126 = document.getElementById('u1126');

var u370 = document.getElementById('u370');
gv_vAlignTable['u370'] = 'top';
var u1124 = document.getElementById('u1124');

var u1123 = document.getElementById('u1123');
gv_vAlignTable['u1123'] = 'center';
var u1122 = document.getElementById('u1122');

var u1121 = document.getElementById('u1121');
gv_vAlignTable['u1121'] = 'center';
var u1120 = document.getElementById('u1120');

var u973 = document.getElementById('u973');
gv_vAlignTable['u973'] = 'center';
var u340 = document.getElementById('u340');

u340.style.cursor = 'pointer';
if (bIE) u340.attachEvent("onclick", Clicku340);
else u340.addEventListener("click", Clicku340, true);
function Clicku340(e)
{

if (true) {

	self.location.href="采购入库.html" + GetQuerystring();

}

}

var u686 = document.getElementById('u686');

var u158 = document.getElementById('u158');

u158.style.cursor = 'pointer';
if (bIE) u158.attachEvent("onclick", Clicku158);
else u158.addEventListener("click", Clicku158, true);
function Clicku158(e)
{

if (true) {

	self.location.href="应收_应付管理.html" + GetQuerystring();

}

}

var u1177 = document.getElementById('u1177');
gv_vAlignTable['u1177'] = 'center';
var u126 = document.getElementById('u126');

u126.style.cursor = 'pointer';
if (bIE) u126.attachEvent("onclick", Clicku126);
else u126.addEventListener("click", Clicku126, true);
function Clicku126(e)
{

if (true) {

	self.location.href="B2B出库管理.html" + GetQuerystring();

}

}

var u1174 = document.getElementById('u1174');

var u744 = document.getElementById('u744');

var u250 = document.getElementById('u250');

var u596 = document.getElementById('u596');

var u979 = document.getElementById('u979');
gv_vAlignTable['u979'] = 'center';
var u964 = document.getElementById('u964');

var u1179 = document.getElementById('u1179');
gv_vAlignTable['u1179'] = 'top';
var u1178 = document.getElementById('u1178');

var u160 = document.getElementById('u160');

u160.style.cursor = 'pointer';
if (bIE) u160.attachEvent("onclick", Clicku160);
else u160.addEventListener("click", Clicku160, true);
function Clicku160(e)
{

if (true) {

	self.location.href="总账管理.html" + GetQuerystring();

}

}

var u236 = document.getElementById('u236');

u236.style.cursor = 'pointer';
if (bIE) u236.attachEvent("onclick", Clicku236);
else u236.addEventListener("click", Clicku236, true);
function Clicku236(e)
{

if (true) {

	self.location.href="合同类别管理.html" + "";

}

}

var u1197 = document.getElementById('u1197');
gv_vAlignTable['u1197'] = 'center';
var u1196 = document.getElementById('u1196');

u1196.style.cursor = 'pointer';
if (bIE) u1196.attachEvent("onclick", Clicku1196);
else u1196.addEventListener("click", Clicku1196, true);
function Clicku1196(e)
{

if (true) {

	self.location.href="05其他入库单退回待入库查看.html" + GetQuerystring();

}

}

var u1195 = document.getElementById('u1195');
gv_vAlignTable['u1195'] = 'center';
var u110 = document.getElementById('u110');

u110.style.cursor = 'pointer';
if (bIE) u110.attachEvent("onclick", Clicku110);
else u110.addEventListener("click", Clicku110, true);
function Clicku110(e)
{

if (true) {

	self.location.href="B2B返利审核管理.html" + GetQuerystring();

}

}

var u493 = document.getElementById('u493');
gv_vAlignTable['u493'] = 'center';
var u1192 = document.getElementById('u1192');

u1192.style.cursor = 'pointer';
if (bIE) u1192.attachEvent("onclick", Clicku1192);
else u1192.addEventListener("click", Clicku1192, true);
function Clicku1192(e)
{

if (true) {

	self.location.href="03其他入库单入库查看.html" + GetQuerystring();

}

}

var u417 = document.getElementById('u417');
gv_vAlignTable['u417'] = 'center';
var u917 = document.getElementById('u917');
gv_vAlignTable['u917'] = 'center';
var u305 = document.getElementById('u305');
gv_vAlignTable['u305'] = 'top';
var u277 = document.getElementById('u277');
gv_vAlignTable['u277'] = 'top';
var u1199 = document.getElementById('u1199');
gv_vAlignTable['u1199'] = 'center';
var u1198 = document.getElementById('u1198');

u1198.style.cursor = 'pointer';
if (bIE) u1198.attachEvent("onclick", Clicku1198);
else u1198.addEventListener("click", Clicku1198, true);
function Clicku1198(e)
{

if (true) {

	self.location.href="04其他入库单入库完毕查看.html" + GetQuerystring();

}

}

var u151 = document.getElementById('u151');
gv_vAlignTable['u151'] = 'top';
var u327 = document.getElementById('u327');

var u827 = document.getElementById('u827');
gv_vAlignTable['u827'] = 'center';
var u637 = document.getElementById('u637');
gv_vAlignTable['u637'] = 'center';
var u1217 = document.getElementById('u1217');

u1217.style.cursor = 'pointer';
if (bIE) u1217.attachEvent("onclick", Clicku1217);
else u1217.addEventListener("click", Clicku1217, true);
function Clicku1217(e)
{

if (true) {

	self.location.href="03其他入库单入库查看.html" + GetQuerystring();

}

}

var u346 = document.getElementById('u346');

u346.style.cursor = 'pointer';
if (bIE) u346.attachEvent("onclick", Clicku346);
else u346.addEventListener("click", Clicku346, true);
function Clicku346(e)
{

if (true) {

	self.location.href="还机入库.html" + GetQuerystring();

}

}

var u1215 = document.getElementById('u1215');

u1215.style.cursor = 'pointer';
if (bIE) u1215.attachEvent("onclick", Clicku1215);
else u1215.addEventListener("click", Clicku1215, true);
function Clicku1215(e)
{

if (true) {

	self.location.href="04其他入库单入库完毕查看.html" + GetQuerystring();

}

}

var u785 = document.getElementById('u785');

u785.style.cursor = 'pointer';
if (bIE) u785.attachEvent("onclick", Clicku785);
else u785.addEventListener("click", Clicku785, true);
function Clicku785(e)
{

if (true) {

	self.location.href="02其他入库订单已入库查看.html" + GetQuerystring();

}

}

var u940 = document.getElementById('u940');

var u1212 = document.getElementById('u1212');
gv_vAlignTable['u1212'] = 'center';
var u291 = document.getElementById('u291');
gv_vAlignTable['u291'] = 'top';
var u1210 = document.getElementById('u1210');
gv_vAlignTable['u1210'] = 'center';
var u547 = document.getElementById('u547');
gv_vAlignTable['u547'] = 'center';
var u1219 = document.getElementById('u1219');

u1219.style.cursor = 'pointer';
if (bIE) u1219.attachEvent("onclick", Clicku1219);
else u1219.addEventListener("click", Clicku1219, true);
function Clicku1219(e)
{

if (true) {

	self.location.href="04其他入库单入库完毕查看.html" + GetQuerystring();

}

}

var u695 = document.getElementById('u695');
gv_vAlignTable['u695'] = 'center';
var u873 = document.getElementById('u873');
gv_vAlignTable['u873'] = 'center';
var u457 = document.getElementById('u457');
gv_vAlignTable['u457'] = 'center';
var u957 = document.getElementById('u957');
gv_vAlignTable['u957'] = 'center';
var u767 = document.getElementById('u767');

u767.style.cursor = 'pointer';
if (bIE) u767.attachEvent("onclick", Clicku767);
else u767.addEventListener("click", Clicku767, true);
function Clicku767(e)
{

if (true) {

	self.location.href="02其他入库订单已入库查看.html" + GetQuerystring();

}

}

var u606 = document.getElementById('u606');

var u112 = document.getElementById('u112');

u112.style.cursor = 'pointer';
if (bIE) u112.attachEvent("onclick", Clicku112);
else u112.addEventListener("click", Clicku112, true);
function Clicku112(e)
{

if (true) {

	self.location.href="B2B价保管理.html" + GetQuerystring();

}

}

var u1046 = document.getElementById('u1046');

var u1045 = document.getElementById('u1045');
gv_vAlignTable['u1045'] = 'center';
var u1044 = document.getElementById('u1044');

var u1043 = document.getElementById('u1043');
gv_vAlignTable['u1043'] = 'center';
var u1042 = document.getElementById('u1042');

var u1041 = document.getElementById('u1041');
gv_vAlignTable['u1041'] = 'center';
var u1040 = document.getElementById('u1040');

var u677 = document.getElementById('u677');
gv_vAlignTable['u677'] = 'center';
var u516 = document.getElementById('u516');

var u1049 = document.getElementById('u1049');
gv_vAlignTable['u1049'] = 'center';
var u1048 = document.getElementById('u1048');

var u1286 = document.getElementById('u1286');

var u1285 = document.getElementById('u1285');
gv_vAlignTable['u1285'] = 'center';
var u1284 = document.getElementById('u1284');

var u1277 = document.getElementById('u1277');

var u1276 = document.getElementById('u1276');

u1276.style.cursor = 'pointer';
if (bIE) u1276.attachEvent("onclick", Clicku1276);
else u1276.addEventListener("click", Clicku1276, true);
function Clicku1276(e)
{

if (true) {

	self.location.href="移库管理_1.html" + GetQuerystring();

}

}

var u136 = document.getElementById('u136');

u136.style.cursor = 'pointer';
if (bIE) u136.attachEvent("onclick", Clicku136);
else u136.addEventListener("click", Clicku136, true);
function Clicku136(e)
{

if (true) {

	self.location.href="订单退款管理.html" + GetQuerystring();

}

}

var u1274 = document.getElementById('u1274');
gv_vAlignTable['u1274'] = 'center';
var u736 = document.getElementById('u736');
gv_vAlignTable['u736'] = 'top';
var u1272 = document.getElementById('u1272');
gv_vAlignTable['u1272'] = 'center';
var u1289 = document.getElementById('u1289');
gv_vAlignTable['u1289'] = 'center';
var u390 = document.getElementById('u390');

var u890 = document.getElementById('u890');

var u1279 = document.getElementById('u1279');

u1279.style.cursor = 'pointer';
if (bIE) u1279.attachEvent("onclick", Clicku1279);
else u1279.addEventListener("click", Clicku1279, true);
function Clicku1279(e)
{

if (true) {

	self.location.href="移库审核.html" + GetQuerystring();

}

}

var u646 = document.getElementById('u646');

var u760 = document.getElementById('u760');
gv_vAlignTable['u760'] = 'center';
var u794 = document.getElementById('u794');

var u556 = document.getElementById('u556');

var u705 = document.getElementById('u705');
gv_vAlignTable['u705'] = 'center';
var u782 = document.getElementById('u782');
gv_vAlignTable['u782'] = 'center';
var u211 = document.getElementById('u211');

var u776 = document.getElementById('u776');
gv_vAlignTable['u776'] = 'center';
var u615 = document.getElementById('u615');
gv_vAlignTable['u615'] = 'center';
var u1118 = document.getElementById('u1118');

var u121 = document.getElementById('u121');
gv_vAlignTable['u121'] = 'top';
var u1136 = document.getElementById('u1136');

var u1135 = document.getElementById('u1135');
gv_vAlignTable['u1135'] = 'center';
var u1134 = document.getElementById('u1134');

var u1133 = document.getElementById('u1133');
gv_vAlignTable['u1133'] = 'center';
var u1132 = document.getElementById('u1132');

var u1131 = document.getElementById('u1131');
gv_vAlignTable['u1131'] = 'top';
var u1130 = document.getElementById('u1130');

var u1183 = document.getElementById('u1183');

var u643 = document.getElementById('u643');
gv_vAlignTable['u643'] = 'center';
var u341 = document.getElementById('u341');
gv_vAlignTable['u341'] = 'top';
var u687 = document.getElementById('u687');
gv_vAlignTable['u687'] = 'center';
var u745 = document.getElementById('u745');

u745.style.cursor = 'pointer';
if (bIE) u745.attachEvent("onclick", Clicku745);
else u745.addEventListener("click", Clicku745, true);
function Clicku745(e)
{

if (true) {

	self.location.href="01其他入库订单待入库查看.html" + GetQuerystring();

}

}

var u251 = document.getElementById('u251');
gv_vAlignTable['u251'] = 'top';
var u597 = document.getElementById('u597');
gv_vAlignTable['u597'] = 'top';
var u400 = document.getElementById('u400');

var u900 = document.getElementById('u900');

var u655 = document.getElementById('u655');
gv_vAlignTable['u655'] = 'center';
var u161 = document.getElementById('u161');
gv_vAlignTable['u161'] = 'top';
var u919 = document.getElementById('u919');
gv_vAlignTable['u919'] = 'center';
var u310 = document.getElementById('u310');

u310.style.cursor = 'pointer';
if (bIE) u310.attachEvent("onclick", Clicku310);
else u310.addEventListener("click", Clicku310, true);
function Clicku310(e)
{

if (true) {

	self.location.href="库存盘点_1.html" + GetQuerystring();

}

}

var u810 = document.getElementById('u810');

var u72 = document.getElementById('u72');

var u660 = document.getElementById('u660');

var u714 = document.getElementById('u714');

var u220 = document.getElementById('u220');

u220.style.cursor = 'pointer';
if (bIE) u220.attachEvent("onclick", Clicku220);
else u220.addEventListener("click", Clicku220, true);
function Clicku220(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1167 = document.getElementById('u1167');
gv_vAlignTable['u1167'] = 'center';
var u130 = document.getElementById('u130');

u130.style.cursor = 'pointer';
if (bIE) u130.attachEvent("onclick", Clicku130);
else u130.addEventListener("click", Clicku130, true);
function Clicku130(e)
{

if (true) {

	self.location.href="充值订单管理.html" + GetQuerystring();

}

}

var u1226 = document.getElementById('u1226');
gv_vAlignTable['u1226'] = 'center';
var u440 = document.getElementById('u440');

var u786 = document.getElementById('u786');
gv_vAlignTable['u786'] = 'center';
var u952 = document.getElementById('u952');

var u258 = document.getElementById('u258');

u258.style.cursor = 'pointer';
if (bIE) u258.attachEvent("onclick", Clicku258);
else u258.addEventListener("click", Clicku258, true);
function Clicku258(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1221 = document.getElementById('u1221');

u1221.style.cursor = 'pointer';
if (bIE) u1221.attachEvent("onclick", Clicku1221);
else u1221.addEventListener("click", Clicku1221, true);
function Clicku1221(e)
{

if (true) {

	self.location.href="05其他入库单退回待入库查看.html" + GetQuerystring();

}

}

var u1220 = document.getElementById('u1220');
gv_vAlignTable['u1220'] = 'center';
var u1169 = document.getElementById('u1169');
gv_vAlignTable['u1169'] = 'center';
var u1168 = document.getElementById('u1168');

var u1216 = document.getElementById('u1216');
gv_vAlignTable['u1216'] = 'center';
var u350 = document.getElementById('u350');
gv_vAlignTable['u350'] = 'top';
var u696 = document.getElementById('u696');

var u1213 = document.getElementById('u1213');

u1213.style.cursor = 'pointer';
if (bIE) u1213.attachEvent("onclick", Clicku1213);
else u1213.addEventListener("click", Clicku1213, true);
function Clicku1213(e)
{

if (true) {

	self.location.href="05其他入库单退回待入库查看.html" + GetQuerystring();

}

}

var u792 = document.getElementById('u792');

var u1211 = document.getElementById('u1211');

u1211.style.cursor = 'pointer';
if (bIE) u1211.attachEvent("onclick", Clicku1211);
else u1211.addEventListener("click", Clicku1211, true);
function Clicku1211(e)
{

if (true) {

	self.location.href="04其他入库单入库完毕查看.html" + GetQuerystring();

}

}

var u607 = document.getElementById('u607');
gv_vAlignTable['u607'] = 'center';
var u1218 = document.getElementById('u1218');
gv_vAlignTable['u1218'] = 'center';
var u113 = document.getElementById('u113');
gv_vAlignTable['u113'] = 'top';
var u170 = document.getElementById('u170');

var u1297 = document.getElementById('u1297');

var u1296 = document.getElementById('u1296');
gv_vAlignTable['u1296'] = 'center';
var u1295 = document.getElementById('u1295');

var u1294 = document.getElementById('u1294');
gv_vAlignTable['u1294'] = 'center';
var u1293 = document.getElementById('u1293');

var u1292 = document.getElementById('u1292');
gv_vAlignTable['u1292'] = 'center';
var u427 = document.getElementById('u427');
gv_vAlignTable['u427'] = 'center';
var u927 = document.getElementById('u927');
gv_vAlignTable['u927'] = 'center';
var u737 = document.getElementById('u737');

var u1299 = document.getElementById('u1299');

var u187 = document.getElementById('u187');
gv_vAlignTable['u187'] = 'top';
var u891 = document.getElementById('u891');
gv_vAlignTable['u891'] = 'top';
var u647 = document.getElementById('u647');
gv_vAlignTable['u647'] = 'center';
var u1055 = document.getElementById('u1055');
gv_vAlignTable['u1055'] = 'center';
var u1067 = document.getElementById('u1067');
gv_vAlignTable['u1067'] = 'center';
var u153 = document.getElementById('u153');
gv_vAlignTable['u153'] = 'top';
var u795 = document.getElementById('u795');

var u1064 = document.getElementById('u1064');

var u1063 = document.getElementById('u1063');
gv_vAlignTable['u1063'] = 'center';
var u1062 = document.getElementById('u1062');

var u366 = document.getElementById('u366');
gv_vAlignTable['u366'] = 'center';
var u557 = document.getElementById('u557');
gv_vAlignTable['u557'] = 'center';
var u706 = document.getElementById('u706');

var u1069 = document.getElementById('u1069');
gv_vAlignTable['u1069'] = 'center';
var u1068 = document.getElementById('u1068');

var u212 = document.getElementById('u212');

u212.style.cursor = 'pointer';
if (bIE) u212.attachEvent("onclick", Clicku212);
else u212.addEventListener("click", Clicku212, true);
function Clicku212(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u761 = document.getElementById('u761');

u761.style.cursor = 'pointer';
if (bIE) u761.attachEvent("onclick", Clicku761);
else u761.addEventListener("click", Clicku761, true);
function Clicku761(e)
{

if (true) {

	self.location.href="02其他入库订单已入库查看.html" + GetQuerystring();

}

}

var u777 = document.getElementById('u777');

u777.style.cursor = 'pointer';
if (bIE) u777.attachEvent("onclick", Clicku777);
else u777.addEventListener("click", Clicku777, true);
function Clicku777(e)
{

if (true) {

	self.location.href="01其他入库订单待入库查看.html" + GetQuerystring();

}

}

var u616 = document.getElementById('u616');

var u122 = document.getElementById('u122');

u122.style.cursor = 'pointer';
if (bIE) u122.attachEvent("onclick", Clicku122);
else u122.addEventListener("click", Clicku122, true);
function Clicku122(e)
{

if (true) {

	self.location.href="B2B订单管理.html" + GetQuerystring();

}

}

var u1146 = document.getElementById('u1146');

var u1145 = document.getElementById('u1145');
gv_vAlignTable['u1145'] = 'center';
var u476 = document.getElementById('u476');

var u1143 = document.getElementById('u1143');
gv_vAlignTable['u1143'] = 'center';
var u962 = document.getElementById('u962');

var u1141 = document.getElementById('u1141');
gv_vAlignTable['u1141'] = 'center';
var u1140 = document.getElementById('u1140');

var u545 = document.getElementById('u545');
gv_vAlignTable['u545'] = 'center';
var u1149 = document.getElementById('u1149');
gv_vAlignTable['u1149'] = 'center';
var u1148 = document.getElementById('u1148');

var u180 = document.getElementById('u180');

u180.style.cursor = 'pointer';
if (bIE) u180.attachEvent("onclick", Clicku180);
else u180.addEventListener("click", Clicku180, true);
function Clicku180(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u490 = document.getElementById('u490');

var u990 = document.getElementById('u990');

var u746 = document.getElementById('u746');
gv_vAlignTable['u746'] = 'center';
var u252 = document.getElementById('u252');

var u460 = document.getElementById('u460');

var u656 = document.getElementById('u656');

var u629 = document.getElementById('u629');
gv_vAlignTable['u629'] = 'center';
var u225 = document.getElementById('u225');
gv_vAlignTable['u225'] = 'top';
var u311 = document.getElementById('u311');
gv_vAlignTable['u311'] = 'top';
var u811 = document.getElementById('u811');
gv_vAlignTable['u811'] = 'top';
var u129 = document.getElementById('u129');

var u906 = document.getElementById('u906');

var u893 = document.getElementById('u893');
gv_vAlignTable['u893'] = 'center';
var u715 = document.getElementById('u715');
gv_vAlignTable['u715'] = 'center';
var u221 = document.getElementById('u221');
gv_vAlignTable['u221'] = 'top';
var u140 = document.getElementById('u140');

u140.style.cursor = 'pointer';
if (bIE) u140.attachEvent("onclick", Clicku140);
else u140.addEventListener("click", Clicku140, true);
function Clicku140(e)
{

if (true) {

	self.location.href="佣金结算管理.html" + GetQuerystring();

}

}

var u1313 = document.getElementById('u1313');

var u335 = document.getElementById('u335');
gv_vAlignTable['u335'] = 'top';
var u131 = document.getElementById('u131');
gv_vAlignTable['u131'] = 'top';
var u879 = document.getElementById('u879');
gv_vAlignTable['u879'] = 'center';
var u441 = document.getElementById('u441');
gv_vAlignTable['u441'] = 'center';
var u787 = document.getElementById('u787');

var u1233 = document.getElementById('u1233');

var u1232 = document.getElementById('u1232');
gv_vAlignTable['u1232'] = 'center';
var u1231 = document.getElementById('u1231');

var u1230 = document.getElementById('u1230');
gv_vAlignTable['u1230'] = 'center';
var u376 = document.getElementById('u376');

var u862 = document.getElementById('u862');

var u351 = document.getElementById('u351');
gv_vAlignTable['u351'] = 'top';
var u697 = document.getElementById('u697');
gv_vAlignTable['u697'] = 'center';
var u500 = document.getElementById('u500');

var u755 = document.getElementById('u755');

u755.style.cursor = 'pointer';
if (bIE) u755.attachEvent("onclick", Clicku755);
else u755.addEventListener("click", Clicku755, true);
function Clicku755(e)
{

if (true) {

	self.location.href="02其他入库订单已入库查看.html" + GetQuerystring();

}

}

var u261 = document.getElementById('u261');
gv_vAlignTable['u261'] = 'top';
var u1214 = document.getElementById('u1214');
gv_vAlignTable['u1214'] = 'center';
var u410 = document.getElementById('u410');

var u910 = document.getElementById('u910');

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u869 = document.getElementById('u869');
gv_vAlignTable['u869'] = 'center';
var u360 = document.getElementById('u360');

var u171 = document.getElementById('u171');
gv_vAlignTable['u171'] = 'top';
var u320 = document.getElementById('u320');

u320.style.cursor = 'pointer';
if (bIE) u320.attachEvent("onclick", Clicku320);
else u320.addEventListener("click", Clicku320, true);
function Clicku320(e)
{

if (true) {

	self.location.href="售后出库.html" + GetQuerystring();

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

	self.location.href="订单退款审核.html" + GetQuerystring();

}

}

var u1166 = document.getElementById('u1166');

var u125 = document.getElementById('u125');
gv_vAlignTable['u125'] = 'top';
var u1164 = document.getElementById('u1164');

var u230 = document.getElementById('u230');

u230.style.cursor = 'pointer';
if (bIE) u230.attachEvent("onclick", Clicku230);
else u230.addEventListener("click", Clicku230, true);
function Clicku230(e)
{

if (true) {

	self.location.href="角色管理.html" + "";

}

}

var u540 = document.getElementById('u540');

var u358 = document.getElementById('u358');

var u166 = document.getElementById('u166');

var u470 = document.getElementById('u470');

var u16 = document.getElementById('u16');

var u450 = document.getElementById('u450');

var u796 = document.getElementById('u796');

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

var u1007 = document.getElementById('u1007');
gv_vAlignTable['u1007'] = 'center';
var u492 = document.getElementById('u492');

var u708 = document.getElementById('u708');

var u1001 = document.getElementById('u1001');
gv_vAlignTable['u1001'] = 'center';
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

	self.location.href="#" + GetQuerystring();

}

}

var u617 = document.getElementById('u617');
gv_vAlignTable['u617'] = 'center';
var u123 = document.getElementById('u123');
gv_vAlignTable['u123'] = 'top';
var u1156 = document.getElementById('u1156');

var u1155 = document.getElementById('u1155');
gv_vAlignTable['u1155'] = 'top';
var u1154 = document.getElementById('u1154');

var u1153 = document.getElementById('u1153');
gv_vAlignTable['u1153'] = 'center';
var u1152 = document.getElementById('u1152');

var u1151 = document.getElementById('u1151');
gv_vAlignTable['u1151'] = 'center';
var u1150 = document.getElementById('u1150');

var u527 = document.getElementById('u527');
gv_vAlignTable['u527'] = 'center';
var u872 = document.getElementById('u872');

var u1159 = document.getElementById('u1159');
gv_vAlignTable['u1159'] = 'center';
var u1158 = document.getElementById('u1158');

var u260 = document.getElementById('u260');

u260.style.cursor = 'pointer';
if (bIE) u260.attachEvent("onclick", Clicku260);
else u260.addEventListener("click", Clicku260, true);
function Clicku260(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u491 = document.getElementById('u491');
gv_vAlignTable['u491'] = 'center';
var u991 = document.getElementById('u991');
gv_vAlignTable['u991'] = 'center';
var u747 = document.getElementById('u747');

u747.style.cursor = 'pointer';
if (bIE) u747.attachEvent("onclick", Clicku747);
else u747.addEventListener("click", Clicku747, true);
function Clicku747(e)
{

if (true) {

	self.location.href="02其他入库订单已入库查看.html" + GetQuerystring();

}

}

var u253 = document.getElementById('u253');
gv_vAlignTable['u253'] = 'top';
var u657 = document.getElementById('u657');
gv_vAlignTable['u657'] = 'center';
var u163 = document.getElementById('u163');
gv_vAlignTable['u163'] = 'top';
var u312 = document.getElementById('u312');

var u812 = document.getElementById('u812');

var u848 = document.getElementById('u848');

var u1267 = document.getElementById('u1267');
gv_vAlignTable['u1267'] = 'center';
var u1266 = document.getElementById('u1266');

var u135 = document.getElementById('u135');
gv_vAlignTable['u135'] = 'top';
var u1264 = document.getElementById('u1264');
gv_vAlignTable['u1264'] = 'center';
var u1263 = document.getElementById('u1263');

var u716 = document.getElementById('u716');

var u222 = document.getElementById('u222');

u222.style.cursor = 'pointer';
if (bIE) u222.attachEvent("onclick", Clicku222);
else u222.addEventListener("click", Clicku222, true);
function Clicku222(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1202 = document.getElementById('u1202');

var u188 = document.getElementById('u188');

u188.style.cursor = 'pointer';
if (bIE) u188.attachEvent("onclick", Clicku188);
else u188.addEventListener("click", Clicku188, true);
function Clicku188(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1268 = document.getElementById('u1268');

u1268.style.cursor = 'pointer';
if (bIE) u1268.attachEvent("onclick", Clicku1268);
else u1268.addEventListener("click", Clicku1268, true);
function Clicku1268(e)
{

if (true) {

	self.location.href="其他出库[如活动赠品].html" + GetQuerystring();

}

}

var u132 = document.getElementById('u132');

u132.style.cursor = 'pointer';
if (bIE) u132.attachEvent("onclick", Clicku132);
else u132.addEventListener("click", Clicku132, true);
function Clicku132(e)
{

if (true) {

	self.location.href="手工充值管理.html" + GetQuerystring();

}

}

var u941 = document.getElementById('u941');
gv_vAlignTable['u941'] = 'center';
var u1245 = document.getElementById('u1245');

u1245.style.cursor = 'pointer';
if (bIE) u1245.attachEvent("onclick", Clicku1245);
else u1245.addEventListener("click", Clicku1245, true);
function Clicku1245(e)
{

if (true) {

	self.location.href="还机入库.html" + GetQuerystring();

}

}

var u857 = document.getElementById('u857');
gv_vAlignTable['u857'] = 'center';
var u280 = document.getElementById('u280');

u280.style.cursor = 'pointer';
if (bIE) u280.attachEvent("onclick", Clicku280);
else u280.addEventListener("click", Clicku280, true);
function Clicku280(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u1242 = document.getElementById('u1242');

u1242.style.cursor = 'pointer';
if (bIE) u1242.attachEvent("onclick", Clicku1242);
else u1242.addEventListener("click", Clicku1242, true);
function Clicku1242(e)
{

if (true) {

	self.location.href="售后入库.html" + GetQuerystring();

}

}

var u590 = document.getElementById('u590');

var u1240 = document.getElementById('u1240');

var u1103 = document.getElementById('u1103');
gv_vAlignTable['u1103'] = 'center';
var u781 = document.getElementById('u781');

var u352 = document.getElementById('u352');

var u852 = document.getElementById('u852');

var u756 = document.getElementById('u756');
gv_vAlignTable['u756'] = 'center';
var u1108 = document.getElementById('u1108');

var u262 = document.getElementById('u262');

u262.style.cursor = 'pointer';
if (bIE) u262.attachEvent("onclick", Clicku262);
else u262.addEventListener("click", Clicku262, true);
function Clicku262(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u101 = document.getElementById('u101');
gv_vAlignTable['u101'] = 'top';
var u411 = document.getElementById('u411');
gv_vAlignTable['u411'] = 'center';
var u911 = document.getElementById('u911');
gv_vAlignTable['u911'] = 'center';
var u229 = document.getElementById('u229');
gv_vAlignTable['u229'] = 'top';
var u172 = document.getElementById('u172');

var u703 = document.getElementById('u703');
gv_vAlignTable['u703'] = 'center';
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
var u541 = document.getElementById('u541');
gv_vAlignTable['u541'] = 'center';
var u1247 = document.getElementById('u1247');
gv_vAlignTable['u1247'] = 'center';
var u451 = document.getElementById('u451');
gv_vAlignTable['u451'] = 'center';
var u797 = document.getElementById('u797');
gv_vAlignTable['u797'] = 'top';
var u600 = document.getElementById('u600');

var u108 = document.getElementById('u108');

u108.style.cursor = 'pointer';
if (bIE) u108.attachEvent("onclick", Clicku108);
else u108.addEventListener("click", Clicku108, true);
function Clicku108(e)
{

if (true) {

	self.location.href="B2B返利管理.html" + GetQuerystring();

}

}

var u841 = document.getElementById('u841');
gv_vAlignTable['u841'] = 'center';
var u361 = document.getElementById('u361');
gv_vAlignTable['u361'] = 'center';
var u424 = document.getElementById('u424');

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
gv_vAlignTable['u671'] = 'center';
var u271 = document.getElementById('u271');
gv_vAlignTable['u271'] = 'top';
var u124 = document.getElementById('u124');

u124.style.cursor = 'pointer';
if (bIE) u124.attachEvent("onclick", Clicku124);
else u124.addEventListener("click", Clicku124, true);
function Clicku124(e)
{

if (true) {

	self.location.href="B2B订单审批管理.html" + GetQuerystring();

}

}

var u920 = document.getElementById('u920');

var u1165 = document.getElementById('u1165');
gv_vAlignTable['u1165'] = 'center';
var u238 = document.getElementById('u238');

u238.style.cursor = 'pointer';
if (bIE) u238.attachEvent("onclick", Clicku238);
else u238.addEventListener("click", Clicku238, true);
function Clicku238(e)
{

if (true) {

	self.location.href="合同文件管理.html" + "";

}

}

var u1163 = document.getElementById('u1163');
gv_vAlignTable['u1163'] = 'center';
var u1162 = document.getElementById('u1162');

var u1161 = document.getElementById('u1161');
gv_vAlignTable['u1161'] = 'center';
var u1160 = document.getElementById('u1160');

var u330 = document.getElementById('u330');

u330.style.cursor = 'pointer';
if (bIE) u330.attachEvent("onclick", Clicku330);
else u330.addEventListener("click", Clicku330, true);
function Clicku330(e)
{

if (true) {

	self.location.href="出库单审核.html" + GetQuerystring();

}

}

var u830 = document.getElementById('u830');

var u640 = document.getElementById('u640');

var u148 = document.getElementById('u148');

u148.style.cursor = 'pointer';
if (bIE) u148.attachEvent("onclick", Clicku148);
else u148.addEventListener("click", Clicku148, true);
function Clicku148(e)
{

if (true) {

	self.location.href="发货单管理.html" + GetQuerystring();

}

}

var u182 = document.getElementById('u182');

u182.style.cursor = 'pointer';
if (bIE) u182.attachEvent("onclick", Clicku182);
else u182.addEventListener("click", Clicku182, true);
function Clicku182(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u458 = document.getElementById('u458');

var u603 = document.getElementById('u603');
gv_vAlignTable['u603'] = 'center';
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

var u1208 = document.getElementById('u1208');

var u550 = document.getElementById('u550');

var u368 = document.getElementById('u368');
gv_vAlignTable['u368'] = 'center';
var u868 = document.getElementById('u868');

var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u164 = document.getElementById('u164');

u164.style.cursor = 'pointer';
if (bIE) u164.attachEvent("onclick", Clicku164);
else u164.addEventListener("click", Clicku164, true);
function Clicku164(e)
{

if (true) {

	self.location.href="财务报表管理.html" + GetQuerystring();

}

}

var u960 = document.getElementById('u960');

var u313 = document.getElementById('u313');
gv_vAlignTable['u313'] = 'top';
var u813 = document.getElementById('u813');
gv_vAlignTable['u813'] = 'top';
var u867 = document.getElementById('u867');
gv_vAlignTable['u867'] = 'top';
var u224 = document.getElementById('u224');

u224.style.cursor = 'pointer';
if (bIE) u224.attachEvent("onclick", Clicku224);
else u224.addEventListener("click", Clicku224, true);
function Clicku224(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u717 = document.getElementById('u717');
gv_vAlignTable['u717'] = 'center';
var u870 = document.getElementById('u870');

var u223 = document.getElementById('u223');
gv_vAlignTable['u223'] = 'top';
var u728 = document.getElementById('u728');

var u324 = document.getElementById('u324');

u324.style.cursor = 'pointer';
if (bIE) u324.attachEvent("onclick", Clicku324);
else u324.addEventListener("click", Clicku324, true);
function Clicku324(e)
{

if (true) {

	self.location.href="其他出库[如活动赠品].html" + GetQuerystring();

}

}

var u189 = document.getElementById('u189');
gv_vAlignTable['u189'] = 'top';
var u627 = document.getElementById('u627');
gv_vAlignTable['u627'] = 'center';
var u133 = document.getElementById('u133');
gv_vAlignTable['u133'] = 'top';
var u1054 = document.getElementById('u1054');

var u1255 = document.getElementById('u1255');

var u1254 = document.getElementById('u1254');
gv_vAlignTable['u1254'] = 'center';
var u281 = document.getElementById('u281');
gv_vAlignTable['u281'] = 'top';
var u1050 = document.getElementById('u1050');

var u591 = document.getElementById('u591');
gv_vAlignTable['u591'] = 'center';
var u1250 = document.getElementById('u1250');
gv_vAlignTable['u1250'] = 'center';
var u1283 = document.getElementById('u1283');
gv_vAlignTable['u1283'] = 'center';
var u851 = document.getElementById('u851');
gv_vAlignTable['u851'] = 'center';
var u1059 = document.getElementById('u1059');
gv_vAlignTable['u1059'] = 'top';
var u1058 = document.getElementById('u1058');

var u353 = document.getElementById('u353');
gv_vAlignTable['u353'] = 'center';
var u853 = document.getElementById('u853');
gv_vAlignTable['u853'] = 'center';
var u434 = document.getElementById('u434');

var u713 = document.getElementById('u713');
gv_vAlignTable['u713'] = 'center';
var u387 = document.getElementById('u387');
gv_vAlignTable['u387'] = 'top';
var u951 = document.getElementById('u951');
gv_vAlignTable['u951'] = 'center';
var u757 = document.getElementById('u757');

var u503 = document.getElementById('u503');
gv_vAlignTable['u503'] = 'center';
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

var u1243 = document.getElementById('u1243');

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

	self.location.href="借机出库.html" + GetQuerystring();

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

var u232 = document.getElementById('u232');

u232.style.cursor = 'pointer';
if (bIE) u232.attachEvent("onclick", Clicku232);
else u232.addEventListener("click", Clicku232, true);
function Clicku232(e)
{

if (true) {

	self.location.href="权限管理.html" + "";

}

}

var u380 = document.getElementById('u380');

var u880 = document.getElementById('u880');

var u690 = document.getElementById('u690');

var u198 = document.getElementById('u198');

u198.style.cursor = 'pointer';
if (bIE) u198.attachEvent("onclick", Clicku198);
else u198.addEventListener("click", Clicku198, true);
function Clicku198(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u142 = document.getElementById('u142');

u142.style.cursor = 'pointer';
if (bIE) u142.attachEvent("onclick", Clicku142);
else u142.addEventListener("click", Clicku142, true);
function Clicku142(e)
{

if (true) {

	self.location.href="佣金结算审核.html" + GetQuerystring();

}

}

var u452 = document.getElementById('u452');

var u1147 = document.getElementById('u1147');
gv_vAlignTable['u1147'] = 'center';
var u948 = document.getElementById('u948');

var u109 = document.getElementById('u109');
gv_vAlignTable['u109'] = 'top';
var u877 = document.getElementById('u877');
gv_vAlignTable['u877'] = 'center';
var u560 = document.getElementById('u560');

var u362 = document.getElementById('u362');

var u201 = document.getElementById('u201');
gv_vAlignTable['u201'] = 'top';
var u511 = document.getElementById('u511');
gv_vAlignTable['u511'] = 'center';
var u1305 = document.getElementById('u1305');
gv_vAlignTable['u1305'] = 'center';
var u329 = document.getElementById('u329');
gv_vAlignTable['u329'] = 'top';
var u829 = document.getElementById('u829');
gv_vAlignTable['u829'] = 'center';
var u1302 = document.getElementById('u1302');

var u1300 = document.getElementById('u1300');
gv_vAlignTable['u1300'] = 'center';
var u898 = document.getElementById('u898');

var u272 = document.getElementById('u272');

var u287 = document.getElementById('u287');

var u1291 = document.getElementById('u1291');

var u421 = document.getElementById('u421');
gv_vAlignTable['u421'] = 'top';
var u1176 = document.getElementById('u1176');

var u1175 = document.getElementById('u1175');
gv_vAlignTable['u1175'] = 'center';
var u239 = document.getElementById('u239');
gv_vAlignTable['u239'] = 'top';
var u1173 = document.getElementById('u1173');
gv_vAlignTable['u1173'] = 'center';
var u1172 = document.getElementById('u1172');

var u1171 = document.getElementById('u1171');
gv_vAlignTable['u1171'] = 'center';
var u1170 = document.getElementById('u1170');

var u861 = document.getElementById('u861');
gv_vAlignTable['u861'] = 'center';
var u331 = document.getElementById('u331');
gv_vAlignTable['u331'] = 'top';
var u831 = document.getElementById('u831');
gv_vAlignTable['u831'] = 'center';
var u641 = document.getElementById('u641');
gv_vAlignTable['u641'] = 'top';
var u149 = document.getElementById('u149');
gv_vAlignTable['u149'] = 'top';
var u183 = document.getElementById('u183');
gv_vAlignTable['u183'] = 'top';
var u930 = document.getElementById('u930');

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

var u1137 = document.getElementById('u1137');
gv_vAlignTable['u1137'] = 'center';
var u1282 = document.getElementById('u1282');

var u1281 = document.getElementById('u1281');
gv_vAlignTable['u1281'] = 'center';
var u551 = document.getElementById('u551');
gv_vAlignTable['u551'] = 'center';
var u700 = document.getElementById('u700');

var u208 = document.getElementById('u208');

u208.style.cursor = 'pointer';
if (bIE) u208.attachEvent("onclick", Clicku208);
else u208.addEventListener("click", Clicku208, true);
function Clicku208(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u461 = document.getElementById('u461');
gv_vAlignTable['u461'] = 'center';
var u961 = document.getElementById('u961');
gv_vAlignTable['u961'] = 'center';
var u1138 = document.getElementById('u1138');

var u279 = document.getElementById('u279');
gv_vAlignTable['u279'] = 'top';
var u118 = document.getElementById('u118');

u118.style.cursor = 'pointer';
if (bIE) u118.attachEvent("onclick", Clicku118);
else u118.addEventListener("click", Clicku118, true);
function Clicku118(e)
{

if (true) {

	self.location.href="B2B电子渠道审核管理.html" + GetQuerystring();

}

}

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
var u371 = document.getElementById('u371');

var u871 = document.getElementById('u871');
gv_vAlignTable['u871'] = 'center';
var u520 = document.getElementById('u520');

var u1186 = document.getElementById('u1186');
gv_vAlignTable['u1186'] = 'top';
var u338 = document.getElementById('u338');

var u165 = document.getElementById('u165');
gv_vAlignTable['u165'] = 'top';
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

	self.location.href="成本核算管理.html" + GetQuerystring();

}

}

var u430 = document.getElementById('u430');

var u234 = document.getElementById('u234');

u234.style.cursor = 'pointer';
if (bIE) u234.attachEvent("onclick", Clicku234);
else u234.addEventListener("click", Clicku234, true);
function Clicku234(e)
{

if (true) {

	self.location.href="IP访问限制管理.html" + "";

}

}

var u740 = document.getElementById('u740');
gv_vAlignTable['u740'] = 'center';
var u248 = document.getElementById('u248');

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

var u1261 = document.getElementById('u1261');
gv_vAlignTable['u1261'] = 'center';
var u1260 = document.getElementById('u1260');

var u36 = document.getElementById('u36');

u36.style.cursor = 'pointer';
if (bIE) u36.attachEvent("onclick", Clicku36);
else u36.addEventListener("click", Clicku36, true);
function Clicku36(e)
{

if (true) {

	self.location.href="销售报表查询.html" + GetQuerystring();

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
gv_vAlignTable['u679'] = 'center';
var u650 = document.getElementById('u650');

var u854 = document.getElementById('u854');

var u192 = document.getElementById('u192');

u192.style.cursor = 'pointer';
if (bIE) u192.attachEvent("onclick", Clicku192);
else u192.addEventListener("click", Clicku192, true);
function Clicku192(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u468 = document.getElementById('u468');

var u968 = document.getElementById('u968');

var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'top';
var u264 = document.getElementById('u264');

u264.style.cursor = 'pointer';
if (bIE) u264.attachEvent("onclick", Clicku264);
else u264.addEventListener("click", Clicku264, true);
function Clicku264(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u103 = document.getElementById('u103');
gv_vAlignTable['u103'] = 'top';
var u1081 = document.getElementById('u1081');
gv_vAlignTable['u1081'] = 'center';
var u413 = document.getElementById('u413');
gv_vAlignTable['u413'] = 'center';
var u913 = document.getElementById('u913');
gv_vAlignTable['u913'] = 'center';
var u174 = document.getElementById('u174');

var u970 = document.getElementById('u970');

var u323 = document.getElementById('u323');
gv_vAlignTable['u323'] = 'top';
var u823 = document.getElementById('u823');
gv_vAlignTable['u823'] = 'center';
var u1015 = document.getElementById('u1015');
gv_vAlignTable['u1015'] = 'center';
if (window.OnLoad) OnLoad();
