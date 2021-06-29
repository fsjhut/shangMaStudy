
var PageName = 'B2B签报管理';
var PageId = 'pa5f819c38f1e4c0eb89f80d119389b2f'
var PageUrl = 'B2B签报管理.html'
document.title = 'B2B签报管理';

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
gv_vAlignTable['u33'] = 'top';
var u402 = document.getElementById('u402');
gv_vAlignTable['u402'] = 'top';
var u65 = document.getElementById('u65');

var u730 = document.getElementById('u730');

u730.style.cursor = 'pointer';
if (bIE) u730.attachEvent("onclick", Clicku730);
else u730.addEventListener("click", Clicku730, true);
function Clicku730(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

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

var u547 = document.getElementById('u547');

var u585 = document.getElementById('u585');

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

var u561 = document.getElementById('u561');

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

var u664 = document.getElementById('u664');
gv_vAlignTable['u664'] = 'center';
var u446 = document.getElementById('u446');
gv_vAlignTable['u446'] = 'top';
var u732 = document.getElementById('u732');

u732.style.cursor = 'pointer';
if (bIE) u732.attachEvent("onclick", Clicku732);
else u732.addEventListener("click", Clicku732, true);
function Clicku732(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u181 = document.getElementById('u181');
gv_vAlignTable['u181'] = 'top';
var u157 = document.getElementById('u157');
gv_vAlignTable['u157'] = 'top';
var u129 = document.getElementById('u129');

var u660 = document.getElementById('u660');
gv_vAlignTable['u660'] = 'top';
var u597 = document.getElementById('u597');

var u417 = document.getElementById('u417');

var u740 = document.getElementById('u740');

u740.style.cursor = 'pointer';
if (bIE) u740.attachEvent("onclick", Clicku740);
else u740.addEventListener("click", Clicku740, true);
function Clicku740(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

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
var u752 = document.getElementById('u752');

u752.style.cursor = 'pointer';
if (bIE) u752.attachEvent("onclick", Clicku752);
else u752.addEventListener("click", Clicku752, true);
function Clicku752(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u598 = document.getElementById('u598');
gv_vAlignTable['u598'] = 'top';
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

var u748 = document.getElementById('u748');

u748.style.cursor = 'pointer';
if (bIE) u748.attachEvent("onclick", Clicku748);
else u748.addEventListener("click", Clicku748, true);
function Clicku748(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

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
gv_vAlignTable['u131'] = 'top';
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

var u564 = document.getElementById('u564');
gv_vAlignTable['u564'] = 'top';
var u753 = document.getElementById('u753');
gv_vAlignTable['u753'] = 'center';
var u506 = document.getElementById('u506');
gv_vAlignTable['u506'] = 'top';
var u493 = document.getElementById('u493');

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
gv_vAlignTable['u510'] = 'top';
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

var u691 = document.getElementById('u691');
gv_vAlignTable['u691'] = 'center';
var u99 = document.getElementById('u99');
gv_vAlignTable['u99'] = 'top';
var u576 = document.getElementById('u576');
gv_vAlignTable['u576'] = 'top';
var u768 = document.getElementById('u768');

u768.style.cursor = 'pointer';
if (bIE) u768.attachEvent("onclick", Clicku768);
else u768.addEventListener("click", Clicku768, true);
function Clicku768(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u386 = document.getElementById('u386');
gv_vAlignTable['u386'] = 'top';
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

	self.location.href="手工充值审核.html" + GetQuerystring();

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

var u323 = document.getElementById('u323');
gv_vAlignTable['u323'] = 'top';
var u518 = document.getElementById('u518');
gv_vAlignTable['u518'] = 'top';
var u391 = document.getElementById('u391');

var u567 = document.getElementById('u567');

var u688 = document.getElementById('u688');
gv_vAlignTable['u688'] = 'center';
var u229 = document.getElementById('u229');
gv_vAlignTable['u229'] = 'top';
var u559 = document.getElementById('u559');

var u399 = document.getElementById('u399');

var u366 = document.getElementById('u366');
gv_vAlignTable['u366'] = 'center';
var u51 = document.getElementById('u51');
gv_vAlignTable['u51'] = 'top';
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

var u91 = document.getElementById('u91');
gv_vAlignTable['u91'] = 'top';
var u441 = document.getElementById('u441');

var u257 = document.getElementById('u257');

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

var u648 = document.getElementById('u648');
gv_vAlignTable['u648'] = 'top';
var u761 = document.getElementById('u761');
gv_vAlignTable['u761'] = 'center';
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

	self.location.href="其他出库[如活动赠品].html" + GetQuerystring();

}

}

var u742 = document.getElementById('u742');

u742.style.cursor = 'pointer';
if (bIE) u742.attachEvent("onclick", Clicku742);
else u742.addEventListener("click", Clicku742, true);
function Clicku742(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u481 = document.getElementById('u481');

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
gv_vAlignTable['u578'] = 'top';
var u319 = document.getElementById('u319');
gv_vAlignTable['u319'] = 'top';
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

var u743 = document.getElementById('u743');
gv_vAlignTable['u743'] = 'center';
var u769 = document.getElementById('u769');
gv_vAlignTable['u769'] = 'center';
var u489 = document.getElementById('u489');

var u699 = document.getElementById('u699');

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

var u59 = document.getElementById('u59');
gv_vAlignTable['u59'] = 'top';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u692 = document.getElementById('u692');

u692.style.cursor = 'pointer';
if (bIE) u692.attachEvent("onclick", Clicku692);
else u692.addEventListener("click", Clicku692, true);
function Clicku692(e)
{

if (true) {

	self.location.href="B2B订单管理.html" + GetQuerystring();

}

}

var u360 = document.getElementById('u360');

var u573 = document.getElementById('u573');

var u103 = document.getElementById('u103');
gv_vAlignTable['u103'] = 'top';
var u529 = document.getElementById('u529');

var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'top';
var u754 = document.getElementById('u754');

u754.style.cursor = 'pointer';
if (bIE) u754.attachEvent("onclick", Clicku754);
else u754.addEventListener("click", Clicku754, true);
function Clicku754(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u693 = document.getElementById('u693');

var u107 = document.getElementById('u107');
gv_vAlignTable['u107'] = 'top';
var u703 = document.getElementById('u703');
gv_vAlignTable['u703'] = 'top';
var u368 = document.getElementById('u368');
gv_vAlignTable['u368'] = 'center';
var u414 = document.getElementById('u414');
gv_vAlignTable['u414'] = 'top';
var u756 = document.getElementById('u756');

u756.style.cursor = 'pointer';
if (bIE) u756.attachEvent("onclick", Clicku756);
else u756.addEventListener("click", Clicku756, true);
function Clicku756(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u365 = document.getElementById('u365');

var u662 = document.getElementById('u662');
gv_vAlignTable['u662'] = 'top';
var u778 = document.getElementById('u778');

u778.style.cursor = 'pointer';
if (bIE) u778.attachEvent("onclick", Clicku778);
else u778.addEventListener("click", Clicku778, true);
function Clicku778(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

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

var u314 = document.getElementById('u314');

var u125 = document.getElementById('u125');
gv_vAlignTable['u125'] = 'top';
var u721 = document.getElementById('u721');
gv_vAlignTable['u721'] = 'center';
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

var u295 = document.getElementById('u295');
gv_vAlignTable['u295'] = 'top';
var u415 = document.getElementById('u415');

var u256 = document.getElementById('u256');

var u747 = document.getElementById('u747');
gv_vAlignTable['u747'] = 'center';
var u661 = document.getElementById('u661');

var u143 = document.getElementById('u143');
gv_vAlignTable['u143'] = 'top';
var u613 = document.getElementById('u613');

u613.style.cursor = 'pointer';
if (bIE) u613.attachEvent("onclick", Clicku613);
else u613.addEventListener("click", Clicku613, true);
function Clicku613(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u751 = document.getElementById('u751');
gv_vAlignTable['u751'] = 'center';
var u729 = document.getElementById('u729');
gv_vAlignTable['u729'] = 'center';
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

var u476 = document.getElementById('u476');
gv_vAlignTable['u476'] = 'top';
var u505 = document.getElementById('u505');

var u677 = document.getElementById('u677');

u677.style.cursor = 'pointer';
if (bIE) u677.attachEvent("onclick", Clicku677);
else u677.addEventListener("click", Clicku677, true);
function Clicku677(e)
{

if (true) {

	self.location.href="B2B价保管理.html" + GetQuerystring();

}

}

var u504 = document.getElementById('u504');
gv_vAlignTable['u504'] = 'top';
var u161 = document.getElementById('u161');
gv_vAlignTable['u161'] = 'top';
var u345 = document.getElementById('u345');
gv_vAlignTable['u345'] = 'top';
var u641 = document.getElementById('u641');

var u474 = document.getElementById('u474');
gv_vAlignTable['u474'] = 'top';
var u439 = document.getElementById('u439');

var u663 = document.getElementById('u663');

var u727 = document.getElementById('u727');
gv_vAlignTable['u727'] = 'center';
var u349 = document.getElementById('u349');
gv_vAlignTable['u349'] = 'top';
var u231 = document.getElementById('u231');
gv_vAlignTable['u231'] = 'top';
var u169 = document.getElementById('u169');
gv_vAlignTable['u169'] = 'top';
var u420 = document.getElementById('u420');
gv_vAlignTable['u420'] = 'top';
var u215 = document.getElementById('u215');
gv_vAlignTable['u215'] = 'top';
var u137 = document.getElementById('u137');
gv_vAlignTable['u137'] = 'top';
var u283 = document.getElementById('u283');
gv_vAlignTable['u283'] = 'top';
var u539 = document.getElementById('u539');

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
gv_vAlignTable['u369'] = 'top';
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
var u477 = document.getElementById('u477');

var u419 = document.getElementById('u419');

var u20 = document.getElementById('u20');

var u226 = document.getElementById('u226');

var u364 = document.getElementById('u364');
gv_vAlignTable['u364'] = 'top';
var u540 = document.getElementById('u540');
gv_vAlignTable['u540'] = 'top';
var u423 = document.getElementById('u423');

var u251 = document.getElementById('u251');
gv_vAlignTable['u251'] = 'top';
var u684 = document.getElementById('u684');

var u746 = document.getElementById('u746');

u746.style.cursor = 'pointer';
if (bIE) u746.attachEvent("onclick", Clicku746);
else u746.addEventListener("click", Clicku746, true);
function Clicku746(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u109 = document.getElementById('u109');
gv_vAlignTable['u109'] = 'top';
var u605 = document.getElementById('u605');

var u689 = document.getElementById('u689');

u689.style.cursor = 'pointer';
if (bIE) u689.attachEvent("onclick", Clicku689);
else u689.addEventListener("click", Clicku689, true);
function Clicku689(e)
{

if (true) {

	self.location.href="B2B预存款管理.html" + GetQuerystring();

}

}

var u183 = document.getElementById('u183');
gv_vAlignTable['u183'] = 'top';
var u424 = document.getElementById('u424');
gv_vAlignTable['u424'] = 'top';
var u259 = document.getElementById('u259');
gv_vAlignTable['u259'] = 'top';
var u773 = document.getElementById('u773');
gv_vAlignTable['u773'] = 'center';
var u612 = document.getElementById('u612');
gv_vAlignTable['u612'] = 'center';
var u607 = document.getElementById('u607');

u607.style.cursor = 'pointer';
if (bIE) u607.attachEvent("onclick", Clicku607);
else u607.addEventListener("click", Clicku607, true);
function Clicku607(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u755 = document.getElementById('u755');
gv_vAlignTable['u755'] = 'center';
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

	self.location.href="采购结算单管理.html" + GetQuerystring();

}

}

var u387 = document.getElementById('u387');

var u676 = document.getElementById('u676');
gv_vAlignTable['u676'] = 'center';
var u503 = document.getElementById('u503');

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

	self.location.href="移库审核.html" + GetQuerystring();

}

}

var u458 = document.getElementById('u458');
gv_vAlignTable['u458'] = 'top';
var u480 = document.getElementById('u480');
gv_vAlignTable['u480'] = 'top';
var u210 = document.getElementById('u210');

var u630 = document.getElementById('u630');
gv_vAlignTable['u630'] = 'center';
var u681 = document.getElementById('u681');

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

var u765 = document.getElementById('u765');
gv_vAlignTable['u765'] = 'center';
var u191 = document.getElementById('u191');
gv_vAlignTable['u191'] = 'top';
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

var u367 = document.getElementById('u367');

var u571 = document.getElementById('u571');

var u101 = document.getElementById('u101');
gv_vAlignTable['u101'] = 'top';
var u488 = document.getElementById('u488');
gv_vAlignTable['u488'] = 'top';
var u638 = document.getElementById('u638');
gv_vAlignTable['u638'] = 'top';
var u763 = document.getElementById('u763');
gv_vAlignTable['u763'] = 'center';
var u199 = document.getElementById('u199');
gv_vAlignTable['u199'] = 'top';
var u656 = document.getElementById('u656');
gv_vAlignTable['u656'] = 'top';
var u372 = document.getElementById('u372');
gv_vAlignTable['u372'] = 'top';
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

var u718 = document.getElementById('u718');

u718.style.cursor = 'pointer';
if (bIE) u718.attachEvent("onclick", Clicku718);
else u718.addEventListener("click", Clicku718, true);
function Clicku718(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u655 = document.getElementById('u655');

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

var u225 = document.getElementById('u225');
gv_vAlignTable['u225'] = 'top';
var u63 = document.getElementById('u63');
gv_vAlignTable['u63'] = 'top';
var u106 = document.getElementById('u106');

u106.style.cursor = 'pointer';
if (bIE) u106.attachEvent("onclick", Clicku106);
else u106.addEventListener("click", Clicku106, true);
function Clicku106(e)
{

if (true) {

	self.location.href="Resources/reload.html#" + encodeURI(PageUrl + GetQuerystring());

}

}

var u659 = document.getElementById('u659');

var u737 = document.getElementById('u737');
gv_vAlignTable['u737'] = 'center';
var u88 = document.getElementById('u88');

var u745 = document.getElementById('u745');
gv_vAlignTable['u745'] = 'center';
var u570 = document.getElementById('u570');
gv_vAlignTable['u570'] = 'top';
var u426 = document.getElementById('u426');
gv_vAlignTable['u426'] = 'top';
var u596 = document.getElementById('u596');
gv_vAlignTable['u596'] = 'top';
var u111 = document.getElementById('u111');
gv_vAlignTable['u111'] = 'top';
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

var u706 = document.getElementById('u706');

var u444 = document.getElementById('u444');
gv_vAlignTable['u444'] = 'top';
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

var u774 = document.getElementById('u774');

u774.style.cursor = 'pointer';
if (bIE) u774.attachEvent("onclick", Clicku774);
else u774.addEventListener("click", Clicku774, true);
function Clicku774(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u119 = document.getElementById('u119');
gv_vAlignTable['u119'] = 'top';
var u537 = document.getElementById('u537');

var u675 = document.getElementById('u675');

var u205 = document.getElementById('u205');
gv_vAlignTable['u205'] = 'top';
var u728 = document.getElementById('u728');

u728.style.cursor = 'pointer';
if (bIE) u728.attachEvent("onclick", Clicku728);
else u728.addEventListener("click", Clicku728, true);
function Clicku728(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u302 = document.getElementById('u302');

var u289 = document.getElementById('u289');
gv_vAlignTable['u289'] = 'top';
var u40 = document.getElementById('u40');

var u700 = document.getElementById('u700');
gv_vAlignTable['u700'] = 'center';
var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'top';
var u541 = document.getElementById('u541');

var u173 = document.getElementById('u173');
gv_vAlignTable['u173'] = 'top';
var u72 = document.getElementById('u72');

var u762 = document.getElementById('u762');

u762.style.cursor = 'pointer';
if (bIE) u762.attachEvent("onclick", Clicku762);
else u762.addEventListener("click", Clicku762, true);
function Clicku762(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u227 = document.getElementById('u227');

var u467 = document.getElementById('u467');

var u530 = document.getElementById('u530');
gv_vAlignTable['u530'] = 'top';
var u135 = document.getElementById('u135');
gv_vAlignTable['u135'] = 'top';
var u281 = document.getElementById('u281');
gv_vAlignTable['u281'] = 'top';
var u574 = document.getElementById('u574');
gv_vAlignTable['u574'] = 'top';
var u516 = document.getElementById('u516');
gv_vAlignTable['u516'] = 'top';
var u168 = document.getElementById('u168');

var u201 = document.getElementById('u201');
gv_vAlignTable['u201'] = 'top';
var u546 = document.getElementById('u546');
gv_vAlignTable['u546'] = 'top';
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

var u749 = document.getElementById('u749');
gv_vAlignTable['u749'] = 'center';
var u764 = document.getElementById('u764');

u764.style.cursor = 'pointer';
if (bIE) u764.attachEvent("onclick", Clicku764);
else u764.addEventListener("click", Clicku764, true);
function Clicku764(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u384 = document.getElementById('u384');
gv_vAlignTable['u384'] = 'top';
var u521 = document.getElementById('u521');

var u16 = document.getElementById('u16');

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

	self.location.href="权限管理.html" + "";

}

}

var u734 = document.getElementById('u734');

u734.style.cursor = 'pointer';
if (bIE) u734.attachEvent("onclick", Clicku734);
else u734.addEventListener("click", Clicku734, true);
function Clicku734(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

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

var u459 = document.getElementById('u459');

var u144 = document.getElementById('u144');

var u115 = document.getElementById('u115');
gv_vAlignTable['u115'] = 'top';
var u333 = document.getElementById('u333');

var u679 = document.getElementById('u679');
gv_vAlignTable['u679'] = 'center';
var u522 = document.getElementById('u522');
gv_vAlignTable['u522'] = 'top';
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

var u421 = document.getElementById('u421');

var u313 = document.getElementById('u313');
gv_vAlignTable['u313'] = 'top';
var u154 = document.getElementById('u154');

var u451 = document.getElementById('u451');

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

var u377 = document.getElementById('u377');

u377.style.cursor = 'pointer';
if (bIE) u377.attachEvent("onclick", Clicku377);
else u377.addEventListener("click", Clicku377, true);
function Clicku377(e)
{

if (true) {

	self.location.href="B2B签报添加.html" + GetQuerystring();

}

}

var u606 = document.getElementById('u606');
gv_vAlignTable['u606'] = 'top';
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

var u335 = document.getElementById('u335');
gv_vAlignTable['u335'] = 'top';
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

	self.location.href="借机出库.html" + GetQuerystring();

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

var u557 = document.getElementById('u557');

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

var u777 = document.getElementById('u777');
gv_vAlignTable['u777'] = 'center';
var u97 = document.getElementById('u97');
gv_vAlignTable['u97'] = 'top';
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
gv_vAlignTable['u353'] = 'center';
var u724 = document.getElementById('u724');

u724.style.cursor = 'pointer';
if (bIE) u724.attachEvent("onclick", Clicku724);
else u724.addEventListener("click", Clicku724, true);
function Clicku724(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'top';
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

var u520 = document.getElementById('u520');
gv_vAlignTable['u520'] = 'top';
var u348 = document.getElementById('u348');

u348.style.cursor = 'pointer';
if (bIE) u348.attachEvent("onclick", Clicku348);
else u348.addEventListener("click", Clicku348, true);
function Clicku348(e)
{

if (true) {

	self.location.href="其他入库[如活动赠品].html" + GetQuerystring();

}

}

var u722 = document.getElementById('u722');
gv_vAlignTable['u722'] = 'top';
var u253 = document.getElementById('u253');
gv_vAlignTable['u253'] = 'top';
var u407 = document.getElementById('u407');

var u390 = document.getElementById('u390');
gv_vAlignTable['u390'] = 'top';
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

var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u572 = document.getElementById('u572');
gv_vAlignTable['u572'] = 'top';
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

var u312 = document.getElementById('u312');

var u153 = document.getElementById('u153');
gv_vAlignTable['u153'] = 'top';
var u450 = document.getElementById('u450');
gv_vAlignTable['u450'] = 'top';
var u412 = document.getElementById('u412');
gv_vAlignTable['u412'] = 'top';
var u69 = document.getElementById('u69');
gv_vAlignTable['u69'] = 'top';
var u66 = document.getElementById('u66');

var u595 = document.getElementById('u595');

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

var u376 = document.getElementById('u376');
gv_vAlignTable['u376'] = 'center';
var u673 = document.getElementById('u673');
gv_vAlignTable['u673'] = 'center';
var u293 = document.getElementById('u293');
gv_vAlignTable['u293'] = 'top';
var u456 = document.getElementById('u456');
gv_vAlignTable['u456'] = 'top';
var u701 = document.getElementById('u701');

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

var u671 = document.getElementById('u671');

u671.style.cursor = 'pointer';
if (bIE) u671.attachEvent("onclick", Clicku671);
else u671.addEventListener("click", Clicku671, true);
function Clicku671(e)
{

if (true) {

	self.location.href="B2B返利管理.html" + GetQuerystring();

}

}

var u167 = document.getElementById('u167');

var u750 = document.getElementById('u750');

u750.style.cursor = 'pointer';
if (bIE) u750.attachEvent("onclick", Clicku750);
else u750.addEventListener("click", Clicku750, true);
function Clicku750(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

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

var u438 = document.getElementById('u438');
gv_vAlignTable['u438'] = 'top';
var u465 = document.getElementById('u465');

var u672 = document.getElementById('u672');

var u172 = document.getElementById('u172');

var u430 = document.getElementById('u430');
gv_vAlignTable['u430'] = 'top';
var u696 = document.getElementById('u696');

var u758 = document.getElementById('u758');

u758.style.cursor = 'pointer';
if (bIE) u758.attachEvent("onclick", Clicku758);
else u758.addEventListener("click", Clicku758, true);
function Clicku758(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u515 = document.getElementById('u515');

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

var u356 = document.getElementById('u356');

var u43 = document.getElementById('u43');
gv_vAlignTable['u43'] = 'top';
var u502 = document.getElementById('u502');
gv_vAlignTable['u502'] = 'top';
var u713 = document.getElementById('u713');
gv_vAlignTable['u713'] = 'center';
var u75 = document.getElementById('u75');
gv_vAlignTable['u75'] = 'top';
var u554 = document.getElementById('u554');
gv_vAlignTable['u554'] = 'top';
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

var u657 = document.getElementById('u657');

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

var u668 = document.getElementById('u668');

u668.style.cursor = 'pointer';
if (bIE) u668.attachEvent("onclick", Clicku668);
else u668.addEventListener("click", Clicku668, true);
function Clicku668(e)
{

if (true) {

	self.location.href="Resources/reload.html#" + encodeURI(PageUrl + GetQuerystring());

}

}

var u383 = document.getElementById('u383');

var u604 = document.getElementById('u604');
gv_vAlignTable['u604'] = 'top';
var u549 = document.getElementById('u549');

var u445 = document.getElementById('u445');

var u733 = document.getElementById('u733');
gv_vAlignTable['u733'] = 'center';
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

var u690 = document.getElementById('u690');

var u311 = document.getElementById('u311');
gv_vAlignTable['u311'] = 'top';
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

var u432 = document.getElementById('u432');
gv_vAlignTable['u432'] = 'top';
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

var u710 = document.getElementById('u710');

u710.style.cursor = 'pointer';
if (bIE) u710.attachEvent("onclick", Clicku710);
else u710.addEventListener("click", Clicku710, true);
function Clicku710(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u698 = document.getElementById('u698');

u698.style.cursor = 'pointer';
if (bIE) u698.attachEvent("onclick", Clicku698);
else u698.addEventListener("click", Clicku698, true);
function Clicku698(e)
{

if (true) {

	self.location.href="B2B出库管理.html" + GetQuerystring();

}

}

var u275 = document.getElementById('u275');
gv_vAlignTable['u275'] = 'top';
var u237 = document.getElementById('u237');
gv_vAlignTable['u237'] = 'top';
var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u512 = document.getElementById('u512');
gv_vAlignTable['u512'] = 'top';
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

	self.location.href="采购单管理.html" + GetQuerystring();

}

}

var u469 = document.getElementById('u469');

var u757 = document.getElementById('u757');
gv_vAlignTable['u757'] = 'center';
var u490 = document.getElementById('u490');
gv_vAlignTable['u490'] = 'top';
var u400 = document.getElementById('u400');
gv_vAlignTable['u400'] = 'top';
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

var u519 = document.getElementById('u519');

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

var u716 = document.getElementById('u716');

var u30 = document.getElementById('u30');

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

var u435 = document.getElementById('u435');

var u486 = document.getElementById('u486');
gv_vAlignTable['u486'] = 'top';
var u624 = document.getElementById('u624');
gv_vAlignTable['u624'] = 'center';
var u610 = document.getElementById('u610');
gv_vAlignTable['u610'] = 'center';
var u197 = document.getElementById('u197');

var u347 = document.getElementById('u347');
gv_vAlignTable['u347'] = 'top';
var u195 = document.getElementById('u195');
gv_vAlignTable['u195'] = 'top';
var u355 = document.getElementById('u355');
gv_vAlignTable['u355'] = 'center';
var u483 = document.getElementById('u483');

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

var u449 = document.getElementById('u449');

var u491 = document.getElementById('u491');

var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
var u553 = document.getElementById('u553');

var u221 = document.getElementById('u221');
gv_vAlignTable['u221'] = 'top';
var u352 = document.getElementById('u352');

var u499 = document.getElementById('u499');

var u776 = document.getElementById('u776');

u776.style.cursor = 'pointer';
if (bIE) u776.attachEvent("onclick", Clicku776);
else u776.addEventListener("click", Clicku776, true);
function Clicku776(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u61 = document.getElementById('u61');
gv_vAlignTable['u61'] = 'top';
var u731 = document.getElementById('u731');
gv_vAlignTable['u731'] = 'center';
var u466 = document.getElementById('u466');
gv_vAlignTable['u466'] = 'top';
var u370 = document.getElementById('u370');

var u379 = document.getElementById('u379');

var u78 = document.getElementById('u78');

var u631 = document.getElementById('u631');

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

var u151 = document.getElementById('u151');
gv_vAlignTable['u151'] = 'top';
var u117 = document.getElementById('u117');
gv_vAlignTable['u117'] = 'top';
var u669 = document.getElementById('u669');

var u378 = document.getElementById('u378');
gv_vAlignTable['u378'] = 'center';
var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
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

var u374 = document.getElementById('u374');
gv_vAlignTable['u374'] = 'center';
var u287 = document.getElementById('u287');

var u468 = document.getElementById('u468');
gv_vAlignTable['u468'] = 'top';
var u411 = document.getElementById('u411');

var u594 = document.getElementById('u594');
gv_vAlignTable['u594'] = 'top';
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

var u708 = document.getElementById('u708');

u708.style.cursor = 'pointer';
if (bIE) u708.attachEvent("onclick", Clicku708);
else u708.addEventListener("click", Clicku708, true);
function Clicku708(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

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

var u442 = document.getElementById('u442');
gv_vAlignTable['u442'] = 'top';
var u674 = document.getElementById('u674');

u674.style.cursor = 'pointer';
if (bIE) u674.attachEvent("onclick", Clicku674);
else u674.addEventListener("click", Clicku674, true);
function Clicku674(e)
{

if (true) {

	self.location.href="B2B返利审核管理.html" + GetQuerystring();

}

}

var u622 = document.getElementById('u622');
gv_vAlignTable['u622'] = 'center';
var u463 = document.getElementById('u463');

var u770 = document.getElementById('u770');

u770.style.cursor = 'pointer';
if (bIE) u770.attachEvent("onclick", Clicku770);
else u770.addEventListener("click", Clicku770, true);
function Clicku770(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u589 = document.getElementById('u589');

var u166 = document.getElementById('u166');

var u70 = document.getElementById('u70');

var u707 = document.getElementById('u707');
gv_vAlignTable['u707'] = 'top';
var u6 = document.getElementById('u6');

var u397 = document.getElementById('u397');

var u460 = document.getElementById('u460');
gv_vAlignTable['u460'] = 'top';
var u771 = document.getElementById('u771');
gv_vAlignTable['u771'] = 'center';
var u614 = document.getElementById('u614');
gv_vAlignTable['u614'] = 'center';
var u171 = document.getElementById('u171');
gv_vAlignTable['u171'] = 'top';
var u448 = document.getElementById('u448');
gv_vAlignTable['u448'] = 'top';
var u717 = document.getElementById('u717');
gv_vAlignTable['u717'] = 'top';
var u552 = document.getElementById('u552');
gv_vAlignTable['u552'] = 'top';
var u207 = document.getElementById('u207');
gv_vAlignTable['u207'] = 'top';
var u767 = document.getElementById('u767');
gv_vAlignTable['u767'] = 'center';
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

var u514 = document.getElementById('u514');
gv_vAlignTable['u514'] = 'top';
var u14 = document.getElementById('u14');

u14.style.cursor = 'pointer';
if (bIE) u14.attachEvent("onclick", Clicku14);
else u14.addEventListener("click", Clicku14, true);
function Clicku14(e)
{

if (true) {

}

}

var u775 = document.getElementById('u775');
gv_vAlignTable['u775'] = 'center';
var u305 = document.getElementById('u305');
gv_vAlignTable['u305'] = 'top';
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

var u443 = document.getElementById('u443');

var u427 = document.getElementById('u427');

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

	self.location.href="发货状态管理.html" + GetQuerystring();

}

}

var u243 = document.getElementById('u243');
gv_vAlignTable['u243'] = 'top';
var u726 = document.getElementById('u726');

u726.style.cursor = 'pointer';
if (bIE) u726.attachEvent("onclick", Clicku726);
else u726.addEventListener("click", Clicku726, true);
function Clicku726(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u649 = document.getElementById('u649');

var u531 = document.getElementById('u531');

var u373 = document.getElementById('u373');

var u720 = document.getElementById('u720');

u720.style.cursor = 'pointer';
if (bIE) u720.attachEvent("onclick", Clicku720);
else u720.addEventListener("click", Clicku720, true);
function Clicku720(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u329 = document.getElementById('u329');
gv_vAlignTable['u329'] = 'top';
var u725 = document.getElementById('u725');
gv_vAlignTable['u725'] = 'center';
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

var u632 = document.getElementById('u632');
gv_vAlignTable['u632'] = 'top';
var u532 = document.getElementById('u532');
gv_vAlignTable['u532'] = 'top';
var u558 = document.getElementById('u558');
gv_vAlignTable['u558'] = 'top';
var u165 = document.getElementById('u165');
gv_vAlignTable['u165'] = 'top';
var u462 = document.getElementById('u462');
gv_vAlignTable['u462'] = 'top';
var u533 = document.getElementById('u533');

var u269 = document.getElementById('u269');
gv_vAlignTable['u269'] = 'top';
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

var u315 = document.getElementById('u315');

var u55 = document.getElementById('u55');
gv_vAlignTable['u55'] = 'top';
var u447 = document.getElementById('u447');

var u534 = document.getElementById('u534');
gv_vAlignTable['u534'] = 'top';
var u779 = document.getElementById('u779');
gv_vAlignTable['u779'] = 'center';
var u309 = document.getElementById('u309');
gv_vAlignTable['u309'] = 'top';
var u95 = document.getElementById('u95');
gv_vAlignTable['u95'] = 'top';
var u196 = document.getElementById('u196');

var u254 = document.getElementById('u254');

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

var u535 = document.getElementById('u535');

var u714 = document.getElementById('u714');
gv_vAlignTable['u714'] = 'top';
var u337 = document.getElementById('u337');
gv_vAlignTable['u337'] = 'top';
var u485 = document.getElementById('u485');

var u640 = document.getElementById('u640');
gv_vAlignTable['u640'] = 'top';
var u145 = document.getElementById('u145');

var u351 = document.getElementById('u351');
gv_vAlignTable['u351'] = 'top';
var u239 = document.getElementById('u239');
gv_vAlignTable['u239'] = 'top';
var u104 = document.getElementById('u104');

var u498 = document.getElementById('u498');
gv_vAlignTable['u498'] = 'top';
var u766 = document.getElementById('u766');

u766.style.cursor = 'pointer';
if (bIE) u766.attachEvent("onclick", Clicku766);
else u766.addEventListener("click", Clicku766, true);
function Clicku766(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u527 = document.getElementById('u527');

var u359 = document.getElementById('u359');
gv_vAlignTable['u359'] = 'center';
var u375 = document.getElementById('u375');

var u105 = document.getElementById('u105');

var u566 = document.getElementById('u566');
gv_vAlignTable['u566'] = 'top';
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

var u49 = document.getElementById('u49');
gv_vAlignTable['u49'] = 'top';
var u680 = document.getElementById('u680');

u680.style.cursor = 'pointer';
if (bIE) u680.attachEvent("onclick", Clicku680);
else u680.addEventListener("click", Clicku680, true);
function Clicku680(e)
{

if (true) {

	self.location.href="B2B价保审核管理.html" + GetQuerystring();

}

}

var u64 = document.getElementById('u64');

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

var u616 = document.getElementById('u616');
gv_vAlignTable['u616'] = 'center';
var u89 = document.getElementById('u89');

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

var u712 = document.getElementById('u712');

u712.style.cursor = 'pointer';
if (bIE) u712.attachEvent("onclick", Clicku712);
else u712.addEventListener("click", Clicku712, true);
function Clicku712(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u286 = document.getElementById('u286');

var u219 = document.getElementById('u219');
gv_vAlignTable['u219'] = 'top';
var u410 = document.getElementById('u410');
gv_vAlignTable['u410'] = 'top';
var u453 = document.getElementById('u453');

var u590 = document.getElementById('u590');
gv_vAlignTable['u590'] = 'top';
var u593 = document.getElementById('u593');

var u147 = document.getElementById('u147');
gv_vAlignTable['u147'] = 'top';
var u461 = document.getElementById('u461');

var u418 = document.getElementById('u418');
gv_vAlignTable['u418'] = 'top';
var u705 = document.getElementById('u705');
gv_vAlignTable['u705'] = 'top';
var u291 = document.getElementById('u291');
gv_vAlignTable['u291'] = 'top';
var u395 = document.getElementById('u395');

var u454 = document.getElementById('u454');
gv_vAlignTable['u454'] = 'top';
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
gv_vAlignTable['u588'] = 'top';
var u308 = document.getElementById('u308');

var u738 = document.getElementById('u738');

u738.style.cursor = 'pointer';
if (bIE) u738.attachEvent("onclick", Clicku738);
else u738.addEventListener("click", Clicku738, true);
function Clicku738(e)
{

if (true) {

	self.location.href="B2B签报查看.html" + GetQuerystring();

}

}

var u149 = document.getElementById('u149');
gv_vAlignTable['u149'] = 'top';
var u299 = document.getElementById('u299');
gv_vAlignTable['u299'] = 'top';
var u41 = document.getElementById('u41');

var u550 = document.getElementById('u550');
gv_vAlignTable['u550'] = 'top';
var u170 = document.getElementById('u170');

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

var u45 = document.getElementById('u45');
gv_vAlignTable['u45'] = 'top';
var u73 = document.getElementById('u73');

var u303 = document.getElementById('u303');

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
gv_vAlignTable['u213'] = 'top';
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

	self.location.href="合同文件管理.html" + "";

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

var u526 = document.getElementById('u526');
gv_vAlignTable['u526'] = 'top';
var u683 = document.getElementById('u683');

u683.style.cursor = 'pointer';
if (bIE) u683.attachEvent("onclick", Clicku683);
else u683.addEventListener("click", Clicku683, true);
function Clicku683(e)
{

if (true) {

	self.location.href="B2B电子渠道库存管理.html" + GetQuerystring();

}

}

var u211 = document.getElementById('u211');

var u393 = document.getElementById('u393');

var u565 = document.getElementById('u565');

var u381 = document.getElementById('u381');
gv_vAlignTable['u381'] = 'top';
var u233 = document.getElementById('u233');
gv_vAlignTable['u233'] = 'top';
var u371 = document.getElementById('u371');

var u686 = document.getElementById('u686');

u686.style.cursor = 'pointer';
if (bIE) u686.attachEvent("onclick", Clicku686);
else u686.addEventListener("click", Clicku686, true);
function Clicku686(e)
{

if (true) {

	self.location.href="B2B电子渠道审核管理.html" + GetQuerystring();

}

}

var u255 = document.getElementById('u255');
gv_vAlignTable['u255'] = 'top';
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

var u670 = document.getElementById('u670');
gv_vAlignTable['u670'] = 'center';
var u709 = document.getElementById('u709');
gv_vAlignTable['u709'] = 'center';
var u389 = document.getElementById('u389');

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

var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u273 = document.getElementById('u273');

var u163 = document.getElementById('u163');
gv_vAlignTable['u163'] = 'top';
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

var u545 = document.getElementById('u545');

var u580 = document.getElementById('u580');
gv_vAlignTable['u580'] = 'top';
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

var u633 = document.getElementById('u633');

var u252 = document.getElementById('u252');

var u735 = document.getElementById('u735');
gv_vAlignTable['u735'] = 'center';
var u484 = document.getElementById('u484');
gv_vAlignTable['u484'] = 'top';
var u508 = document.getElementById('u508');
gv_vAlignTable['u508'] = 'top';
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

var u582 = document.getElementById('u582');
gv_vAlignTable['u582'] = 'top';
var u332 = document.getElementById('u332');

var u569 = document.getElementById('u569');

var u429 = document.getElementById('u429');

var u634 = document.getElementById('u634');
gv_vAlignTable['u634'] = 'top';
var u500 = document.getElementById('u500');
gv_vAlignTable['u500'] = 'top';
var u341 = document.getElementById('u341');
gv_vAlignTable['u341'] = 'top';
var u629 = document.getElementById('u629');

u629.style.cursor = 'pointer';
if (bIE) u629.attachEvent("onclick", Clicku629);
else u629.addEventListener("click", Clicku629, true);
function Clicku629(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u350 = document.getElementById('u350');
gv_vAlignTable['u350'] = 'top';
var u203 = document.getElementById('u203');
gv_vAlignTable['u203'] = 'top';
var u723 = document.getElementById('u723');

var u241 = document.getElementById('u241');
gv_vAlignTable['u241'] = 'top';
var u584 = document.getElementById('u584');
gv_vAlignTable['u584'] = 'top';
var u636 = document.getElementById('u636');
gv_vAlignTable['u636'] = 'top';
var u658 = document.getElementById('u658');
gv_vAlignTable['u658'] = 'top';
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

var u361 = document.getElementById('u361');
gv_vAlignTable['u361'] = 'center';
var u600 = document.getElementById('u600');
gv_vAlignTable['u600'] = 'top';
var u317 = document.getElementById('u317');
gv_vAlignTable['u317'] = 'top';
var u358 = document.getElementById('u358');

var u455 = document.getElementById('u455');

var u404 = document.getElementById('u404');
gv_vAlignTable['u404'] = 'top';
var u398 = document.getElementById('u398');
gv_vAlignTable['u398'] = 'top';
var u678 = document.getElementById('u678');

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

var u653 = document.getElementById('u653');

var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'top';
var u587 = document.getElementById('u587');

var u321 = document.getElementById('u321');
gv_vAlignTable['u321'] = 'top';
var u711 = document.getElementById('u711');
gv_vAlignTable['u711'] = 'center';
var u81 = document.getElementById('u81');
gv_vAlignTable['u81'] = 'top';
var u285 = document.getElementById('u285');
gv_vAlignTable['u285'] = 'top';
var u422 = document.getElementById('u422');
gv_vAlignTable['u422'] = 'top';
var u406 = document.getElementById('u406');
gv_vAlignTable['u406'] = 'top';
var u67 = document.getElementById('u67');
gv_vAlignTable['u67'] = 'top';
var u592 = document.getElementById('u592');
gv_vAlignTable['u592'] = 'top';
var u133 = document.getElementById('u133');
gv_vAlignTable['u133'] = 'top';
var u719 = document.getElementById('u719');
gv_vAlignTable['u719'] = 'center';
var u479 = document.getElementById('u479');

var u113 = document.getElementById('u113');
gv_vAlignTable['u113'] = 'top';
var u440 = document.getElementById('u440');
gv_vAlignTable['u440'] = 'top';
var u121 = document.getElementById('u121');
gv_vAlignTable['u121'] = 'top';
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

var u760 = document.getElementById('u760');

u760.style.cursor = 'pointer';
if (bIE) u760.attachEvent("onclick", Clicku760);
else u760.addEventListener("click", Clicku760, true);
function Clicku760(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u31 = document.getElementById('u31');

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
gv_vAlignTable['u177'] = 'top';
var u471 = document.getElementById('u471');

var u301 = document.getElementById('u301');
gv_vAlignTable['u301'] = 'top';
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

var u363 = document.getElementById('u363');
gv_vAlignTable['u363'] = 'center';
var u159 = document.getElementById('u159');
gv_vAlignTable['u159'] = 'top';
var u666 = document.getElementById('u666');
gv_vAlignTable['u666'] = 'center';
var u507 = document.getElementById('u507');

var u385 = document.getElementById('u385');

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

	self.location.href="请购单审核管理.html" + GetQuerystring();

}

}

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

	self.location.href="B2B订单审批管理.html" + GetQuerystring();

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

var u682 = document.getElementById('u682');
gv_vAlignTable['u682'] = 'center';
var u223 = document.getElementById('u223');
gv_vAlignTable['u223'] = 'top';
var u695 = document.getElementById('u695');

u695.style.cursor = 'pointer';
if (bIE) u695.attachEvent("onclick", Clicku695);
else u695.addEventListener("click", Clicku695, true);
function Clicku695(e)
{

if (true) {

	self.location.href="B2B订单审批管理.html" + GetQuerystring();

}

}

var u380 = document.getElementById('u380');

var u394 = document.getElementById('u394');
gv_vAlignTable['u394'] = 'top';
var u556 = document.getElementById('u556');
gv_vAlignTable['u556'] = 'top';
var u715 = document.getElementById('u715');

var u548 = document.getElementById('u548');
gv_vAlignTable['u548'] = 'top';
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

	self.location.href="售后出库.html" + GetQuerystring();

}

}

var u388 = document.getElementById('u388');
gv_vAlignTable['u388'] = 'top';
var u538 = document.getElementById('u538');
gv_vAlignTable['u538'] = 'top';
var u405 = document.getElementById('u405');

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

var u272 = document.getElementById('u272');

var u542 = document.getElementById('u542');
gv_vAlignTable['u542'] = 'top';
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

var u53 = document.getElementById('u53');
gv_vAlignTable['u53'] = 'top';
var u250 = document.getElementById('u250');

var u602 = document.getElementById('u602');
gv_vAlignTable['u602'] = 'top';
var u667 = document.getElementById('u667');

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

var u473 = document.getElementById('u473');

var u326 = document.getElementById('u326');

var u643 = document.getElementById('u643');

var u496 = document.getElementById('u496');
gv_vAlignTable['u496'] = 'top';
var u492 = document.getElementById('u492');
gv_vAlignTable['u492'] = 'top';
var u544 = document.getElementById('u544');
gv_vAlignTable['u544'] = 'top';
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
gv_vAlignTable['u562'] = 'top';
var u628 = document.getElementById('u628');
gv_vAlignTable['u628'] = 'center';
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

var u189 = document.getElementById('u189');
gv_vAlignTable['u189'] = 'top';
var u339 = document.getElementById('u339');

var u647 = document.getElementById('u647');

var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
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

var u409 = document.getElementById('u409');

var u635 = document.getElementById('u635');

var u513 = document.getElementById('u513');

var u354 = document.getElementById('u354');

var u79 = document.getElementById('u79');

var u579 = document.getElementById('u579');

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

var u416 = document.getElementById('u416');
gv_vAlignTable['u416'] = 'top';
var u626 = document.getElementById('u626');
gv_vAlignTable['u626'] = 'center';
var u736 = document.getElementById('u736');

u736.style.cursor = 'pointer';
if (bIE) u736.attachEvent("onclick", Clicku736);
else u736.addEventListener("click", Clicku736, true);
function Clicku736(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u577 = document.getElementById('u577');

var u127 = document.getElementById('u127');
gv_vAlignTable['u127'] = 'top';
var u685 = document.getElementById('u685');
gv_vAlignTable['u685'] = 'center';
var u245 = document.getElementById('u245');
gv_vAlignTable['u245'] = 'top';
var u586 = document.getElementById('u586');
gv_vAlignTable['u586'] = 'top';
var u536 = document.getElementById('u536');
gv_vAlignTable['u536'] = 'top';
var u297 = document.getElementById('u297');
gv_vAlignTable['u297'] = 'top';
var u651 = document.getElementById('u651');

var u434 = document.getElementById('u434');
gv_vAlignTable['u434'] = 'top';
var u497 = document.getElementById('u497');

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

var u436 = document.getElementById('u436');
gv_vAlignTable['u436'] = 'top';
var u591 = document.getElementById('u591');

var u652 = document.getElementById('u652');
gv_vAlignTable['u652'] = 'top';
var u741 = document.getElementById('u741');
gv_vAlignTable['u741'] = 'center';
var u687 = document.getElementById('u687');

var u175 = document.getElementById('u175');

var u472 = document.getElementById('u472');
gv_vAlignTable['u472'] = 'top';
var u452 = document.getElementById('u452');
gv_vAlignTable['u452'] = 'top';
var u428 = document.getElementById('u428');
gv_vAlignTable['u428'] = 'top';
var u464 = document.getElementById('u464');
gv_vAlignTable['u464'] = 'top';
var u599 = document.getElementById('u599');

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

var u71 = document.getElementById('u71');
gv_vAlignTable['u71'] = 'top';
var u501 = document.getElementById('u501');

var u408 = document.getElementById('u408');
gv_vAlignTable['u408'] = 'top';
var u396 = document.getElementById('u396');
gv_vAlignTable['u396'] = 'top';
var u470 = document.getElementById('u470');
gv_vAlignTable['u470'] = 'top';
var u528 = document.getElementById('u528');
gv_vAlignTable['u528'] = 'top';
var u551 = document.getElementById('u551');

var u744 = document.getElementById('u744');

u744.style.cursor = 'pointer';
if (bIE) u744.attachEvent("onclick", Clicku744);
else u744.addEventListener("click", Clicku744, true);
function Clicku744(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u654 = document.getElementById('u654');
gv_vAlignTable['u654'] = 'top';
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

	self.location.href="应收_应付管理.html" + GetQuerystring();

}

}

var u581 = document.getElementById('u581');

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
gv_vAlignTable['u478'] = 'top';
var u495 = document.getElementById('u495');

var u646 = document.getElementById('u646');
gv_vAlignTable['u646'] = 'top';
var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u155 = document.getElementById('u155');

var u524 = document.getElementById('u524');
gv_vAlignTable['u524'] = 'top';
var u249 = document.getElementById('u249');

var u694 = document.getElementById('u694');
gv_vAlignTable['u694'] = 'center';
var u235 = document.getElementById('u235');
gv_vAlignTable['u235'] = 'top';
var u47 = document.getElementById('u47');
gv_vAlignTable['u47'] = 'top';
var u392 = document.getElementById('u392');
gv_vAlignTable['u392'] = 'top';
var u413 = document.getElementById('u413');

var u583 = document.getElementById('u583');

var u87 = document.getElementById('u87');
gv_vAlignTable['u87'] = 'top';
var u403 = document.getElementById('u403');

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

var u560 = document.getElementById('u560');
gv_vAlignTable['u560'] = 'top';
var u271 = document.getElementById('u271');
gv_vAlignTable['u271'] = 'top';
var u637 = document.getElementById('u637');

var u759 = document.getElementById('u759');
gv_vAlignTable['u759'] = 'center';
var u665 = document.getElementById('u665');

var u697 = document.getElementById('u697');
gv_vAlignTable['u697'] = 'center';
var u307 = document.getElementById('u307');
gv_vAlignTable['u307'] = 'top';
var u174 = document.getElementById('u174');

var u568 = document.getElementById('u568');
gv_vAlignTable['u568'] = 'top';
var u601 = document.getElementById('u601');

var u279 = document.getElementById('u279');
gv_vAlignTable['u279'] = 'top';
var u642 = document.getElementById('u642');
gv_vAlignTable['u642'] = 'top';
var u702 = document.getElementById('u702');
gv_vAlignTable['u702'] = 'top';
var u325 = document.getElementById('u325');
gv_vAlignTable['u325'] = 'top';
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

var u482 = document.getElementById('u482');
gv_vAlignTable['u482'] = 'top';
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

var u263 = document.getElementById('u263');
gv_vAlignTable['u263'] = 'top';
var u193 = document.getElementById('u193');
gv_vAlignTable['u193'] = 'top';
var u343 = document.getElementById('u343');
gv_vAlignTable['u343'] = 'top';
var u644 = document.getElementById('u644');
gv_vAlignTable['u644'] = 'top';
var u494 = document.getElementById('u494');
gv_vAlignTable['u494'] = 'top';
var u645 = document.getElementById('u645');

var u739 = document.getElementById('u739');
gv_vAlignTable['u739'] = 'center';
var u650 = document.getElementById('u650');
gv_vAlignTable['u650'] = 'top';
var u401 = document.getElementById('u401');

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

var u248 = document.getElementById('u248');

var u338 = document.getElementById('u338');

var u511 = document.getElementById('u511');

var u772 = document.getElementById('u772');

u772.style.cursor = 'pointer';
if (bIE) u772.attachEvent("onclick", Clicku772);
else u772.addEventListener("click", Clicku772, true);
function Clicku772(e)
{

if (true) {

	self.location.href="B2B签报修改.html" + GetQuerystring();

}

}

var u457 = document.getElementById('u457');

var u437 = document.getElementById('u437');

var u575 = document.getElementById('u575');

var u18 = document.getElementById('u18');

var u704 = document.getElementById('u704');

if (window.OnLoad) OnLoad();
