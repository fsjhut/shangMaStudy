
var PageName = '01佣金结算查看';
var PageId = 'pd56442f7823d40f582ae4edb8b0649fa'
var PageUrl = '01佣金结算查看.html'
document.title = '01佣金结算查看';

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

var u33 = document.getElementById('u33');

var u402 = document.getElementById('u402');

var u65 = document.getElementById('u65');
gv_vAlignTable['u65'] = 'top';
var u545 = document.getElementById('u545');

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

var u372 = document.getElementById('u372');

u372.style.cursor = 'pointer';
if (bIE) u372.attachEvent("onclick", Clicku372);
else u372.addEventListener("click", Clicku372, true);
function Clicku372(e)
{

if (true) {

	self.location.href="充值订单管理.html" + GetQuerystring();

}

}

var u126 = document.getElementById('u126');

u126.style.cursor = 'pointer';
if (bIE) u126.attachEvent("onclick", Clicku126);
else u126.addEventListener("click", Clicku126, true);
function Clicku126(e)
{

if (true) {

	self.location.href="B2B订单审批管理.html" + GetQuerystring();

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

var u420 = document.getElementById('u420');

var u181 = document.getElementById('u181');
gv_vAlignTable['u181'] = 'top';
var u157 = document.getElementById('u157');

var u129 = document.getElementById('u129');
gv_vAlignTable['u129'] = 'top';
var u590 = document.getElementById('u590');
gv_vAlignTable['u590'] = 'center';
var u417 = document.getElementById('u417');
gv_vAlignTable['u417'] = 'top';
var u555 = document.getElementById('u555');

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

var u217 = document.getElementById('u217');
gv_vAlignTable['u217'] = 'top';
var u598 = document.getElementById('u598');
gv_vAlignTable['u598'] = 'center';
var u162 = document.getElementById('u162');

u162.style.cursor = 'pointer';
if (bIE) u162.attachEvent("onclick", Clicku162);
else u162.addEventListener("click", Clicku162, true);
function Clicku162(e)
{

if (true) {

	self.location.href="总账管理.html" + GetQuerystring();

}

}

var u560 = document.getElementById('u560');
gv_vAlignTable['u560'] = 'center';
var u0 = document.getElementById('u0');

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

var u131 = document.getElementById('u131');

var u42 = document.getElementById('u42');

var u564 = document.getElementById('u564');
gv_vAlignTable['u564'] = 'center';
var u506 = document.getElementById('u506');
gv_vAlignTable['u506'] = 'center';
var u644 = document.getElementById('u644');
gv_vAlignTable['u644'] = 'center';
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

var u510 = document.getElementById('u510');
gv_vAlignTable['u510'] = 'center';
var u74 = document.getElementById('u74');

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

var u99 = document.getElementById('u99');
gv_vAlignTable['u99'] = 'top';
var u576 = document.getElementById('u576');
gv_vAlignTable['u576'] = 'center';
var u351 = document.getElementById('u351');
gv_vAlignTable['u351'] = 'top';
var u386 = document.getElementById('u386');
gv_vAlignTable['u386'] = 'center';
var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u277 = document.getElementById('u277');
gv_vAlignTable['u277'] = 'top';
var u247 = document.getElementById('u247');
gv_vAlignTable['u247'] = 'top';
var u68 = document.getElementById('u68');

var u134 = document.getElementById('u134');

u134.style.cursor = 'pointer';
if (bIE) u134.attachEvent("onclick", Clicku134);
else u134.addEventListener("click", Clicku134, true);
function Clicku134(e)
{

if (true) {

	self.location.href="手工充值管理.html" + GetQuerystring();

}

}

var u242 = document.getElementById('u242');

u242.style.cursor = 'pointer';
if (bIE) u242.attachEvent("onclick", Clicku242);
else u242.addEventListener("click", Clicku242, true);
function Clicku242(e)
{

if (true) {

	self.location.href="组织结构管理.html" + "";

}

}

var u323 = document.getElementById('u323');
gv_vAlignTable['u323'] = 'top';
var u518 = document.getElementById('u518');
gv_vAlignTable['u518'] = 'center';
var u391 = document.getElementById('u391');

var u541 = document.getElementById('u541');

var u440 = document.getElementById('u440');
gv_vAlignTable['u440'] = 'top';
var u229 = document.getElementById('u229');

var u559 = document.getElementById('u559');

var u399 = document.getElementById('u399');

var u366 = document.getElementById('u366');
gv_vAlignTable['u366'] = 'top';
var u51 = document.getElementById('u51');
gv_vAlignTable['u51'] = 'top';
var u459 = document.getElementById('u459');

var u331 = document.getElementById('u331');
gv_vAlignTable['u331'] = 'top';
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

var u128 = document.getElementById('u128');

u128.style.cursor = 'pointer';
if (bIE) u128.attachEvent("onclick", Clicku128);
else u128.addEventListener("click", Clicku128, true);
function Clicku128(e)
{

if (true) {

	self.location.href="B2B出库管理.html" + GetQuerystring();

}

}

var u91 = document.getElementById('u91');

var u416 = document.getElementById('u416');
gv_vAlignTable['u416'] = 'top';
var u257 = document.getElementById('u257');
gv_vAlignTable['u257'] = 'top';
var u306 = document.getElementById('u306');

u306.style.cursor = 'pointer';
if (bIE) u306.attachEvent("onclick", Clicku306);
else u306.addEventListener("click", Clicku306, true);
function Clicku306(e)
{

if (true) {

	self.location.href="入库管理.html" + GetQuerystring();

}

}

var u648 = document.getElementById('u648');
gv_vAlignTable['u648'] = 'top';
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

var u358 = document.getElementById('u358');

var u123 = document.getElementById('u123');
gv_vAlignTable['u123'] = 'top';
var u261 = document.getElementById('u261');
gv_vAlignTable['u261'] = 'top';
var u187 = document.getElementById('u187');
gv_vAlignTable['u187'] = 'top';
var u324 = document.getElementById('u324');

u324.style.cursor = 'pointer';
if (bIE) u324.attachEvent("onclick", Clicku324);
else u324.addEventListener("click", Clicku324, true);
function Clicku324(e)
{

if (true) {

	self.location.href="借机出库.html" + GetQuerystring();

}

}

var u481 = document.getElementById('u481');

var u32 = document.getElementById('u32');

var u608 = document.getElementById('u608');
gv_vAlignTable['u608'] = 'center';
var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'top';
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

var u578 = document.getElementById('u578');
gv_vAlignTable['u578'] = 'center';
var u319 = document.getElementById('u319');
gv_vAlignTable['u319'] = 'top';
var u108 = document.getElementById('u108');

u108.style.cursor = 'pointer';
if (bIE) u108.attachEvent("onclick", Clicku108);
else u108.addEventListener("click", Clicku108, true);
function Clicku108(e)
{

if (true) {

	self.location.href="B2B签报管理.html" + GetQuerystring();

}

}

var u350 = document.getElementById('u350');

u350.style.cursor = 'pointer';
if (bIE) u350.attachEvent("onclick", Clicku350);
else u350.addEventListener("click", Clicku350, true);
function Clicku350(e)
{

if (true) {

	self.location.href="其他入库[如活动赠品].html" + GetQuerystring();

}

}

var u489 = document.getElementById('u489');

var u549 = document.getElementById('u549');

var u60 = document.getElementById('u60');

u60.style.cursor = 'pointer';
if (bIE) u60.attachEvent("onclick", Clicku60);
else u60.addEventListener("click", Clicku60, true);
function Clicku60(e)
{

if (true) {

	self.location.href="采购退货计划单管理.html" + GetQuerystring();

}

}

var u59 = document.getElementById('u59');
gv_vAlignTable['u59'] = 'top';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u360 = document.getElementById('u360');

var u103 = document.getElementById('u103');
gv_vAlignTable['u103'] = 'top';
var u529 = document.getElementById('u529');

var u9 = document.getElementById('u9');

var u107 = document.getElementById('u107');

var u368 = document.getElementById('u368');
gv_vAlignTable['u368'] = 'center';
var u401 = document.getElementById('u401');

u401.style.cursor = 'pointer';
if (bIE) u401.attachEvent("onclick", Clicku401);
else u401.addEventListener("click", Clicku401, true);
function Clicku401(e)
{

if (true) {

	self.location.href="佣金结算比例设置.html" + GetQuerystring();

}

}

var u365 = document.getElementById('u365');
gv_vAlignTable['u365'] = 'center';
var u330 = document.getElementById('u330');

u330.style.cursor = 'pointer';
if (bIE) u330.attachEvent("onclick", Clicku330);
else u330.addEventListener("click", Clicku330, true);
function Clicku330(e)
{

if (true) {

	self.location.href="入库单审核.html" + GetQuerystring();

}

}

var u314 = document.getElementById('u314');

var u125 = document.getElementById('u125');
gv_vAlignTable['u125'] = 'top';
var u596 = document.getElementById('u596');
gv_vAlignTable['u596'] = 'center';
var u36 = document.getElementById('u36');

u36.style.cursor = 'pointer';
if (bIE) u36.attachEvent("onclick", Clicku36);
else u36.addEventListener("click", Clicku36, true);
function Clicku36(e)
{

if (true) {

	self.location.href="库存报表查询.html" + GetQuerystring();

}

}

var u295 = document.getElementById('u295');
gv_vAlignTable['u295'] = 'top';
var u415 = document.getElementById('u415');
gv_vAlignTable['u415'] = 'top';
var u256 = document.getElementById('u256');

var u156 = document.getElementById('u156');

var u613 = document.getElementById('u613');

var u454 = document.getElementById('u454');
gv_vAlignTable['u454'] = 'center';
var u647 = document.getElementById('u647');
gv_vAlignTable['u647'] = 'top';
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

var u463 = document.getElementById('u463');

var u505 = document.getElementById('u505');

var u504 = document.getElementById('u504');
gv_vAlignTable['u504'] = 'center';
var u161 = document.getElementById('u161');
gv_vAlignTable['u161'] = 'top';
var u345 = document.getElementById('u345');
gv_vAlignTable['u345'] = 'top';
var u474 = document.getElementById('u474');
gv_vAlignTable['u474'] = 'center';
var u439 = document.getElementById('u439');

var u349 = document.getElementById('u349');
gv_vAlignTable['u349'] = 'top';
var u231 = document.getElementById('u231');
gv_vAlignTable['u231'] = 'top';
var u169 = document.getElementById('u169');

var u215 = document.getElementById('u215');
gv_vAlignTable['u215'] = 'top';
var u137 = document.getElementById('u137');
gv_vAlignTable['u137'] = 'top';
var u283 = document.getElementById('u283');
gv_vAlignTable['u283'] = 'top';
var u572 = document.getElementById('u572');
gv_vAlignTable['u572'] = 'center';
var u476 = document.getElementById('u476');
gv_vAlignTable['u476'] = 'center';
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

var u369 = document.getElementById('u369');

var u85 = document.getElementById('u85');
gv_vAlignTable['u85'] = 'top';
var u77 = document.getElementById('u77');
gv_vAlignTable['u77'] = 'top';
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

var u141 = document.getElementById('u141');
gv_vAlignTable['u141'] = 'top';
var u20 = document.getElementById('u20');

var u226 = document.getElementById('u226');

u226.style.cursor = 'pointer';
if (bIE) u226.attachEvent("onclick", Clicku226);
else u226.addEventListener("click", Clicku226, true);
function Clicku226(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u364 = document.getElementById('u364');

var u553 = document.getElementById('u553');

var u423 = document.getElementById('u423');

var u251 = document.getElementById('u251');

var u595 = document.getElementById('u595');

var u109 = document.getElementById('u109');
gv_vAlignTable['u109'] = 'top';
var u414 = document.getElementById('u414');
gv_vAlignTable['u414'] = 'top';
var u183 = document.getElementById('u183');
gv_vAlignTable['u183'] = 'top';
var u424 = document.getElementById('u424');
gv_vAlignTable['u424'] = 'top';
var u259 = document.getElementById('u259');

var u612 = document.getElementById('u612');
gv_vAlignTable['u612'] = 'center';
var u607 = document.getElementById('u607');

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u39 = document.getElementById('u39');
gv_vAlignTable['u39'] = 'top';
var u425 = document.getElementById('u425');

var u54 = document.getElementById('u54');

u54.style.cursor = 'pointer';
if (bIE) u54.attachEvent("onclick", Clicku54);
else u54.addEventListener("click", Clicku54, true);
function Clicku54(e)
{

if (true) {

	self.location.href="采购单管理.html" + GetQuerystring();

}

}

var u387 = document.getElementById('u387');

u387.style.cursor = 'pointer';
if (bIE) u387.attachEvent("onclick", Clicku387);
else u387.addEventListener("click", Clicku387, true);
function Clicku387(e)
{

if (true) {

	self.location.href="佣金结算管理.html" + GetQuerystring();

}

}

var u344 = document.getElementById('u344');

u344.style.cursor = 'pointer';
if (bIE) u344.attachEvent("onclick", Clicku344);
else u344.addEventListener("click", Clicku344, true);
function Clicku344(e)
{

if (true) {

	self.location.href="销售入库.html" + GetQuerystring();

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

var u336 = document.getElementById('u336');

u336.style.cursor = 'pointer';
if (bIE) u336.attachEvent("onclick", Clicku336);
else u336.addEventListener("click", Clicku336, true);
function Clicku336(e)
{

if (true) {

	self.location.href="移库管理_1.html" + GetQuerystring();

}

}

var u458 = document.getElementById('u458');
gv_vAlignTable['u458'] = 'center';
var u493 = document.getElementById('u493');

var u210 = document.getElementById('u210');

u210.style.cursor = 'pointer';
if (bIE) u210.attachEvent("onclick", Clicku210);
else u210.addEventListener("click", Clicku210, true);
function Clicku210(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u630 = document.getElementById('u630');
gv_vAlignTable['u630'] = 'center';
var u318 = document.getElementById('u318');

u318.style.cursor = 'pointer';
if (bIE) u318.attachEvent("onclick", Clicku318);
else u318.addEventListener("click", Clicku318, true);
function Clicku318(e)
{

if (true) {

	self.location.href="采购退库.html" + GetQuerystring();

}

}

var u191 = document.getElementById('u191');
gv_vAlignTable['u191'] = 'top';
var u136 = document.getElementById('u136');

u136.style.cursor = 'pointer';
if (bIE) u136.attachEvent("onclick", Clicku136);
else u136.addEventListener("click", Clicku136, true);
function Clicku136(e)
{

if (true) {

	self.location.href="手工充值审核.html" + GetQuerystring();

}

}

var u367 = document.getElementById('u367');

var u571 = document.getElementById('u571');

var u101 = document.getElementById('u101');
gv_vAlignTable['u101'] = 'top';
var u488 = document.getElementById('u488');
gv_vAlignTable['u488'] = 'center';
var u638 = document.getElementById('u638');
gv_vAlignTable['u638'] = 'center';
var u199 = document.getElementById('u199');

var u31 = document.getElementById('u31');
gv_vAlignTable['u31'] = 'top';
var u140 = document.getElementById('u140');

u140.style.cursor = 'pointer';
if (bIE) u140.attachEvent("onclick", Clicku140);
else u140.addEventListener("click", Clicku140, true);
function Clicku140(e)
{

if (true) {

	self.location.href="订单退款审核.html" + GetQuerystring();

}

}

var u48 = document.getElementById('u48');

u48.style.cursor = 'pointer';
if (bIE) u48.attachEvent("onclick", Clicku48);
else u48.addEventListener("click", Clicku48, true);
function Clicku48(e)
{

if (true) {

	self.location.href="产品单管理.html" + GetQuerystring();

}

}

var u225 = document.getElementById('u225');
gv_vAlignTable['u225'] = 'top';
var u63 = document.getElementById('u63');
gv_vAlignTable['u63'] = 'top';
var u106 = document.getElementById('u106');

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

var u594 = document.getElementById('u594');
gv_vAlignTable['u594'] = 'center';
var u570 = document.getElementById('u570');
gv_vAlignTable['u570'] = 'center';
var u400 = document.getElementById('u400');
gv_vAlignTable['u400'] = 'center';
var u583 = document.getElementById('u583');

var u111 = document.getElementById('u111');
gv_vAlignTable['u111'] = 'top';
var u611 = document.getElementById('u611');

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

var u408 = document.getElementById('u408');
gv_vAlignTable['u408'] = 'top';
var u120 = document.getElementById('u120');

u120.style.cursor = 'pointer';
if (bIE) u120.attachEvent("onclick", Clicku120);
else u120.addEventListener("click", Clicku120, true);
function Clicku120(e)
{

if (true) {

	self.location.href="B2B电子渠道审核管理.html" + GetQuerystring();

}

}

var u119 = document.getElementById('u119');
gv_vAlignTable['u119'] = 'top';
var u537 = document.getElementById('u537');

var u205 = document.getElementById('u205');
gv_vAlignTable['u205'] = 'top';
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

var u289 = document.getElementById('u289');

var u40 = document.getElementById('u40');

u40.style.cursor = 'pointer';
if (bIE) u40.attachEvent("onclick", Clicku40);
else u40.addEventListener("click", Clicku40, true);
function Clicku40(e)
{

if (true) {

	self.location.href="售后报表查询.html" + GetQuerystring();

}

}

var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'center';
var u390 = document.getElementById('u390');

u390.style.cursor = 'pointer';
if (bIE) u390.attachEvent("onclick", Clicku390);
else u390.addEventListener("click", Clicku390, true);
function Clicku390(e)
{

if (true) {

	self.location.href="佣金结算审核.html" + GetQuerystring();

}

}

var u160 = document.getElementById('u160');

u160.style.cursor = 'pointer';
if (bIE) u160.attachEvent("onclick", Clicku160);
else u160.addEventListener("click", Clicku160, true);
function Clicku160(e)
{

if (true) {

	self.location.href="应收_应付管理.html" + GetQuerystring();

}

}

var u72 = document.getElementById('u72');

var u227 = document.getElementById('u227');
gv_vAlignTable['u227'] = 'top';
var u467 = document.getElementById('u467');

var u135 = document.getElementById('u135');
gv_vAlignTable['u135'] = 'top';
var u281 = document.getElementById('u281');
gv_vAlignTable['u281'] = 'top';
var u574 = document.getElementById('u574');
gv_vAlignTable['u574'] = 'center';
var u503 = document.getElementById('u503');

var u168 = document.getElementById('u168');

var u201 = document.getElementById('u201');
gv_vAlignTable['u201'] = 'top';
var u546 = document.getElementById('u546');
gv_vAlignTable['u546'] = 'center';
var u639 = document.getElementById('u639');

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

var u384 = document.getElementById('u384');

u384.style.cursor = 'pointer';
if (bIE) u384.attachEvent("onclick", Clicku384);
else u384.addEventListener("click", Clicku384, true);
function Clicku384(e)
{

if (true) {

	self.location.href="订单退款审核.html" + GetQuerystring();

}

}

var u521 = document.getElementById('u521');

var u16 = document.getElementById('u16');

u16.style.cursor = 'pointer';
if (bIE) u16.attachEvent("onclick", Clicku16);
else u16.addEventListener("click", Clicku16, true);
function Clicku16(e)
{

if (true) {

}

}

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

var u362 = document.getElementById('u362');

var u232 = document.getElementById('u232');

u232.style.cursor = 'pointer';
if (bIE) u232.attachEvent("onclick", Clicku232);
else u232.addEventListener("click", Clicku232, true);
function Clicku232(e)
{

if (true) {

	self.location.href="角色管理.html" + "";

}

}

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

var u447 = document.getElementById('u447');

var u144 = document.getElementById('u144');

u144.style.cursor = 'pointer';
if (bIE) u144.attachEvent("onclick", Clicku144);
else u144.addEventListener("click", Clicku144, true);
function Clicku144(e)
{

if (true) {

	self.location.href="佣金结算审核.html" + GetQuerystring();

}

}

var u115 = document.getElementById('u115');
gv_vAlignTable['u115'] = 'top';
var u333 = document.getElementById('u333');
gv_vAlignTable['u333'] = 'top';
var u522 = document.getElementById('u522');
gv_vAlignTable['u522'] = 'center';
var u209 = document.getElementById('u209');
gv_vAlignTable['u209'] = 'top';
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

var u313 = document.getElementById('u313');
gv_vAlignTable['u313'] = 'top';
var u154 = document.getElementById('u154');

u154.style.cursor = 'pointer';
if (bIE) u154.attachEvent("onclick", Clicku154);
else u154.addEventListener("click", Clicku154, true);
function Clicku154(e)
{

if (true) {

	self.location.href="物流地域维护管理.html" + GetQuerystring();

}

}

var u451 = document.getElementById('u451');

var u334 = document.getElementById('u334');

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

var u523 = document.getElementById('u523');

var u514 = document.getElementById('u514');
gv_vAlignTable['u514'] = 'center';
var u385 = document.getElementById('u385');

var u606 = document.getElementById('u606');
gv_vAlignTable['u606'] = 'center';
var u258 = document.getElementById('u258');

var u335 = document.getElementById('u335');

var u342 = document.getElementById('u342');

u342.style.cursor = 'pointer';
if (bIE) u342.attachEvent("onclick", Clicku342);
else u342.addEventListener("click", Clicku342, true);
function Clicku342(e)
{

if (true) {

	self.location.href="采购入库.html" + GetQuerystring();

}

}

var u304 = document.getElementById('u304');

var u139 = document.getElementById('u139');
gv_vAlignTable['u139'] = 'top';
var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u487 = document.getElementById('u487');

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

var u525 = document.getElementById('u525');

var u179 = document.getElementById('u179');
gv_vAlignTable['u179'] = 'top';
var u185 = document.getElementById('u185');
gv_vAlignTable['u185'] = 'top';
var u322 = document.getElementById('u322');

u322.style.cursor = 'pointer';
if (bIE) u322.attachEvent("onclick", Clicku322);
else u322.addEventListener("click", Clicku322, true);
function Clicku322(e)
{

if (true) {

	self.location.href="售后出库.html" + GetQuerystring();

}

}

var u57 = document.getElementById('u57');
gv_vAlignTable['u57'] = 'top';
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

var u431 = document.getElementById('u431');

var u526 = document.getElementById('u526');
gv_vAlignTable['u526'] = 'center';
var u228 = document.getElementById('u228');

var u97 = document.getElementById('u97');
gv_vAlignTable['u97'] = 'top';
var u516 = document.getElementById('u516');
gv_vAlignTable['u516'] = 'center';
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

var u353 = document.getElementById('u353');
gv_vAlignTable['u353'] = 'top';
var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'top';
var u198 = document.getElementById('u198');

var u520 = document.getElementById('u520');
gv_vAlignTable['u520'] = 'center';
var u348 = document.getElementById('u348');

u348.style.cursor = 'pointer';
if (bIE) u348.attachEvent("onclick", Clicku348);
else u348.addEventListener("click", Clicku348, true);
function Clicku348(e)
{

if (true) {

	self.location.href="还机入库.html" + GetQuerystring();

}

}

var u253 = document.getElementById('u253');
gv_vAlignTable['u253'] = 'top';
var u407 = document.getElementById('u407');

var u114 = document.getElementById('u114');

u114.style.cursor = 'pointer';
if (bIE) u114.attachEvent("onclick", Clicku114);
else u114.addEventListener("click", Clicku114, true);
function Clicku114(e)
{

if (true) {

	self.location.href="B2B价保管理.html" + GetQuerystring();

}

}

var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u34 = document.getElementById('u34');

u34.style.cursor = 'pointer';
if (bIE) u34.attachEvent("onclick", Clicku34);
else u34.addEventListener("click", Clicku34, true);
function Clicku34(e)
{

if (true) {

	self.location.href="采购报表查询.html" + GetQuerystring();

}

}

var u312 = document.getElementById('u312');

u312.style.cursor = 'pointer';
if (bIE) u312.attachEvent("onclick", Clicku312);
else u312.addEventListener("click", Clicku312, true);
function Clicku312(e)
{

if (true) {

	self.location.href="库存盘点_1.html" + GetQuerystring();

}

}

var u153 = document.getElementById('u153');
gv_vAlignTable['u153'] = 'top';
var u450 = document.getElementById('u450');
gv_vAlignTable['u450'] = 'center';
var u412 = document.getElementById('u412');

var u69 = document.getElementById('u69');
gv_vAlignTable['u69'] = 'top';
var u66 = document.getElementById('u66');

var u582 = document.getElementById('u582');
gv_vAlignTable['u582'] = 'center';
var u110 = document.getElementById('u110');

u110.style.cursor = 'pointer';
if (bIE) u110.attachEvent("onclick", Clicku110);
else u110.addEventListener("click", Clicku110, true);
function Clicku110(e)
{

if (true) {

	self.location.href="B2B返利管理.html" + GetQuerystring();

}

}

var u376 = document.getElementById('u376');

var u293 = document.getElementById('u293');
gv_vAlignTable['u293'] = 'top';
var u443 = document.getElementById('u443');

var u138 = document.getElementById('u138');

u138.style.cursor = 'pointer';
if (bIE) u138.attachEvent("onclick", Clicku138);
else u138.addEventListener("click", Clicku138, true);
function Clicku138(e)
{

if (true) {

	self.location.href="订单退款管理.html" + GetQuerystring();

}

}

var u118 = document.getElementById('u118');

u118.style.cursor = 'pointer';
if (bIE) u118.attachEvent("onclick", Clicku118);
else u118.addEventListener("click", Clicku118, true);
function Clicku118(e)
{

if (true) {

	self.location.href="B2B电子渠道库存管理.html" + GetQuerystring();

}

}

var u167 = document.getElementById('u167');
gv_vAlignTable['u167'] = 'top';
var u288 = document.getElementById('u288');

var u461 = document.getElementById('u461');

var u624 = document.getElementById('u624');
gv_vAlignTable['u624'] = 'center';
var u172 = document.getElementById('u172');

var u271 = document.getElementById('u271');
gv_vAlignTable['u271'] = 'top';
var u515 = document.getElementById('u515');

var u28 = document.getElementById('u28');

u28.style.cursor = 'pointer';
if (bIE) u28.attachEvent("onclick", Clicku28);
else u28.addEventListener("click", Clicku28, true);
function Clicku28(e)
{

if (true) {

	self.location.href="系统管理.html" + GetQuerystring();

}

}

var u356 = document.getElementById('u356');

var u43 = document.getElementById('u43');

var u502 = document.getElementById('u502');
gv_vAlignTable['u502'] = 'center';
var u75 = document.getElementById('u75');

var u554 = document.getElementById('u554');
gv_vAlignTable['u554'] = 'center';
var u83 = document.getElementById('u83');
gv_vAlignTable['u83'] = 'top';
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

var u430 = document.getElementById('u430');
gv_vAlignTable['u430'] = 'top';
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

var u383 = document.getElementById('u383');
gv_vAlignTable['u383'] = 'center';
var u533 = document.getElementById('u533');

var u445 = document.getElementById('u445');

var u620 = document.getElementById('u620');
gv_vAlignTable['u620'] = 'center';
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

var u568 = document.getElementById('u568');
gv_vAlignTable['u568'] = 'center';
var u311 = document.getElementById('u311');
gv_vAlignTable['u311'] = 'top';
var u152 = document.getElementById('u152');

u152.style.cursor = 'pointer';
if (bIE) u152.attachEvent("onclick", Clicku152);
else u152.addEventListener("click", Clicku152, true);
function Clicku152(e)
{

if (true) {

	self.location.href="发货状态管理.html" + GetQuerystring();

}

}

var u432 = document.getElementById('u432');
gv_vAlignTable['u432'] = 'top';
var u80 = document.getElementById('u80');

var u275 = document.getElementById('u275');

var u237 = document.getElementById('u237');
gv_vAlignTable['u237'] = 'top';
var u375 = document.getElementById('u375');

u375.style.cursor = 'pointer';
if (bIE) u375.attachEvent("onclick", Clicku375);
else u375.addEventListener("click", Clicku375, true);
function Clicku375(e)
{

if (true) {

	self.location.href="手工充值管理.html" + GetQuerystring();

}

}

var u512 = document.getElementById('u512');
gv_vAlignTable['u512'] = 'center';
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

var u52 = document.getElementById('u52');

u52.style.cursor = 'pointer';
if (bIE) u52.attachEvent("onclick", Clicku52);
else u52.addEventListener("click", Clicku52, true);
function Clicku52(e)
{

if (true) {

	self.location.href="调拨要货单管理.html" + GetQuerystring();

}

}

var u469 = document.getElementById('u469');

var u490 = document.getElementById('u490');
gv_vAlignTable['u490'] = 'center';
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

var u434 = document.getElementById('u434');
gv_vAlignTable['u434'] = 'top';
var u519 = document.getElementById('u519');

var u316 = document.getElementById('u316');

var u30 = document.getElementById('u30');

u30.style.cursor = 'pointer';
if (bIE) u30.attachEvent("onclick", Clicku30);
else u30.addEventListener("click", Clicku30, true);
function Clicku30(e)
{

if (true) {

	self.location.href="统计查询.html" + GetQuerystring();

}

}

var u623 = document.getElementById('u623');

var u246 = document.getElementById('u246');

u246.style.cursor = 'pointer';
if (bIE) u246.attachEvent("onclick", Clicku246);
else u246.addEventListener("click", Clicku246, true);
function Clicku246(e)
{

if (true) {

	self.location.href="日志管理.html" + "";

}

}

var u435 = document.getElementById('u435');

var u486 = document.getElementById('u486');
gv_vAlignTable['u486'] = 'center';
var u610 = document.getElementById('u610');
gv_vAlignTable['u610'] = 'center';
var u197 = document.getElementById('u197');
gv_vAlignTable['u197'] = 'top';
var u347 = document.getElementById('u347');
gv_vAlignTable['u347'] = 'top';
var u195 = document.getElementById('u195');
gv_vAlignTable['u195'] = 'top';
var u355 = document.getElementById('u355');
gv_vAlignTable['u355'] = 'center';
var u625 = document.getElementById('u625');

var u449 = document.getElementById('u449');

var u491 = document.getElementById('u491');

var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
var u641 = document.getElementById('u641');
gv_vAlignTable['u641'] = 'top';
var u221 = document.getElementById('u221');
gv_vAlignTable['u221'] = 'top';
var u352 = document.getElementById('u352');
gv_vAlignTable['u352'] = 'top';
var u499 = document.getElementById('u499');

var u61 = document.getElementById('u61');
gv_vAlignTable['u61'] = 'top';
var u540 = document.getElementById('u540');
gv_vAlignTable['u540'] = 'center';
var u444 = document.getElementById('u444');
gv_vAlignTable['u444'] = 'center';
var u370 = document.getElementById('u370');
gv_vAlignTable['u370'] = 'center';
var u538 = document.getElementById('u538');
gv_vAlignTable['u538'] = 'center';
var u379 = document.getElementById('u379');

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

var u631 = document.getElementById('u631');

var u310 = document.getElementById('u310');

var u151 = document.getElementById('u151');
gv_vAlignTable['u151'] = 'top';
var u117 = document.getElementById('u117');
gv_vAlignTable['u117'] = 'top';
var u378 = document.getElementById('u378');

u378.style.cursor = 'pointer';
if (bIE) u378.attachEvent("onclick", Clicku378);
else u378.addEventListener("click", Clicku378, true);
function Clicku378(e)
{

if (true) {

	self.location.href="手工充值审核.html" + GetQuerystring();

}

}

var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
var u236 = document.getElementById('u236');

u236.style.cursor = 'pointer';
if (bIE) u236.attachEvent("onclick", Clicku236);
else u236.addEventListener("click", Clicku236, true);
function Clicku236(e)
{

if (true) {

	self.location.href="IP访问限制管理.html" + "";

}

}

var u374 = document.getElementById('u374');
gv_vAlignTable['u374'] = 'center';
var u287 = document.getElementById('u287');
gv_vAlignTable['u287'] = 'top';
var u468 = document.getElementById('u468');
gv_vAlignTable['u468'] = 'center';
var u411 = document.getElementById('u411');

var u569 = document.getElementById('u569');

var u581 = document.getElementById('u581');

var u122 = document.getElementById('u122');

u122.style.cursor = 'pointer';
if (bIE) u122.attachEvent("onclick", Clicku122);
else u122.addEventListener("click", Clicku122, true);
function Clicku122(e)
{

if (true) {

	self.location.href="B2B预存款管理.html" + GetQuerystring();

}

}

var u240 = document.getElementById('u240');

u240.style.cursor = 'pointer';
if (bIE) u240.attachEvent("onclick", Clicku240);
else u240.addEventListener("click", Clicku240, true);
function Clicku240(e)
{

if (true) {

	self.location.href="合同文件管理.html" + "";

}

}

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

var u419 = document.getElementById('u419');
gv_vAlignTable['u419'] = 'top';
var u622 = document.getElementById('u622');
gv_vAlignTable['u622'] = 'center';
var u589 = document.getElementById('u589');

var u166 = document.getElementById('u166');

u166.style.cursor = 'pointer';
if (bIE) u166.attachEvent("onclick", Clicku166);
else u166.addEventListener("click", Clicku166, true);
function Clicku166(e)
{

if (true) {

	self.location.href="财务报表管理.html" + GetQuerystring();

}

}

var u70 = document.getElementById('u70');

var u6 = document.getElementById('u6');
gv_vAlignTable['u6'] = 'top';
var u397 = document.getElementById('u397');
gv_vAlignTable['u397'] = 'center';
var u473 = document.getElementById('u473');

var u614 = document.getElementById('u614');
gv_vAlignTable['u614'] = 'center';
var u171 = document.getElementById('u171');
gv_vAlignTable['u171'] = 'top';
var u524 = document.getElementById('u524');
gv_vAlignTable['u524'] = 'center';
var u552 = document.getElementById('u552');
gv_vAlignTable['u552'] = 'center';
var u207 = document.getElementById('u207');
gv_vAlignTable['u207'] = 'top';
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

var u501 = document.getElementById('u501');

var u14 = document.getElementById('u14');

u14.style.cursor = 'pointer';
if (bIE) u14.attachEvent("onclick", Clicku14);
else u14.addEventListener("click", Clicku14, true);
function Clicku14(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u305 = document.getElementById('u305');

var u146 = document.getElementById('u146');

var u616 = document.getElementById('u616');
gv_vAlignTable['u616'] = 'center';
var u427 = document.getElementById('u427');

var u212 = document.getElementById('u212');

var u46 = document.getElementById('u46');

u46.style.cursor = 'pointer';
if (bIE) u46.attachEvent("onclick", Clicku46);
else u46.addEventListener("click", Clicku46, true);
function Clicku46(e)
{

if (true) {

	self.location.href="请购单审核管理.html" + GetQuerystring();

}

}

var u382 = document.getElementById('u382');

var u517 = document.getElementById('u517');

var u509 = document.getElementById('u509');

var u150 = document.getElementById('u150');

u150.style.cursor = 'pointer';
if (bIE) u150.attachEvent("onclick", Clicku150);
else u150.addEventListener("click", Clicku150, true);
function Clicku150(e)
{

if (true) {

	self.location.href="发货单管理.html" + GetQuerystring();

}

}

var u243 = document.getElementById('u243');
gv_vAlignTable['u243'] = 'top';
var u567 = document.getElementById('u567');

var u649 = document.getElementById('u649');

var u531 = document.getElementById('u531');

var u373 = document.getElementById('u373');

var u329 = document.getElementById('u329');

var u617 = document.getElementById('u617');

var u274 = document.getElementById('u274');

var u632 = document.getElementById('u632');
gv_vAlignTable['u632'] = 'center';
var u480 = document.getElementById('u480');
gv_vAlignTable['u480'] = 'center';
var u532 = document.getElementById('u532');
gv_vAlignTable['u532'] = 'center';
var u558 = document.getElementById('u558');
gv_vAlignTable['u558'] = 'center';
var u165 = document.getElementById('u165');
gv_vAlignTable['u165'] = 'top';
var u462 = document.getElementById('u462');
gv_vAlignTable['u462'] = 'center';
var u604 = document.getElementById('u604');
gv_vAlignTable['u604'] = 'center';
var u269 = document.getElementById('u269');
gv_vAlignTable['u269'] = 'top';
var u130 = document.getElementById('u130');

var u315 = document.getElementById('u315');
gv_vAlignTable['u315'] = 'top';
var u592 = document.getElementById('u592');
gv_vAlignTable['u592'] = 'center';
var u55 = document.getElementById('u55');
gv_vAlignTable['u55'] = 'top';
var u534 = document.getElementById('u534');
gv_vAlignTable['u534'] = 'center';
var u309 = document.getElementById('u309');
gv_vAlignTable['u309'] = 'top';
var u95 = document.getElementById('u95');
gv_vAlignTable['u95'] = 'top';
var u492 = document.getElementById('u492');
gv_vAlignTable['u492'] = 'center';
var u196 = document.getElementById('u196');

u196.style.cursor = 'pointer';
if (bIE) u196.attachEvent("onclick", Clicku196);
else u196.addEventListener("click", Clicku196, true);
function Clicku196(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u254 = document.getElementById('u254');

var u346 = document.getElementById('u346');

u346.style.cursor = 'pointer';
if (bIE) u346.attachEvent("onclick", Clicku346);
else u346.addEventListener("click", Clicku346, true);
function Clicku346(e)
{

if (true) {

	self.location.href="售后入库.html" + GetQuerystring();

}

}

var u535 = document.getElementById('u535');

var u337 = document.getElementById('u337');
gv_vAlignTable['u337'] = 'top';
var u477 = document.getElementById('u477');

var u640 = document.getElementById('u640');
gv_vAlignTable['u640'] = 'center';
var u145 = document.getElementById('u145');
gv_vAlignTable['u145'] = 'top';
var u442 = document.getElementById('u442');
gv_vAlignTable['u442'] = 'center';
var u377 = document.getElementById('u377');
gv_vAlignTable['u377'] = 'center';
var u239 = document.getElementById('u239');
gv_vAlignTable['u239'] = 'top';
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

var u498 = document.getElementById('u498');
gv_vAlignTable['u498'] = 'center';
var u527 = document.getElementById('u527');

var u485 = document.getElementById('u485');

var u359 = document.getElementById('u359');
gv_vAlignTable['u359'] = 'center';
var u566 = document.getElementById('u566');
gv_vAlignTable['u566'] = 'center';
var u234 = document.getElementById('u234');

u234.style.cursor = 'pointer';
if (bIE) u234.attachEvent("onclick", Clicku234);
else u234.addEventListener("click", Clicku234, true);
function Clicku234(e)
{

if (true) {

	self.location.href="权限管理.html" + "";

}

}

var u49 = document.getElementById('u49');
gv_vAlignTable['u49'] = 'top';
var u64 = document.getElementById('u64');

u64.style.cursor = 'pointer';
if (bIE) u64.attachEvent("onclick", Clicku64);
else u64.addEventListener("click", Clicku64, true);
function Clicku64(e)
{

if (true) {

	self.location.href="采购退货单管理.html" + GetQuerystring();

}

}

var u328 = document.getElementById('u328');

var u116 = document.getElementById('u116');

u116.style.cursor = 'pointer';
if (bIE) u116.attachEvent("onclick", Clicku116);
else u116.addEventListener("click", Clicku116, true);
function Clicku116(e)
{

if (true) {

	self.location.href="B2B价保审核管理.html" + GetQuerystring();

}

}

var u452 = document.getElementById('u452');
gv_vAlignTable['u452'] = 'center';
var u89 = document.getElementById('u89');
gv_vAlignTable['u89'] = 'top';
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

var u219 = document.getElementById('u219');
gv_vAlignTable['u219'] = 'top';
var u410 = document.getElementById('u410');

var u453 = document.getElementById('u453');

var u593 = document.getElementById('u593');

var u147 = document.getElementById('u147');

var u418 = document.getElementById('u418');

var u291 = document.getElementById('u291');
gv_vAlignTable['u291'] = 'top';
var u395 = document.getElementById('u395');
gv_vAlignTable['u395'] = 'center';
var u441 = document.getElementById('u441');

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

var u588 = document.getElementById('u588');
gv_vAlignTable['u588'] = 'center';
var u308 = document.getElementById('u308');

u308.style.cursor = 'pointer';
if (bIE) u308.attachEvent("onclick", Clicku308);
else u308.addEventListener("click", Clicku308, true);
function Clicku308(e)
{

if (true) {

	self.location.href="出库管理.html" + GetQuerystring();

}

}

var u149 = document.getElementById('u149');
gv_vAlignTable['u149'] = 'top';
var u299 = document.getElementById('u299');
gv_vAlignTable['u299'] = 'top';
var u41 = document.getElementById('u41');
gv_vAlignTable['u41'] = 'top';
var u550 = document.getElementById('u550');
gv_vAlignTable['u550'] = 'center';
var u170 = document.getElementById('u170');

var u58 = document.getElementById('u58');

u58.style.cursor = 'pointer';
if (bIE) u58.attachEvent("onclick", Clicku58);
else u58.addEventListener("click", Clicku58, true);
function Clicku58(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u45 = document.getElementById('u45');
gv_vAlignTable['u45'] = 'top';
var u73 = document.getElementById('u73');
gv_vAlignTable['u73'] = 'top';
var u303 = document.getElementById('u303');
gv_vAlignTable['u303'] = 'top';
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

var u433 = document.getElementById('u433');

var u213 = document.getElementById('u213');

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

var u238 = document.getElementById('u238');

u238.style.cursor = 'pointer';
if (bIE) u238.attachEvent("onclick", Clicku238);
else u238.addEventListener("click", Clicku238, true);
function Clicku238(e)
{

if (true) {

	self.location.href="合同类别管理.html" + "";

}

}

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

var u513 = document.getElementById('u513');

var u211 = document.getElementById('u211');
gv_vAlignTable['u211'] = 'top';
var u393 = document.getElementById('u393');

u393.style.cursor = 'pointer';
if (bIE) u393.attachEvent("onclick", Clicku393);
else u393.addEventListener("click", Clicku393, true);
function Clicku393(e)
{

if (true) {

	self.location.href="佣金结算周期设置.html" + GetQuerystring();

}

}

var u565 = document.getElementById('u565');

var u381 = document.getElementById('u381');

u381.style.cursor = 'pointer';
if (bIE) u381.attachEvent("onclick", Clicku381);
else u381.addEventListener("click", Clicku381, true);
function Clicku381(e)
{

if (true) {

	self.location.href="订单退款管理.html" + GetQuerystring();

}

}

var u233 = document.getElementById('u233');
gv_vAlignTable['u233'] = 'top';
var u371 = document.getElementById('u371');

var u255 = document.getElementById('u255');
gv_vAlignTable['u255'] = 'top';
var u615 = document.getElementById('u615');

var u456 = document.getElementById('u456');
gv_vAlignTable['u456'] = 'center';
var u389 = document.getElementById('u389');
gv_vAlignTable['u389'] = 'center';
var u50 = document.getElementById('u50');

u50.style.cursor = 'pointer';
if (bIE) u50.attachEvent("onclick", Clicku50);
else u50.addEventListener("click", Clicku50, true);
function Clicku50(e)
{

if (true) {

	self.location.href="要货申请单管理.html" + GetQuerystring();

}

}

var u18 = document.getElementById('u18');

var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u273 = document.getElementById('u273');
gv_vAlignTable['u273'] = 'top';
var u163 = document.getElementById('u163');
gv_vAlignTable['u163'] = 'top';
var u460 = document.getElementById('u460');
gv_vAlignTable['u460'] = 'center';
var u90 = document.getElementById('u90');

var u8 = document.getElementById('u8');

var u394 = document.getElementById('u394');

var u580 = document.getElementById('u580');
gv_vAlignTable['u580'] = 'center';
var u603 = document.getElementById('u603');

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

var u327 = document.getElementById('u327');
gv_vAlignTable['u327'] = 'top';
var u633 = document.getElementById('u633');

var u252 = document.getElementById('u252');

var u484 = document.getElementById('u484');
gv_vAlignTable['u484'] = 'center';
var u508 = document.getElementById('u508');
gv_vAlignTable['u508'] = 'center';
var u621 = document.getElementById('u621');

var u26 = document.getElementById('u26');

u26.style.cursor = 'pointer';
if (bIE) u26.attachEvent("onclick", Clicku26);
else u26.addEventListener("click", Clicku26, true);
function Clicku26(e)
{

if (true) {

	self.location.href="财务管理.html" + GetQuerystring();

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

var u547 = document.getElementById('u547');

var u332 = document.getElementById('u332');

u332.style.cursor = 'pointer';
if (bIE) u332.attachEvent("onclick", Clicku332);
else u332.addEventListener("click", Clicku332, true);
function Clicku332(e)
{

if (true) {

	self.location.href="出库单审核.html" + GetQuerystring();

}

}

var u143 = document.getElementById('u143');
gv_vAlignTable['u143'] = 'top';
var u429 = document.getElementById('u429');

var u634 = document.getElementById('u634');
gv_vAlignTable['u634'] = 'center';
var u446 = document.getElementById('u446');
gv_vAlignTable['u446'] = 'center';
var u341 = document.getElementById('u341');

var u629 = document.getElementById('u629');

var u619 = document.getElementById('u619');

var u363 = document.getElementById('u363');
gv_vAlignTable['u363'] = 'center';
var u203 = document.getElementById('u203');
gv_vAlignTable['u203'] = 'top';
var u426 = document.getElementById('u426');
gv_vAlignTable['u426'] = 'top';
var u241 = document.getElementById('u241');
gv_vAlignTable['u241'] = 'top';
var u636 = document.getElementById('u636');
gv_vAlignTable['u636'] = 'center';
var u627 = document.getElementById('u627');

var u361 = document.getElementById('u361');
gv_vAlignTable['u361'] = 'center';
var u600 = document.getElementById('u600');
gv_vAlignTable['u600'] = 'center';
var u317 = document.getElementById('u317');

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u455 = document.getElementById('u455');

var u173 = document.getElementById('u173');
gv_vAlignTable['u173'] = 'top';
var u398 = document.getElementById('u398');

u398.style.cursor = 'pointer';
if (bIE) u398.attachEvent("onclick", Clicku398);
else u398.addEventListener("click", Clicku398, true);
function Clicku398(e)
{

if (true) {

	self.location.href="佣金结算周期设置.html" + GetQuerystring();

}

}

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

var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'top';
var u587 = document.getElementById('u587');

var u321 = document.getElementById('u321');
gv_vAlignTable['u321'] = 'top';
var u81 = document.getElementById('u81');

var u285 = document.getElementById('u285');
gv_vAlignTable['u285'] = 'top';
var u422 = document.getElementById('u422');
gv_vAlignTable['u422'] = 'top';
var u406 = document.getElementById('u406');
gv_vAlignTable['u406'] = 'top';
var u67 = document.getElementById('u67');

var u544 = document.getElementById('u544');
gv_vAlignTable['u544'] = 'center';
var u133 = document.getElementById('u133');
gv_vAlignTable['u133'] = 'top';
var u479 = document.getElementById('u479');

var u113 = document.getElementById('u113');
gv_vAlignTable['u113'] = 'top';
var u466 = document.getElementById('u466');
gv_vAlignTable['u466'] = 'center';
var u121 = document.getElementById('u121');
gv_vAlignTable['u121'] = 'top';
var u164 = document.getElementById('u164');

u164.style.cursor = 'pointer';
if (bIE) u164.attachEvent("onclick", Clicku164);
else u164.addEventListener("click", Clicku164, true);
function Clicku164(e)
{

if (true) {

	self.location.href="成本核算管理.html" + GetQuerystring();

}

}

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

var u177 = document.getElementById('u177');

var u448 = document.getElementById('u448');
gv_vAlignTable['u448'] = 'center';
var u301 = document.getElementById('u301');
gv_vAlignTable['u301'] = 'top';
var u142 = document.getElementById('u142');

u142.style.cursor = 'pointer';
if (bIE) u142.attachEvent("onclick", Clicku142);
else u142.addEventListener("click", Clicku142, true);
function Clicku142(e)
{

if (true) {

	self.location.href="佣金结算管理.html" + GetQuerystring();

}

}

var u159 = document.getElementById('u159');
gv_vAlignTable['u159'] = 'top';
var u500 = document.getElementById('u500');
gv_vAlignTable['u500'] = 'center';
var u507 = document.getElementById('u507');

var u340 = document.getElementById('u340');

var u29 = document.getElementById('u29');
gv_vAlignTable['u29'] = 'top';
var u618 = document.getElementById('u618');
gv_vAlignTable['u618'] = 'center';
var u44 = document.getElementById('u44');

u44.style.cursor = 'pointer';
if (bIE) u44.attachEvent("onclick", Clicku44);
else u44.addEventListener("click", Clicku44, true);
function Clicku44(e)
{

if (true) {

	self.location.href="请购单管理.html" + GetQuerystring();

}

}

var u24 = document.getElementById('u24');

u24.style.cursor = 'pointer';
if (bIE) u24.attachEvent("onclick", Clicku24);
else u24.addEventListener("click", Clicku24, true);
function Clicku24(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u563 = document.getElementById('u563');

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

var u124 = document.getElementById('u124');

u124.style.cursor = 'pointer';
if (bIE) u124.attachEvent("onclick", Clicku124);
else u124.addEventListener("click", Clicku124, true);
function Clicku124(e)
{

if (true) {

	self.location.href="B2B订单管理.html" + GetQuerystring();

}

}

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

var u223 = document.getElementById('u223');
gv_vAlignTable['u223'] = 'top';
var u380 = document.getElementById('u380');
gv_vAlignTable['u380'] = 'center';
var u530 = document.getElementById('u530');
gv_vAlignTable['u530'] = 'center';
var u548 = document.getElementById('u548');
gv_vAlignTable['u548'] = 'center';
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

var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u267 = document.getElementById('u267');
gv_vAlignTable['u267'] = 'top';
var u320 = document.getElementById('u320');

u320.style.cursor = 'pointer';
if (bIE) u320.attachEvent("onclick", Clicku320);
else u320.addEventListener("click", Clicku320, true);
function Clicku320(e)
{

if (true) {

	self.location.href="销售出库.html" + GetQuerystring();

}

}

var u388 = document.getElementById('u388');

var u561 = document.getElementById('u561');

var u405 = document.getElementById('u405');
gv_vAlignTable['u405'] = 'center';
var u22 = document.getElementById('u22');

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

var u542 = document.getElementById('u542');
gv_vAlignTable['u542'] = 'center';
var u38 = document.getElementById('u38');

u38.style.cursor = 'pointer';
if (bIE) u38.attachEvent("onclick", Clicku38);
else u38.addEventListener("click", Clicku38, true);
function Clicku38(e)
{

if (true) {

	self.location.href="销售报表查询.html" + GetQuerystring();

}

}

var u112 = document.getElementById('u112');

u112.style.cursor = 'pointer';
if (bIE) u112.attachEvent("onclick", Clicku112);
else u112.addEventListener("click", Clicku112, true);
function Clicku112(e)
{

if (true) {

	self.location.href="B2B返利审核管理.html" + GetQuerystring();

}

}

var u53 = document.getElementById('u53');
gv_vAlignTable['u53'] = 'top';
var u250 = document.getElementById('u250');

var u602 = document.getElementById('u602');
gv_vAlignTable['u602'] = 'center';
var u93 = document.getElementById('u93');
gv_vAlignTable['u93'] = 'top';
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

var u326 = document.getElementById('u326');

u326.style.cursor = 'pointer';
if (bIE) u326.attachEvent("onclick", Clicku326);
else u326.addEventListener("click", Clicku326, true);
function Clicku326(e)
{

if (true) {

	self.location.href="其他出库[如活动赠品].html" + GetQuerystring();

}

}

var u643 = document.getElementById('u643');

u643.style.cursor = 'pointer';
if (bIE) u643.attachEvent("onclick", Clicku643);
else u643.addEventListener("click", Clicku643, true);
function Clicku643(e)
{

if (true) {

	self.location.href="佣金结算管理.html" + GetQuerystring();

}

}

var u483 = document.getElementById('u483');

var u438 = document.getElementById('u438');
gv_vAlignTable['u438'] = 'top';
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

var u357 = document.getElementById('u357');
gv_vAlignTable['u357'] = 'center';
var u543 = document.getElementById('u543');

var u265 = document.getElementById('u265');
gv_vAlignTable['u265'] = 'top';
var u562 = document.getElementById('u562');
gv_vAlignTable['u562'] = 'center';
var u628 = document.getElementById('u628');
gv_vAlignTable['u628'] = 'center';
var u230 = document.getElementById('u230');

u230.style.cursor = 'pointer';
if (bIE) u230.attachEvent("onclick", Clicku230);
else u230.addEventListener("click", Clicku230, true);
function Clicku230(e)
{

if (true) {

	self.location.href="用户管理.html" + "";

}

}

var u189 = document.getElementById('u189');
gv_vAlignTable['u189'] = 'top';
var u339 = document.getElementById('u339');
gv_vAlignTable['u339'] = 'top';
var u496 = document.getElementById('u496');
gv_vAlignTable['u496'] = 'center';
var u2 = document.getElementById('u2');

var u62 = document.getElementById('u62');

u62.style.cursor = 'pointer';
if (bIE) u62.attachEvent("onclick", Clicku62);
else u62.addEventListener("click", Clicku62, true);
function Clicku62(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u409 = document.getElementById('u409');
gv_vAlignTable['u409'] = 'top';
var u635 = document.getElementById('u635');

var u354 = document.getElementById('u354');

var u79 = document.getElementById('u79');
gv_vAlignTable['u79'] = 'top';
var u579 = document.getElementById('u579');

var u403 = document.getElementById('u403');
gv_vAlignTable['u403'] = 'center';
var u626 = document.getElementById('u626');
gv_vAlignTable['u626'] = 'center';
var u585 = document.getElementById('u585');

var u577 = document.getElementById('u577');

var u127 = document.getElementById('u127');
gv_vAlignTable['u127'] = 'top';
var u404 = document.getElementById('u404');

var u245 = document.getElementById('u245');
gv_vAlignTable['u245'] = 'top';
var u586 = document.getElementById('u586');
gv_vAlignTable['u586'] = 'center';
var u536 = document.getElementById('u536');
gv_vAlignTable['u536'] = 'center';
var u297 = document.getElementById('u297');
gv_vAlignTable['u297'] = 'top';
var u651 = document.getElementById('u651');

var u421 = document.getElementById('u421');

var u497 = document.getElementById('u497');

var u148 = document.getElementById('u148');

u148.style.cursor = 'pointer';
if (bIE) u148.attachEvent("onclick", Clicku148);
else u148.addEventListener("click", Clicku148, true);
function Clicku148(e)
{

if (true) {

	self.location.href="EMS单据管理.html" + GetQuerystring();

}

}

var u132 = document.getElementById('u132');

u132.style.cursor = 'pointer';
if (bIE) u132.attachEvent("onclick", Clicku132);
else u132.addEventListener("click", Clicku132, true);
function Clicku132(e)
{

if (true) {

	self.location.href="充值订单管理.html" + GetQuerystring();

}

}

var u436 = document.getElementById('u436');
gv_vAlignTable['u436'] = 'top';
var u591 = document.getElementById('u591');

var u652 = document.getElementById('u652');
gv_vAlignTable['u652'] = 'center';
var u175 = document.getElementById('u175');
gv_vAlignTable['u175'] = 'top';
var u472 = document.getElementById('u472');
gv_vAlignTable['u472'] = 'center';
var u465 = document.getElementById('u465');

var u428 = document.getElementById('u428');
gv_vAlignTable['u428'] = 'top';
var u464 = document.getElementById('u464');
gv_vAlignTable['u464'] = 'center';
var u599 = document.getElementById('u599');

var u176 = document.getElementById('u176');

var u71 = document.getElementById('u71');
gv_vAlignTable['u71'] = 'top';
var u557 = document.getElementById('u557');

var u396 = document.getElementById('u396');

var u470 = document.getElementById('u470');
gv_vAlignTable['u470'] = 'center';
var u528 = document.getElementById('u528');
gv_vAlignTable['u528'] = 'center';
var u551 = document.getElementById('u551');

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

var u539 = document.getElementById('u539');

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

var u158 = document.getElementById('u158');

u158.style.cursor = 'pointer';
if (bIE) u158.attachEvent("onclick", Clicku158);
else u158.addEventListener("click", Clicku158, true);
function Clicku158(e)
{

if (true) {

	self.location.href="基础资料管理.html" + GetQuerystring();

}

}

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

var u478 = document.getElementById('u478');
gv_vAlignTable['u478'] = 'center';
var u495 = document.getElementById('u495');

var u646 = document.getElementById('u646');
gv_vAlignTable['u646'] = 'center';
var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u155 = document.getElementById('u155');
gv_vAlignTable['u155'] = 'top';
var u511 = document.getElementById('u511');

var u249 = document.getElementById('u249');
gv_vAlignTable['u249'] = 'top';
var u235 = document.getElementById('u235');
gv_vAlignTable['u235'] = 'top';
var u47 = document.getElementById('u47');
gv_vAlignTable['u47'] = 'top';
var u392 = document.getElementById('u392');
gv_vAlignTable['u392'] = 'center';
var u413 = document.getElementById('u413');

var u584 = document.getElementById('u584');
gv_vAlignTable['u584'] = 'center';
var u87 = document.getElementById('u87');
gv_vAlignTable['u87'] = 'top';
var u605 = document.getElementById('u605');

var u244 = document.getElementById('u244');

u244.style.cursor = 'pointer';
if (bIE) u244.attachEvent("onclick", Clicku244);
else u244.addEventListener("click", Clicku244, true);
function Clicku244(e)
{

if (true) {

	self.location.href="审批流程管理.html" + "";

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

var u475 = document.getElementById('u475');

var u7 = document.getElementById('u7');
gv_vAlignTable['u7'] = 'top';
var u573 = document.getElementById('u573');

var u248 = document.getElementById('u248');

u248.style.cursor = 'pointer';
if (bIE) u248.attachEvent("onclick", Clicku248);
else u248.addEventListener("click", Clicku248, true);
function Clicku248(e)
{

if (true) {

	self.location.href="系统参数管理.html" + GetQuerystring();

}

}

var u637 = document.getElementById('u637');

var u307 = document.getElementById('u307');
gv_vAlignTable['u307'] = 'top';
var u174 = document.getElementById('u174');

var u471 = document.getElementById('u471');

var u601 = document.getElementById('u601');

var u279 = document.getElementById('u279');
gv_vAlignTable['u279'] = 'top';
var u642 = document.getElementById('u642');

var u597 = document.getElementById('u597');

var u556 = document.getElementById('u556');
gv_vAlignTable['u556'] = 'center';
var u325 = document.getElementById('u325');
gv_vAlignTable['u325'] = 'top';
var u56 = document.getElementById('u56');

u56.style.cursor = 'pointer';
if (bIE) u56.attachEvent("onclick", Clicku56);
else u56.addEventListener("click", Clicku56, true);
function Clicku56(e)
{

if (true) {

	self.location.href="采购结算单管理.html" + GetQuerystring();

}

}

var u482 = document.getElementById('u482');
gv_vAlignTable['u482'] = 'center';
var u609 = document.getElementById('u609');

var u263 = document.getElementById('u263');
gv_vAlignTable['u263'] = 'top';
var u193 = document.getElementById('u193');
gv_vAlignTable['u193'] = 'top';
var u343 = document.getElementById('u343');
gv_vAlignTable['u343'] = 'top';
var u494 = document.getElementById('u494');
gv_vAlignTable['u494'] = 'center';
var u645 = document.getElementById('u645');

u645.style.cursor = 'pointer';
if (bIE) u645.attachEvent("onclick", Clicku645);
else u645.addEventListener("click", Clicku645, true);
function Clicku645(e)
{

if (true) {

	self.location.href="佣金结算管理.html" + GetQuerystring();

}

}

var u650 = document.getElementById('u650');
gv_vAlignTable['u650'] = 'center';
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

var u338 = document.getElementById('u338');

u338.style.cursor = 'pointer';
if (bIE) u338.attachEvent("onclick", Clicku338);
else u338.addEventListener("click", Clicku338, true);
function Clicku338(e)
{

if (true) {

	self.location.href="移库审核.html" + GetQuerystring();

}

}

var u457 = document.getElementById('u457');

var u437 = document.getElementById('u437');

var u575 = document.getElementById('u575');

var u105 = document.getElementById('u105');
gv_vAlignTable['u105'] = 'top';
if (window.OnLoad) OnLoad();
