
var PageName = '账簿查询';
var PageId = 'p00c096a0940e4f24988921b4f38395a8'
var PageUrl = '账簿查询.html'
document.title = '账簿查询';

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

u402.style.cursor = 'pointer';
if (bIE) u402.attachEvent("onclick", Clicku402);
else u402.addEventListener("click", Clicku402, true);
function Clicku402(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u65 = document.getElementById('u65');

u65.style.cursor = 'pointer';
if (bIE) u65.attachEvent("onclick", Clicku65);
else u65.addEventListener("click", Clicku65, true);
function Clicku65(e)
{

if (true) {

	self.location.href="采购退货单管理.html" + GetQuerystring();

}

}

var u290 = document.getElementById('u290');

var u126 = document.getElementById('u126');
gv_vAlignTable['u126'] = 'top';
var u296 = document.getElementById('u296');
gv_vAlignTable['u296'] = 'top';
var u420 = document.getElementById('u420');

var u181 = document.getElementById('u181');

u181.style.cursor = 'pointer';
if (bIE) u181.attachEvent("onclick", Clicku181);
else u181.addEventListener("click", Clicku181, true);
function Clicku181(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u157 = document.getElementById('u157');

var u129 = document.getElementById('u129');

u129.style.cursor = 'pointer';
if (bIE) u129.attachEvent("onclick", Clicku129);
else u129.addEventListener("click", Clicku129, true);
function Clicku129(e)
{

if (true) {

	self.location.href="B2B出库管理.html" + GetQuerystring();

}

}

var u417 = document.getElementById('u417');

var u86 = document.getElementById('u86');
gv_vAlignTable['u86'] = 'top';
var u217 = document.getElementById('u217');

u217.style.cursor = 'pointer';
if (bIE) u217.attachEvent("onclick", Clicku217);
else u217.addEventListener("click", Clicku217, true);
function Clicku217(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u162 = document.getElementById('u162');
gv_vAlignTable['u162'] = 'top';
var u0 = document.getElementById('u0');

var u262 = document.getElementById('u262');
gv_vAlignTable['u262'] = 'top';
var u131 = document.getElementById('u131');

var u42 = document.getElementById('u42');
gv_vAlignTable['u42'] = 'top';
var u82 = document.getElementById('u82');

var u74 = document.getElementById('u74');
gv_vAlignTable['u74'] = 'top';
var u216 = document.getElementById('u216');
gv_vAlignTable['u216'] = 'top';
var u99 = document.getElementById('u99');

u99.style.cursor = 'pointer';
if (bIE) u99.attachEvent("onclick", Clicku99);
else u99.addEventListener("click", Clicku99, true);
function Clicku99(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u386 = document.getElementById('u386');
gv_vAlignTable['u386'] = 'center';
var u11 = document.getElementById('u11');

u11.style.cursor = 'pointer';
if (bIE) u11.attachEvent("onclick", Clicku11);
else u11.addEventListener("click", Clicku11, true);
function Clicku11(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u277 = document.getElementById('u277');

u277.style.cursor = 'pointer';
if (bIE) u277.attachEvent("onclick", Clicku277);
else u277.addEventListener("click", Clicku277, true);
function Clicku277(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u247 = document.getElementById('u247');

u247.style.cursor = 'pointer';
if (bIE) u247.attachEvent("onclick", Clicku247);
else u247.addEventListener("click", Clicku247, true);
function Clicku247(e)
{

if (true) {

	self.location.href="日志管理.html" + "";

}

}

var u68 = document.getElementById('u68');

var u134 = document.getElementById('u134');
gv_vAlignTable['u134'] = 'top';
var u242 = document.getElementById('u242');
gv_vAlignTable['u242'] = 'top';
var u323 = document.getElementById('u323');

u323.style.cursor = 'pointer';
if (bIE) u323.attachEvent("onclick", Clicku323);
else u323.addEventListener("click", Clicku323, true);
function Clicku323(e)
{

if (true) {

	self.location.href="售后出库.html" + GetQuerystring();

}

}

var u391 = document.getElementById('u391');

var u229 = document.getElementById('u229');

var u399 = document.getElementById('u399');

u399.style.cursor = 'pointer';
if (bIE) u399.attachEvent("onclick", Clicku399);
else u399.addEventListener("click", Clicku399, true);
function Clicku399(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u366 = document.getElementById('u366');
gv_vAlignTable['u366'] = 'center';
var u51 = document.getElementById('u51');

u51.style.cursor = 'pointer';
if (bIE) u51.attachEvent("onclick", Clicku51);
else u51.addEventListener("click", Clicku51, true);
function Clicku51(e)
{

if (true) {

	self.location.href="要货申请单管理.html" + GetQuerystring();

}

}

var u459 = document.getElementById('u459');
gv_vAlignTable['u459'] = 'center';
var u331 = document.getElementById('u331');

u331.style.cursor = 'pointer';
if (bIE) u331.attachEvent("onclick", Clicku331);
else u331.addEventListener("click", Clicku331, true);
function Clicku331(e)
{

if (true) {

	self.location.href="入库单审核.html" + GetQuerystring();

}

}

var u270 = document.getElementById('u270');
gv_vAlignTable['u270'] = 'top';
var u128 = document.getElementById('u128');
gv_vAlignTable['u128'] = 'top';
var u91 = document.getElementById('u91');

var u416 = document.getElementById('u416');

u416.style.cursor = 'pointer';
if (bIE) u416.attachEvent("onclick", Clicku416);
else u416.addEventListener("click", Clicku416, true);
function Clicku416(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u257 = document.getElementById('u257');

var u306 = document.getElementById('u306');

var u278 = document.getElementById('u278');
gv_vAlignTable['u278'] = 'top';
var u261 = document.getElementById('u261');

u261.style.cursor = 'pointer';
if (bIE) u261.attachEvent("onclick", Clicku261);
else u261.addEventListener("click", Clicku261, true);
function Clicku261(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u187 = document.getElementById('u187');

u187.style.cursor = 'pointer';
if (bIE) u187.attachEvent("onclick", Clicku187);
else u187.addEventListener("click", Clicku187, true);
function Clicku187(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u324 = document.getElementById('u324');
gv_vAlignTable['u324'] = 'top';
var u32 = document.getElementById('u32');
gv_vAlignTable['u32'] = 'top';
var u27 = document.getElementById('u27');

u27.style.cursor = 'pointer';
if (bIE) u27.attachEvent("onclick", Clicku27);
else u27.addEventListener("click", Clicku27, true);
function Clicku27(e)
{

if (true) {

	self.location.href="财务管理.html" + GetQuerystring();

}

}

var u192 = document.getElementById('u192');
gv_vAlignTable['u192'] = 'top';
var u319 = document.getElementById('u319');

u319.style.cursor = 'pointer';
if (bIE) u319.attachEvent("onclick", Clicku319);
else u319.addEventListener("click", Clicku319, true);
function Clicku319(e)
{

if (true) {

	self.location.href="采购退库.html" + GetQuerystring();

}

}

var u108 = document.getElementById('u108');

var u350 = document.getElementById('u350');
gv_vAlignTable['u350'] = 'top';
var u60 = document.getElementById('u60');
gv_vAlignTable['u60'] = 'top';
var u59 = document.getElementById('u59');

u59.style.cursor = 'pointer';
if (bIE) u59.attachEvent("onclick", Clicku59);
else u59.addEventListener("click", Clicku59, true);
function Clicku59(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u373 = document.getElementById('u373');

u373.style.cursor = 'pointer';
if (bIE) u373.attachEvent("onclick", Clicku373);
else u373.addEventListener("click", Clicku373, true);
function Clicku373(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u103 = document.getElementById('u103');

u103.style.cursor = 'pointer';
if (bIE) u103.attachEvent("onclick", Clicku103);
else u103.addEventListener("click", Clicku103, true);
function Clicku103(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u9 = document.getElementById('u9');

var u107 = document.getElementById('u107');

var u368 = document.getElementById('u368');

var u401 = document.getElementById('u401');
gv_vAlignTable['u401'] = 'center';
var u365 = document.getElementById('u365');

var u330 = document.getElementById('u330');

var u314 = document.getElementById('u314');
gv_vAlignTable['u314'] = 'top';
var u125 = document.getElementById('u125');

u125.style.cursor = 'pointer';
if (bIE) u125.attachEvent("onclick", Clicku125);
else u125.addEventListener("click", Clicku125, true);
function Clicku125(e)
{

if (true) {

	self.location.href="B2B订单管理.html" + GetQuerystring();

}

}

var u36 = document.getElementById('u36');
gv_vAlignTable['u36'] = 'top';
var u295 = document.getElementById('u295');

u295.style.cursor = 'pointer';
if (bIE) u295.attachEvent("onclick", Clicku295);
else u295.addEventListener("click", Clicku295, true);
function Clicku295(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u415 = document.getElementById('u415');

var u256 = document.getElementById('u256');
gv_vAlignTable['u256'] = 'top';
var u156 = document.getElementById('u156');
gv_vAlignTable['u156'] = 'top';
var u454 = document.getElementById('u454');

u454.style.cursor = 'pointer';
if (bIE) u454.attachEvent("onclick", Clicku454);
else u454.addEventListener("click", Clicku454, true);
function Clicku454(e)
{

if (true) {

	self.location.href="总账管理.html" + GetQuerystring();

}

}

var u260 = document.getElementById('u260');

var u450 = document.getElementById('u450');
gv_vAlignTable['u450'] = 'center';
var u161 = document.getElementById('u161');

u161.style.cursor = 'pointer';
if (bIE) u161.attachEvent("onclick", Clicku161);
else u161.addEventListener("click", Clicku161, true);
function Clicku161(e)
{

if (true) {

	self.location.href="应收_应付管理.html" + GetQuerystring();

}

}

var u345 = document.getElementById('u345');

u345.style.cursor = 'pointer';
if (bIE) u345.attachEvent("onclick", Clicku345);
else u345.addEventListener("click", Clicku345, true);
function Clicku345(e)
{

if (true) {

	self.location.href="销售入库.html" + GetQuerystring();

}

}

var u474 = document.getElementById('u474');

u474.style.cursor = 'pointer';
if (bIE) u474.attachEvent("onclick", Clicku474);
else u474.addEventListener("click", Clicku474, true);
function Clicku474(e)
{

if (true) {

	self.location.href="摘要汇总表查询.html" + GetQuerystring();

}

}
gv_vAlignTable['u474'] = 'top';
var u439 = document.getElementById('u439');
gv_vAlignTable['u439'] = 'center';
var u349 = document.getElementById('u349');

u349.style.cursor = 'pointer';
if (bIE) u349.attachEvent("onclick", Clicku349);
else u349.addEventListener("click", Clicku349, true);
function Clicku349(e)
{

if (true) {

	self.location.href="还机入库.html" + GetQuerystring();

}

}

var u231 = document.getElementById('u231');

u231.style.cursor = 'pointer';
if (bIE) u231.attachEvent("onclick", Clicku231);
else u231.addEventListener("click", Clicku231, true);
function Clicku231(e)
{

if (true) {

	self.location.href="用户管理.html" + "";

}

}

var u169 = document.getElementById('u169');

var u215 = document.getElementById('u215');

u215.style.cursor = 'pointer';
if (bIE) u215.attachEvent("onclick", Clicku215);
else u215.addEventListener("click", Clicku215, true);
function Clicku215(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u137 = document.getElementById('u137');

u137.style.cursor = 'pointer';
if (bIE) u137.attachEvent("onclick", Clicku137);
else u137.addEventListener("click", Clicku137, true);
function Clicku137(e)
{

if (true) {

	self.location.href="手工充值审核.html" + GetQuerystring();

}

}

var u283 = document.getElementById('u283');

u283.style.cursor = 'pointer';
if (bIE) u283.attachEvent("onclick", Clicku283);
else u283.addEventListener("click", Clicku283, true);
function Clicku283(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u180 = document.getElementById('u180');
gv_vAlignTable['u180'] = 'top';
var u369 = document.getElementById('u369');
gv_vAlignTable['u369'] = 'center';
var u85 = document.getElementById('u85');

u85.style.cursor = 'pointer';
if (bIE) u85.attachEvent("onclick", Clicku85);
else u85.addEventListener("click", Clicku85, true);
function Clicku85(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u77 = document.getElementById('u77');

u77.style.cursor = 'pointer';
if (bIE) u77.attachEvent("onclick", Clicku77);
else u77.addEventListener("click", Clicku77, true);
function Clicku77(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u300 = document.getElementById('u300');
gv_vAlignTable['u300'] = 'top';
var u141 = document.getElementById('u141');

u141.style.cursor = 'pointer';
if (bIE) u141.attachEvent("onclick", Clicku141);
else u141.addEventListener("click", Clicku141, true);
function Clicku141(e)
{

if (true) {

	self.location.href="订单退款审核.html" + GetQuerystring();

}

}

var u20 = document.getElementById('u20');
gv_vAlignTable['u20'] = 'top';
var u226 = document.getElementById('u226');
gv_vAlignTable['u226'] = 'top';
var u364 = document.getElementById('u364');
gv_vAlignTable['u364'] = 'center';
var u423 = document.getElementById('u423');

var u251 = document.getElementById('u251');

var u109 = document.getElementById('u109');

u109.style.cursor = 'pointer';
if (bIE) u109.attachEvent("onclick", Clicku109);
else u109.addEventListener("click", Clicku109, true);
function Clicku109(e)
{

if (true) {

	self.location.href="B2B签报管理.html" + GetQuerystring();

}

}

var u414 = document.getElementById('u414');
gv_vAlignTable['u414'] = 'center';
var u183 = document.getElementById('u183');

u183.style.cursor = 'pointer';
if (bIE) u183.attachEvent("onclick", Clicku183);
else u183.addEventListener("click", Clicku183, true);
function Clicku183(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u424 = document.getElementById('u424');

var u259 = document.getElementById('u259');

var u13 = document.getElementById('u13');

u13.style.cursor = 'pointer';
if (bIE) u13.attachEvent("onclick", Clicku13);
else u13.addEventListener("click", Clicku13, true);
function Clicku13(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u466 = document.getElementById('u466');

var u39 = document.getElementById('u39');

u39.style.cursor = 'pointer';
if (bIE) u39.attachEvent("onclick", Clicku39);
else u39.addEventListener("click", Clicku39, true);
function Clicku39(e)
{

if (true) {

	self.location.href="销售报表查询.html" + GetQuerystring();

}

}

var u425 = document.getElementById('u425');
gv_vAlignTable['u425'] = 'center';
var u54 = document.getElementById('u54');
gv_vAlignTable['u54'] = 'top';
var u387 = document.getElementById('u387');

var u344 = document.getElementById('u344');
gv_vAlignTable['u344'] = 'top';
var u94 = document.getElementById('u94');
gv_vAlignTable['u94'] = 'top';
var u186 = document.getElementById('u186');
gv_vAlignTable['u186'] = 'top';
var u336 = document.getElementById('u336');

var u458 = document.getElementById('u458');

var u210 = document.getElementById('u210');
gv_vAlignTable['u210'] = 'top';
var u318 = document.getElementById('u318');

var u191 = document.getElementById('u191');

u191.style.cursor = 'pointer';
if (bIE) u191.attachEvent("onclick", Clicku191);
else u191.addEventListener("click", Clicku191, true);
function Clicku191(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u136 = document.getElementById('u136');
gv_vAlignTable['u136'] = 'top';
var u367 = document.getElementById('u367');
gv_vAlignTable['u367'] = 'top';
var u101 = document.getElementById('u101');

u101.style.cursor = 'pointer';
if (bIE) u101.attachEvent("onclick", Clicku101);
else u101.addEventListener("click", Clicku101, true);
function Clicku101(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u199 = document.getElementById('u199');

var u31 = document.getElementById('u31');

u31.style.cursor = 'pointer';
if (bIE) u31.attachEvent("onclick", Clicku31);
else u31.addEventListener("click", Clicku31, true);
function Clicku31(e)
{

if (true) {

	self.location.href="统计查询.html" + GetQuerystring();

}

}

var u140 = document.getElementById('u140');
gv_vAlignTable['u140'] = 'top';
var u48 = document.getElementById('u48');
gv_vAlignTable['u48'] = 'top';
var u225 = document.getElementById('u225');

u225.style.cursor = 'pointer';
if (bIE) u225.attachEvent("onclick", Clicku225);
else u225.addEventListener("click", Clicku225, true);
function Clicku225(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u63 = document.getElementById('u63');

u63.style.cursor = 'pointer';
if (bIE) u63.attachEvent("onclick", Clicku63);
else u63.addEventListener("click", Clicku63, true);
function Clicku63(e)
{

if (true) {

	self.location.href="采购结算单审核管理.html" + GetQuerystring();

}

}

var u106 = document.getElementById('u106');
gv_vAlignTable['u106'] = 'top';
var u88 = document.getElementById('u88');
gv_vAlignTable['u88'] = 'top';
var u400 = document.getElementById('u400');

var u111 = document.getElementById('u111');

u111.style.cursor = 'pointer';
if (bIE) u111.attachEvent("onclick", Clicku111);
else u111.addEventListener("click", Clicku111, true);
function Clicku111(e)
{

if (true) {

	self.location.href="B2B返利管理.html" + GetQuerystring();

}

}

var u294 = document.getElementById('u294');
gv_vAlignTable['u294'] = 'top';
var u408 = document.getElementById('u408');

u408.style.cursor = 'pointer';
if (bIE) u408.attachEvent("onclick", Clicku408);
else u408.addEventListener("click", Clicku408, true);
function Clicku408(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u120 = document.getElementById('u120');
gv_vAlignTable['u120'] = 'top';
var u119 = document.getElementById('u119');

u119.style.cursor = 'pointer';
if (bIE) u119.attachEvent("onclick", Clicku119);
else u119.addEventListener("click", Clicku119, true);
function Clicku119(e)
{

if (true) {

	self.location.href="B2B电子渠道库存管理.html" + GetQuerystring();

}

}

var u205 = document.getElementById('u205');

u205.style.cursor = 'pointer';
if (bIE) u205.attachEvent("onclick", Clicku205);
else u205.addEventListener("click", Clicku205, true);
function Clicku205(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u302 = document.getElementById('u302');
gv_vAlignTable['u302'] = 'top';
var u289 = document.getElementById('u289');

var u40 = document.getElementById('u40');
gv_vAlignTable['u40'] = 'top';
var u3 = document.getElementById('u3');

var u390 = document.getElementById('u390');

u390.style.cursor = 'pointer';
if (bIE) u390.attachEvent("onclick", Clicku390);
else u390.addEventListener("click", Clicku390, true);
function Clicku390(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u160 = document.getElementById('u160');
gv_vAlignTable['u160'] = 'top';
var u72 = document.getElementById('u72');
gv_vAlignTable['u72'] = 'top';
var u227 = document.getElementById('u227');

u227.style.cursor = 'pointer';
if (bIE) u227.attachEvent("onclick", Clicku227);
else u227.addEventListener("click", Clicku227, true);
function Clicku227(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u467 = document.getElementById('u467');

u467.style.cursor = 'pointer';
if (bIE) u467.attachEvent("onclick", Clicku467);
else u467.addEventListener("click", Clicku467, true);
function Clicku467(e)
{

if (true) {

	self.location.href="总账查询.html" + GetQuerystring();

}

}
gv_vAlignTable['u467'] = 'top';
var u135 = document.getElementById('u135');

u135.style.cursor = 'pointer';
if (bIE) u135.attachEvent("onclick", Clicku135);
else u135.addEventListener("click", Clicku135, true);
function Clicku135(e)
{

if (true) {

	self.location.href="手工充值管理.html" + GetQuerystring();

}

}

var u281 = document.getElementById('u281');

u281.style.cursor = 'pointer';
if (bIE) u281.attachEvent("onclick", Clicku281);
else u281.addEventListener("click", Clicku281, true);
function Clicku281(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u168 = document.getElementById('u168');
gv_vAlignTable['u168'] = 'top';
var u201 = document.getElementById('u201');

u201.style.cursor = 'pointer';
if (bIE) u201.attachEvent("onclick", Clicku201);
else u201.addEventListener("click", Clicku201, true);
function Clicku201(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u96 = document.getElementById('u96');
gv_vAlignTable['u96'] = 'top';
var u384 = document.getElementById('u384');
gv_vAlignTable['u384'] = 'center';
var u16 = document.getElementById('u16');
gv_vAlignTable['u16'] = 'top';
var u224 = document.getElementById('u224');
gv_vAlignTable['u224'] = 'top';
var u362 = document.getElementById('u362');
gv_vAlignTable['u362'] = 'center';
var u232 = document.getElementById('u232');
gv_vAlignTable['u232'] = 'top';
var u12 = document.getElementById('u12');
gv_vAlignTable['u12'] = 'top';
var u447 = document.getElementById('u447');

var u144 = document.getElementById('u144');
gv_vAlignTable['u144'] = 'top';
var u115 = document.getElementById('u115');

u115.style.cursor = 'pointer';
if (bIE) u115.attachEvent("onclick", Clicku115);
else u115.addEventListener("click", Clicku115, true);
function Clicku115(e)
{

if (true) {

	self.location.href="B2B价保管理.html" + GetQuerystring();

}

}

var u333 = document.getElementById('u333');

u333.style.cursor = 'pointer';
if (bIE) u333.attachEvent("onclick", Clicku333);
else u333.addEventListener("click", Clicku333, true);
function Clicku333(e)
{

if (true) {

	self.location.href="出库单审核.html" + GetQuerystring();

}

}

var u209 = document.getElementById('u209');

u209.style.cursor = 'pointer';
if (bIE) u209.attachEvent("onclick", Clicku209);
else u209.addEventListener("click", Clicku209, true);
function Clicku209(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u276 = document.getElementById('u276');

var u313 = document.getElementById('u313');

u313.style.cursor = 'pointer';
if (bIE) u313.attachEvent("onclick", Clicku313);
else u313.addEventListener("click", Clicku313, true);
function Clicku313(e)
{

if (true) {

	self.location.href="库存盘点_1.html" + GetQuerystring();

}

}

var u154 = document.getElementById('u154');
gv_vAlignTable['u154'] = 'top';
var u451 = document.getElementById('u451');

u451.style.cursor = 'pointer';
if (bIE) u451.attachEvent("onclick", Clicku451);
else u451.addEventListener("click", Clicku451, true);
function Clicku451(e)
{

if (true) {

	self.location.href="应收_应付管理.html" + GetQuerystring();

}

}

var u334 = document.getElementById('u334');
gv_vAlignTable['u334'] = 'top';
var u282 = document.getElementById('u282');
gv_vAlignTable['u282'] = 'top';
var u377 = document.getElementById('u377');

var u258 = document.getElementById('u258');
gv_vAlignTable['u258'] = 'top';
var u335 = document.getElementById('u335');

var u342 = document.getElementById('u342');

var u304 = document.getElementById('u304');
gv_vAlignTable['u304'] = 'top';
var u139 = document.getElementById('u139');

u139.style.cursor = 'pointer';
if (bIE) u139.attachEvent("onclick", Clicku139);
else u139.addEventListener("click", Clicku139, true);
function Clicku139(e)
{

if (true) {

	self.location.href="订单退款管理.html" + GetQuerystring();

}

}

var u25 = document.getElementById('u25');

u25.style.cursor = 'pointer';
if (bIE) u25.attachEvent("onclick", Clicku25);
else u25.addEventListener("click", Clicku25, true);
function Clicku25(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u284 = document.getElementById('u284');
gv_vAlignTable['u284'] = 'top';
var u179 = document.getElementById('u179');

u179.style.cursor = 'pointer';
if (bIE) u179.attachEvent("onclick", Clicku179);
else u179.addEventListener("click", Clicku179, true);
function Clicku179(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u185 = document.getElementById('u185');

u185.style.cursor = 'pointer';
if (bIE) u185.attachEvent("onclick", Clicku185);
else u185.addEventListener("click", Clicku185, true);
function Clicku185(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u322 = document.getElementById('u322');
gv_vAlignTable['u322'] = 'top';
var u57 = document.getElementById('u57');

u57.style.cursor = 'pointer';
if (bIE) u57.attachEvent("onclick", Clicku57);
else u57.addEventListener("click", Clicku57, true);
function Clicku57(e)
{

if (true) {

	self.location.href="采购结算单管理.html" + GetQuerystring();

}

}

var u280 = document.getElementById('u280');
gv_vAlignTable['u280'] = 'top';
var u431 = document.getElementById('u431');

u431.style.cursor = 'pointer';
if (bIE) u431.attachEvent("onclick", Clicku431);
else u431.addEventListener("click", Clicku431, true);
function Clicku431(e)
{

if (true) {

	self.location.href="凭证管理.html" + GetQuerystring();

}

}

var u228 = document.getElementById('u228');
gv_vAlignTable['u228'] = 'top';
var u97 = document.getElementById('u97');

u97.style.cursor = 'pointer';
if (bIE) u97.attachEvent("onclick", Clicku97);
else u97.addEventListener("click", Clicku97, true);
function Clicku97(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u190 = document.getElementById('u190');
gv_vAlignTable['u190'] = 'top';
var u353 = document.getElementById('u353');
gv_vAlignTable['u353'] = 'top';
var u37 = document.getElementById('u37');

u37.style.cursor = 'pointer';
if (bIE) u37.attachEvent("onclick", Clicku37);
else u37.addEventListener("click", Clicku37, true);
function Clicku37(e)
{

if (true) {

	self.location.href="库存报表查询.html" + GetQuerystring();

}

}

var u198 = document.getElementById('u198');
gv_vAlignTable['u198'] = 'top';
var u348 = document.getElementById('u348');
gv_vAlignTable['u348'] = 'top';
var u253 = document.getElementById('u253');

var u407 = document.getElementById('u407');
gv_vAlignTable['u407'] = 'center';
var u114 = document.getElementById('u114');
gv_vAlignTable['u114'] = 'top';
var u19 = document.getElementById('u19');

var u34 = document.getElementById('u34');

var u312 = document.getElementById('u312');
gv_vAlignTable['u312'] = 'top';
var u153 = document.getElementById('u153');

u153.style.cursor = 'pointer';
if (bIE) u153.attachEvent("onclick", Clicku153);
else u153.addEventListener("click", Clicku153, true);
function Clicku153(e)
{

if (true) {

	self.location.href="发货状态管理.html" + GetQuerystring();

}

}

var u412 = document.getElementById('u412');
gv_vAlignTable['u412'] = 'center';
var u69 = document.getElementById('u69');

var u66 = document.getElementById('u66');
gv_vAlignTable['u66'] = 'top';
var u123 = document.getElementById('u123');

u123.style.cursor = 'pointer';
if (bIE) u123.attachEvent("onclick", Clicku123);
else u123.addEventListener("click", Clicku123, true);
function Clicku123(e)
{

if (true) {

	self.location.href="B2B预存款管理.html" + GetQuerystring();

}

}

var u376 = document.getElementById('u376');

u376.style.cursor = 'pointer';
if (bIE) u376.attachEvent("onclick", Clicku376);
else u376.addEventListener("click", Clicku376, true);
function Clicku376(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u293 = document.getElementById('u293');

u293.style.cursor = 'pointer';
if (bIE) u293.attachEvent("onclick", Clicku293);
else u293.addEventListener("click", Clicku293, true);
function Clicku293(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u430 = document.getElementById('u430');
gv_vAlignTable['u430'] = 'center';
var u138 = document.getElementById('u138');
gv_vAlignTable['u138'] = 'top';
var u118 = document.getElementById('u118');
gv_vAlignTable['u118'] = 'top';
var u167 = document.getElementById('u167');

u167.style.cursor = 'pointer';
if (bIE) u167.attachEvent("onclick", Clicku167);
else u167.addEventListener("click", Clicku167, true);
function Clicku167(e)
{

if (true) {

	self.location.href="财务报表管理.html" + GetQuerystring();

}

}

var u288 = document.getElementById('u288');
gv_vAlignTable['u288'] = 'top';
var u438 = document.getElementById('u438');

var u465 = document.getElementById('u465');

var u172 = document.getElementById('u172');
gv_vAlignTable['u172'] = 'top';
var u28 = document.getElementById('u28');
gv_vAlignTable['u28'] = 'top';
var u356 = document.getElementById('u356');
gv_vAlignTable['u356'] = 'center';
var u43 = document.getElementById('u43');

var u75 = document.getElementById('u75');

var u83 = document.getElementById('u83');

u83.style.cursor = 'pointer';
if (bIE) u83.attachEvent("onclick", Clicku83);
else u83.addEventListener("click", Clicku83, true);
function Clicku83(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u222 = document.getElementById('u222');
gv_vAlignTable['u222'] = 'top';
var u360 = document.getElementById('u360');
gv_vAlignTable['u360'] = 'center';
var u200 = document.getElementById('u200');

var u383 = document.getElementById('u383');

var u445 = document.getElementById('u445');

var u208 = document.getElementById('u208');
gv_vAlignTable['u208'] = 'top';
var u311 = document.getElementById('u311');

var u152 = document.getElementById('u152');
gv_vAlignTable['u152'] = 'top';
var u432 = document.getElementById('u432');

var u80 = document.getElementById('u80');
gv_vAlignTable['u80'] = 'top';
var u275 = document.getElementById('u275');

var u237 = document.getElementById('u237');

u237.style.cursor = 'pointer';
if (bIE) u237.attachEvent("onclick", Clicku237);
else u237.addEventListener("click", Clicku237, true);
function Clicku237(e)
{

if (true) {

	self.location.href="IP访问限制管理.html" + "";

}

}

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u202 = document.getElementById('u202');
gv_vAlignTable['u202'] = 'top';
var u52 = document.getElementById('u52');
gv_vAlignTable['u52'] = 'top';
var u469 = document.getElementById('u469');

u469.style.cursor = 'pointer';
if (bIE) u469.attachEvent("onclick", Clicku469);
else u469.addEventListener("click", Clicku469, true);
function Clicku469(e)
{

if (true) {

	self.location.href="科目余额明细账查询.html" + GetQuerystring();

}

}
gv_vAlignTable['u469'] = 'top';
var u92 = document.getElementById('u92');

var u434 = document.getElementById('u434');

u434.style.cursor = 'pointer';
if (bIE) u434.attachEvent("onclick", Clicku434);
else u434.addEventListener("click", Clicku434, true);
function Clicku434(e)
{

if (true) {

	self.location.href="Resources/reload.html#" + encodeURI(PageUrl + GetQuerystring());

}

}

var u316 = document.getElementById('u316');
gv_vAlignTable['u316'] = 'top';
var u30 = document.getElementById('u30');
gv_vAlignTable['u30'] = 'top';
var u246 = document.getElementById('u246');
gv_vAlignTable['u246'] = 'top';
var u435 = document.getElementById('u435');

var u197 = document.getElementById('u197');

u197.style.cursor = 'pointer';
if (bIE) u197.attachEvent("onclick", Clicku197);
else u197.addEventListener("click", Clicku197, true);
function Clicku197(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u347 = document.getElementById('u347');

u347.style.cursor = 'pointer';
if (bIE) u347.attachEvent("onclick", Clicku347);
else u347.addEventListener("click", Clicku347, true);
function Clicku347(e)
{

if (true) {

	self.location.href="售后入库.html" + GetQuerystring();

}

}

var u195 = document.getElementById('u195');

u195.style.cursor = 'pointer';
if (bIE) u195.attachEvent("onclick", Clicku195);
else u195.addEventListener("click", Clicku195, true);
function Clicku195(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u355 = document.getElementById('u355');

var u449 = document.getElementById('u449');

var u23 = document.getElementById('u23');

var u221 = document.getElementById('u221');

u221.style.cursor = 'pointer';
if (bIE) u221.attachEvent("onclick", Clicku221);
else u221.addEventListener("click", Clicku221, true);
function Clicku221(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u352 = document.getElementById('u352');
gv_vAlignTable['u352'] = 'top';
var u61 = document.getElementById('u61');

u61.style.cursor = 'pointer';
if (bIE) u61.attachEvent("onclick", Clicku61);
else u61.addEventListener("click", Clicku61, true);
function Clicku61(e)
{

if (true) {

	self.location.href="采购退货计划单管理.html" + GetQuerystring();

}

}

var u444 = document.getElementById('u444');
gv_vAlignTable['u444'] = 'center';
var u370 = document.getElementById('u370');

var u379 = document.getElementById('u379');

u379.style.cursor = 'pointer';
if (bIE) u379.attachEvent("onclick", Clicku379);
else u379.addEventListener("click", Clicku379, true);
function Clicku379(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u78 = document.getElementById('u78');
gv_vAlignTable['u78'] = 'top';
var u310 = document.getElementById('u310');
gv_vAlignTable['u310'] = 'top';
var u151 = document.getElementById('u151');

u151.style.cursor = 'pointer';
if (bIE) u151.attachEvent("onclick", Clicku151);
else u151.addEventListener("click", Clicku151, true);
function Clicku151(e)
{

if (true) {

	self.location.href="发货单管理.html" + GetQuerystring();

}

}

var u117 = document.getElementById('u117');

u117.style.cursor = 'pointer';
if (bIE) u117.attachEvent("onclick", Clicku117);
else u117.addEventListener("click", Clicku117, true);
function Clicku117(e)
{

if (true) {

	self.location.href="B2B价保审核管理.html" + GetQuerystring();

}

}

var u378 = document.getElementById('u378');
gv_vAlignTable['u378'] = 'center';
var u21 = document.getElementById('u21');

var u236 = document.getElementById('u236');
gv_vAlignTable['u236'] = 'top';
var u374 = document.getElementById('u374');

var u287 = document.getElementById('u287');

u287.style.cursor = 'pointer';
if (bIE) u287.attachEvent("onclick", Clicku287);
else u287.addEventListener("click", Clicku287, true);
function Clicku287(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u468 = document.getElementById('u468');

u468.style.cursor = 'pointer';
if (bIE) u468.attachEvent("onclick", Clicku468);
else u468.addEventListener("click", Clicku468, true);
function Clicku468(e)
{

if (true) {

	self.location.href="科目余额表查询.html" + GetQuerystring();

}

}
gv_vAlignTable['u468'] = 'top';
var u411 = document.getElementById('u411');

var u122 = document.getElementById('u122');
gv_vAlignTable['u122'] = 'top';
var u240 = document.getElementById('u240');
gv_vAlignTable['u240'] = 'top';
var u292 = document.getElementById('u292');
gv_vAlignTable['u292'] = 'top';
var u419 = document.getElementById('u419');

var u463 = document.getElementById('u463');

var u166 = document.getElementById('u166');
gv_vAlignTable['u166'] = 'top';
var u70 = document.getElementById('u70');
gv_vAlignTable['u70'] = 'top';
var u6 = document.getElementById('u6');
gv_vAlignTable['u6'] = 'top';
var u397 = document.getElementById('u397');

var u460 = document.getElementById('u460');

u460.style.cursor = 'pointer';
if (bIE) u460.attachEvent("onclick", Clicku460);
else u460.addEventListener("click", Clicku460, true);
function Clicku460(e)
{

if (true) {

	self.location.href="财务报表管理.html" + GetQuerystring();

}

}

var u171 = document.getElementById('u171');

var u207 = document.getElementById('u207');

u207.style.cursor = 'pointer';
if (bIE) u207.attachEvent("onclick", Clicku207);
else u207.addEventListener("click", Clicku207, true);
function Clicku207(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u220 = document.getElementById('u220');
gv_vAlignTable['u220'] = 'top';
var u14 = document.getElementById('u14');
gv_vAlignTable['u14'] = 'top';
var u305 = document.getElementById('u305');

var u146 = document.getElementById('u146');
gv_vAlignTable['u146'] = 'top';
var u443 = document.getElementById('u443');

var u427 = document.getElementById('u427');
gv_vAlignTable['u427'] = 'center';
var u212 = document.getElementById('u212');
gv_vAlignTable['u212'] = 'top';
var u46 = document.getElementById('u46');
gv_vAlignTable['u46'] = 'top';
var u382 = document.getElementById('u382');

u382.style.cursor = 'pointer';
if (bIE) u382.attachEvent("onclick", Clicku382);
else u382.addEventListener("click", Clicku382, true);
function Clicku382(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u150 = document.getElementById('u150');
gv_vAlignTable['u150'] = 'top';
var u243 = document.getElementById('u243');

u243.style.cursor = 'pointer';
if (bIE) u243.attachEvent("onclick", Clicku243);
else u243.addEventListener("click", Clicku243, true);
function Clicku243(e)
{

if (true) {

	self.location.href="组织结构管理.html" + "";

}

}

var u329 = document.getElementById('u329');

var u274 = document.getElementById('u274');
gv_vAlignTable['u274'] = 'top';
var u165 = document.getElementById('u165');

u165.style.cursor = 'pointer';
if (bIE) u165.attachEvent("onclick", Clicku165);
else u165.addEventListener("click", Clicku165, true);
function Clicku165(e)
{

if (true) {

	self.location.href="成本核算管理.html" + GetQuerystring();

}

}

var u462 = document.getElementById('u462');
gv_vAlignTable['u462'] = 'center';
var u269 = document.getElementById('u269');

u269.style.cursor = 'pointer';
if (bIE) u269.attachEvent("onclick", Clicku269);
else u269.addEventListener("click", Clicku269, true);
function Clicku269(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u130 = document.getElementById('u130');
gv_vAlignTable['u130'] = 'top';
var u315 = document.getElementById('u315');

var u55 = document.getElementById('u55');

u55.style.cursor = 'pointer';
if (bIE) u55.attachEvent("onclick", Clicku55);
else u55.addEventListener("click", Clicku55, true);
function Clicku55(e)
{

if (true) {

	self.location.href="采购单管理.html" + GetQuerystring();

}

}

var u309 = document.getElementById('u309');

u309.style.cursor = 'pointer';
if (bIE) u309.attachEvent("onclick", Clicku309);
else u309.addEventListener("click", Clicku309, true);
function Clicku309(e)
{

if (true) {

	self.location.href="出库管理.html" + GetQuerystring();

}

}

var u95 = document.getElementById('u95');

u95.style.cursor = 'pointer';
if (bIE) u95.attachEvent("onclick", Clicku95);
else u95.addEventListener("click", Clicku95, true);
function Clicku95(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u196 = document.getElementById('u196');
gv_vAlignTable['u196'] = 'top';
var u254 = document.getElementById('u254');
gv_vAlignTable['u254'] = 'top';
var u346 = document.getElementById('u346');
gv_vAlignTable['u346'] = 'top';
var u337 = document.getElementById('u337');

u337.style.cursor = 'pointer';
if (bIE) u337.attachEvent("onclick", Clicku337);
else u337.addEventListener("click", Clicku337, true);
function Clicku337(e)
{

if (true) {

	self.location.href="移库管理_1.html" + GetQuerystring();

}

}

var u145 = document.getElementById('u145');

u145.style.cursor = 'pointer';
if (bIE) u145.attachEvent("onclick", Clicku145);
else u145.addEventListener("click", Clicku145, true);
function Clicku145(e)
{

if (true) {

	self.location.href="佣金结算审核.html" + GetQuerystring();

}

}

var u442 = document.getElementById('u442');
gv_vAlignTable['u442'] = 'center';
var u351 = document.getElementById('u351');

u351.style.cursor = 'pointer';
if (bIE) u351.attachEvent("onclick", Clicku351);
else u351.addEventListener("click", Clicku351, true);
function Clicku351(e)
{

if (true) {

	self.location.href="其他入库[如活动赠品].html" + GetQuerystring();

}

}

var u239 = document.getElementById('u239');

u239.style.cursor = 'pointer';
if (bIE) u239.attachEvent("onclick", Clicku239);
else u239.addEventListener("click", Clicku239, true);
function Clicku239(e)
{

if (true) {

	self.location.href="合同类别管理.html" + "";

}

}

var u104 = document.getElementById('u104');
gv_vAlignTable['u104'] = 'top';
var u359 = document.getElementById('u359');

var u375 = document.getElementById('u375');
gv_vAlignTable['u375'] = 'center';
var u234 = document.getElementById('u234');
gv_vAlignTable['u234'] = 'top';
var u372 = document.getElementById('u372');

var u64 = document.getElementById('u64');
gv_vAlignTable['u64'] = 'top';
var u328 = document.getElementById('u328');
gv_vAlignTable['u328'] = 'top';
var u116 = document.getElementById('u116');
gv_vAlignTable['u116'] = 'top';
var u452 = document.getElementById('u452');

var u89 = document.getElementById('u89');

u89.style.cursor = 'pointer';
if (bIE) u89.attachEvent("onclick", Clicku89);
else u89.addEventListener("click", Clicku89, true);
function Clicku89(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u100 = document.getElementById('u100');
gv_vAlignTable['u100'] = 'top';
var u286 = document.getElementById('u286');
gv_vAlignTable['u286'] = 'top';
var u219 = document.getElementById('u219');

u219.style.cursor = 'pointer';
if (bIE) u219.attachEvent("onclick", Clicku219);
else u219.addEventListener("click", Clicku219, true);
function Clicku219(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u385 = document.getElementById('u385');

var u453 = document.getElementById('u453');
gv_vAlignTable['u453'] = 'center';
var u147 = document.getElementById('u147');

var u461 = document.getElementById('u461');

var u418 = document.getElementById('u418');
gv_vAlignTable['u418'] = 'center';
var u291 = document.getElementById('u291');

u291.style.cursor = 'pointer';
if (bIE) u291.attachEvent("onclick", Clicku291);
else u291.addEventListener("click", Clicku291, true);
function Clicku291(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u395 = document.getElementById('u395');
gv_vAlignTable['u395'] = 'center';
var u441 = document.getElementById('u441');

var u214 = document.getElementById('u214');

var u308 = document.getElementById('u308');
gv_vAlignTable['u308'] = 'top';
var u149 = document.getElementById('u149');

u149.style.cursor = 'pointer';
if (bIE) u149.attachEvent("onclick", Clicku149);
else u149.addEventListener("click", Clicku149, true);
function Clicku149(e)
{

if (true) {

	self.location.href="EMS单据管理.html" + GetQuerystring();

}

}

var u299 = document.getElementById('u299');

u299.style.cursor = 'pointer';
if (bIE) u299.attachEvent("onclick", Clicku299);
else u299.addEventListener("click", Clicku299, true);
function Clicku299(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u41 = document.getElementById('u41');

u41.style.cursor = 'pointer';
if (bIE) u41.attachEvent("onclick", Clicku41);
else u41.addEventListener("click", Clicku41, true);
function Clicku41(e)
{

if (true) {

	self.location.href="售后报表查询.html" + GetQuerystring();

}

}

var u170 = document.getElementById('u170');

var u58 = document.getElementById('u58');
gv_vAlignTable['u58'] = 'top';
var u45 = document.getElementById('u45');

u45.style.cursor = 'pointer';
if (bIE) u45.attachEvent("onclick", Clicku45);
else u45.addEventListener("click", Clicku45, true);
function Clicku45(e)
{

if (true) {

	self.location.href="请购单管理.html" + GetQuerystring();

}

}

var u73 = document.getElementById('u73');

var u303 = document.getElementById('u303');

u303.style.cursor = 'pointer';
if (bIE) u303.attachEvent("onclick", Clicku303);
else u303.addEventListener("click", Clicku303, true);
function Clicku303(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u206 = document.getElementById('u206');
gv_vAlignTable['u206'] = 'top';
var u433 = document.getElementById('u433');
gv_vAlignTable['u433'] = 'center';
var u213 = document.getElementById('u213');

var u98 = document.getElementById('u98');
gv_vAlignTable['u98'] = 'top';
var u238 = document.getElementById('u238');
gv_vAlignTable['u238'] = 'top';
var u178 = document.getElementById('u178');

var u211 = document.getElementById('u211');

u211.style.cursor = 'pointer';
if (bIE) u211.attachEvent("onclick", Clicku211);
else u211.addEventListener("click", Clicku211, true);
function Clicku211(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u393 = document.getElementById('u393');

u393.style.cursor = 'pointer';
if (bIE) u393.attachEvent("onclick", Clicku393);
else u393.addEventListener("click", Clicku393, true);
function Clicku393(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u381 = document.getElementById('u381');
gv_vAlignTable['u381'] = 'center';
var u233 = document.getElementById('u233');

u233.style.cursor = 'pointer';
if (bIE) u233.attachEvent("onclick", Clicku233);
else u233.addEventListener("click", Clicku233, true);
function Clicku233(e)
{

if (true) {

	self.location.href="角色管理.html" + "";

}

}

var u371 = document.getElementById('u371');
gv_vAlignTable['u371'] = 'center';
var u255 = document.getElementById('u255');

var u456 = document.getElementById('u456');
gv_vAlignTable['u456'] = 'center';
var u389 = document.getElementById('u389');

var u50 = document.getElementById('u50');
gv_vAlignTable['u50'] = 'top';
var u18 = document.getElementById('u18');
gv_vAlignTable['u18'] = 'top';
var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'center';
var u273 = document.getElementById('u273');

u273.style.cursor = 'pointer';
if (bIE) u273.attachEvent("onclick", Clicku273);
else u273.addEventListener("click", Clicku273, true);
function Clicku273(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u163 = document.getElementById('u163');

u163.style.cursor = 'pointer';
if (bIE) u163.attachEvent("onclick", Clicku163);
else u163.addEventListener("click", Clicku163, true);
function Clicku163(e)
{

if (true) {

	self.location.href="总账管理.html" + GetQuerystring();

}

}

var u90 = document.getElementById('u90');
gv_vAlignTable['u90'] = 'top';
var u8 = document.getElementById('u8');
gv_vAlignTable['u8'] = 'top';
var u394 = document.getElementById('u394');

var u268 = document.getElementById('u268');
gv_vAlignTable['u268'] = 'top';
var u327 = document.getElementById('u327');

u327.style.cursor = 'pointer';
if (bIE) u327.attachEvent("onclick", Clicku327);
else u327.addEventListener("click", Clicku327, true);
function Clicku327(e)
{

if (true) {

	self.location.href="其他出库[如活动赠品].html" + GetQuerystring();

}

}

var u252 = document.getElementById('u252');

var u26 = document.getElementById('u26');
gv_vAlignTable['u26'] = 'top';
var u182 = document.getElementById('u182');
gv_vAlignTable['u182'] = 'top';
var u332 = document.getElementById('u332');
gv_vAlignTable['u332'] = 'top';
var u143 = document.getElementById('u143');

u143.style.cursor = 'pointer';
if (bIE) u143.attachEvent("onclick", Clicku143);
else u143.addEventListener("click", Clicku143, true);
function Clicku143(e)
{

if (true) {

	self.location.href="佣金结算管理.html" + GetQuerystring();

}

}

var u446 = document.getElementById('u446');
gv_vAlignTable['u446'] = 'center';
var u341 = document.getElementById('u341');

var u363 = document.getElementById('u363');

var u203 = document.getElementById('u203');

u203.style.cursor = 'pointer';
if (bIE) u203.attachEvent("onclick", Clicku203);
else u203.addEventListener("click", Clicku203, true);
function Clicku203(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u426 = document.getElementById('u426');

var u241 = document.getElementById('u241');

u241.style.cursor = 'pointer';
if (bIE) u241.attachEvent("onclick", Clicku241);
else u241.addEventListener("click", Clicku241, true);
function Clicku241(e)
{

if (true) {

	self.location.href="合同文件管理.html" + "";

}

}

var u361 = document.getElementById('u361');

var u317 = document.getElementById('u317');

var u358 = document.getElementById('u358');
gv_vAlignTable['u358'] = 'center';
var u455 = document.getElementById('u455');

var u173 = document.getElementById('u173');

var u398 = document.getElementById('u398');
gv_vAlignTable['u398'] = 'center';
var u102 = document.getElementById('u102');
gv_vAlignTable['u102'] = 'top';
var u35 = document.getElementById('u35');

u35.style.cursor = 'pointer';
if (bIE) u35.attachEvent("onclick", Clicku35);
else u35.addEventListener("click", Clicku35, true);
function Clicku35(e)
{

if (true) {

	self.location.href="采购报表查询.html" + GetQuerystring();

}

}

var u321 = document.getElementById('u321');

u321.style.cursor = 'pointer';
if (bIE) u321.attachEvent("onclick", Clicku321);
else u321.addEventListener("click", Clicku321, true);
function Clicku321(e)
{

if (true) {

	self.location.href="销售出库.html" + GetQuerystring();

}

}

var u81 = document.getElementById('u81');

var u285 = document.getElementById('u285');

u285.style.cursor = 'pointer';
if (bIE) u285.attachEvent("onclick", Clicku285);
else u285.addEventListener("click", Clicku285, true);
function Clicku285(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u422 = document.getElementById('u422');

var u406 = document.getElementById('u406');

var u67 = document.getElementById('u67');

var u133 = document.getElementById('u133');

u133.style.cursor = 'pointer';
if (bIE) u133.attachEvent("onclick", Clicku133);
else u133.addEventListener("click", Clicku133, true);
function Clicku133(e)
{

if (true) {

	self.location.href="充值订单管理.html" + GetQuerystring();

}

}

var u113 = document.getElementById('u113');

u113.style.cursor = 'pointer';
if (bIE) u113.attachEvent("onclick", Clicku113);
else u113.addEventListener("click", Clicku113, true);
function Clicku113(e)
{

if (true) {

	self.location.href="B2B返利审核管理.html" + GetQuerystring();

}

}

var u410 = document.getElementById('u410');
gv_vAlignTable['u410'] = 'center';
var u440 = document.getElementById('u440');

u440.style.cursor = 'pointer';
if (bIE) u440.attachEvent("onclick", Clicku440);
else u440.addEventListener("click", Clicku440, true);
function Clicku440(e)
{

if (true) {

	self.location.href="期末结账.html" + GetQuerystring();

}

}

var u121 = document.getElementById('u121');

u121.style.cursor = 'pointer';
if (bIE) u121.attachEvent("onclick", Clicku121);
else u121.addEventListener("click", Clicku121, true);
function Clicku121(e)
{

if (true) {

	self.location.href="B2B电子渠道审核管理.html" + GetQuerystring();

}

}

var u164 = document.getElementById('u164');
gv_vAlignTable['u164'] = 'top';
var u298 = document.getElementById('u298');
gv_vAlignTable['u298'] = 'top';
var u177 = document.getElementById('u177');

var u448 = document.getElementById('u448');

u448.style.cursor = 'pointer';
if (bIE) u448.attachEvent("onclick", Clicku448);
else u448.addEventListener("click", Clicku448, true);
function Clicku448(e)
{

if (true) {

	self.location.href="基础资料管理.html" + GetQuerystring();

}

}

var u301 = document.getElementById('u301');

u301.style.cursor = 'pointer';
if (bIE) u301.attachEvent("onclick", Clicku301);
else u301.addEventListener("click", Clicku301, true);
function Clicku301(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u142 = document.getElementById('u142');
gv_vAlignTable['u142'] = 'top';
var u159 = document.getElementById('u159');

u159.style.cursor = 'pointer';
if (bIE) u159.attachEvent("onclick", Clicku159);
else u159.addEventListener("click", Clicku159, true);
function Clicku159(e)
{

if (true) {

	self.location.href="基础资料管理.html" + GetQuerystring();

}

}

var u340 = document.getElementById('u340');
gv_vAlignTable['u340'] = 'top';
var u29 = document.getElementById('u29');

u29.style.cursor = 'pointer';
if (bIE) u29.attachEvent("onclick", Clicku29);
else u29.addEventListener("click", Clicku29, true);
function Clicku29(e)
{

if (true) {

	self.location.href="系统管理.html" + GetQuerystring();

}

}

var u44 = document.getElementById('u44');

var u24 = document.getElementById('u24');
gv_vAlignTable['u24'] = 'top';
var u84 = document.getElementById('u84');
gv_vAlignTable['u84'] = 'top';
var u124 = document.getElementById('u124');
gv_vAlignTable['u124'] = 'top';
var u76 = document.getElementById('u76');

var u223 = document.getElementById('u223');

u223.style.cursor = 'pointer';
if (bIE) u223.attachEvent("onclick", Clicku223);
else u223.addEventListener("click", Clicku223, true);
function Clicku223(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u380 = document.getElementById('u380');

var u218 = document.getElementById('u218');
gv_vAlignTable['u218'] = 'top';
var u17 = document.getElementById('u17');

u17.style.cursor = 'pointer';
if (bIE) u17.attachEvent("onclick", Clicku17);
else u17.addEventListener("click", Clicku17, true);
function Clicku17(e)
{

if (true) {

}

}

var u267 = document.getElementById('u267');

u267.style.cursor = 'pointer';
if (bIE) u267.attachEvent("onclick", Clicku267);
else u267.addEventListener("click", Clicku267, true);
function Clicku267(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u320 = document.getElementById('u320');
gv_vAlignTable['u320'] = 'top';
var u388 = document.getElementById('u388');
gv_vAlignTable['u388'] = 'center';
var u405 = document.getElementById('u405');

u405.style.cursor = 'pointer';
if (bIE) u405.attachEvent("onclick", Clicku405);
else u405.addEventListener("click", Clicku405, true);
function Clicku405(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u22 = document.getElementById('u22');
gv_vAlignTable['u22'] = 'top';
var u272 = document.getElementById('u272');
gv_vAlignTable['u272'] = 'top';
var u38 = document.getElementById('u38');
gv_vAlignTable['u38'] = 'top';
var u112 = document.getElementById('u112');
gv_vAlignTable['u112'] = 'top';
var u53 = document.getElementById('u53');

u53.style.cursor = 'pointer';
if (bIE) u53.attachEvent("onclick", Clicku53);
else u53.addEventListener("click", Clicku53, true);
function Clicku53(e)
{

if (true) {

	self.location.href="调拨要货单管理.html" + GetQuerystring();

}

}

var u250 = document.getElementById('u250');
gv_vAlignTable['u250'] = 'top';
var u49 = document.getElementById('u49');

u49.style.cursor = 'pointer';
if (bIE) u49.attachEvent("onclick", Clicku49);
else u49.addEventListener("click", Clicku49, true);
function Clicku49(e)
{

if (true) {

	self.location.href="产品单管理.html" + GetQuerystring();

}

}

var u93 = document.getElementById('u93');

u93.style.cursor = 'pointer';
if (bIE) u93.attachEvent("onclick", Clicku93);
else u93.addEventListener("click", Clicku93, true);
function Clicku93(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u184 = document.getElementById('u184');
gv_vAlignTable['u184'] = 'top';
var u473 = document.getElementById('u473');

u473.style.cursor = 'pointer';
if (bIE) u473.attachEvent("onclick", Clicku473);
else u473.addEventListener("click", Clicku473, true);
function Clicku473(e)
{

if (true) {

	self.location.href="总账明细查询.html" + GetQuerystring();

}

}
gv_vAlignTable['u473'] = 'top';
var u326 = document.getElementById('u326');
gv_vAlignTable['u326'] = 'top';
var u194 = document.getElementById('u194');
gv_vAlignTable['u194'] = 'top';
var u357 = document.getElementById('u357');

var u265 = document.getElementById('u265');

u265.style.cursor = 'pointer';
if (bIE) u265.attachEvent("onclick", Clicku265);
else u265.addEventListener("click", Clicku265, true);
function Clicku265(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u230 = document.getElementById('u230');

var u189 = document.getElementById('u189');

u189.style.cursor = 'pointer';
if (bIE) u189.attachEvent("onclick", Clicku189);
else u189.addEventListener("click", Clicku189, true);
function Clicku189(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u339 = document.getElementById('u339');

u339.style.cursor = 'pointer';
if (bIE) u339.attachEvent("onclick", Clicku339);
else u339.addEventListener("click", Clicku339, true);
function Clicku339(e)
{

if (true) {

	self.location.href="移库审核.html" + GetQuerystring();

}

}

var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
var u62 = document.getElementById('u62');
gv_vAlignTable['u62'] = 'top';
var u409 = document.getElementById('u409');

var u354 = document.getElementById('u354');
gv_vAlignTable['u354'] = 'top';
var u79 = document.getElementById('u79');

u79.style.cursor = 'pointer';
if (bIE) u79.attachEvent("onclick", Clicku79);
else u79.addEventListener("click", Clicku79, true);
function Clicku79(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u403 = document.getElementById('u403');

var u127 = document.getElementById('u127');

u127.style.cursor = 'pointer';
if (bIE) u127.attachEvent("onclick", Clicku127);
else u127.addEventListener("click", Clicku127, true);
function Clicku127(e)
{

if (true) {

	self.location.href="B2B订单审批管理.html" + GetQuerystring();

}

}

var u404 = document.getElementById('u404');
gv_vAlignTable['u404'] = 'center';
var u245 = document.getElementById('u245');

u245.style.cursor = 'pointer';
if (bIE) u245.attachEvent("onclick", Clicku245);
else u245.addEventListener("click", Clicku245, true);
function Clicku245(e)
{

if (true) {

	self.location.href="审批流程管理.html" + "";

}

}

var u297 = document.getElementById('u297');

u297.style.cursor = 'pointer';
if (bIE) u297.attachEvent("onclick", Clicku297);
else u297.addEventListener("click", Clicku297, true);
function Clicku297(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u421 = document.getElementById('u421');
gv_vAlignTable['u421'] = 'center';
var u148 = document.getElementById('u148');

var u132 = document.getElementById('u132');

var u436 = document.getElementById('u436');
gv_vAlignTable['u436'] = 'center';
var u175 = document.getElementById('u175');

var u472 = document.getElementById('u472');

u472.style.cursor = 'pointer';
if (bIE) u472.attachEvent("onclick", Clicku472);
else u472.addEventListener("click", Clicku472, true);
function Clicku472(e)
{

if (true) {

	self.location.href="辅助余额明细查询.html" + GetQuerystring();

}

}
gv_vAlignTable['u472'] = 'top';
var u429 = document.getElementById('u429');

var u428 = document.getElementById('u428');

u428.style.cursor = 'pointer';
if (bIE) u428.attachEvent("onclick", Clicku428);
else u428.addEventListener("click", Clicku428, true);
function Clicku428(e)
{

if (true) {

	self.location.href="财务单据查询.html" + GetQuerystring();

}

}

var u464 = document.getElementById('u464');
gv_vAlignTable['u464'] = 'center';
var u176 = document.getElementById('u176');
gv_vAlignTable['u176'] = 'top';
var u71 = document.getElementById('u71');

var u396 = document.getElementById('u396');

u396.style.cursor = 'pointer';
if (bIE) u396.attachEvent("onclick", Clicku396);
else u396.addEventListener("click", Clicku396, true);
function Clicku396(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u470 = document.getElementById('u470');

u470.style.cursor = 'pointer';
if (bIE) u470.attachEvent("onclick", Clicku470);
else u470.addEventListener("click", Clicku470, true);
function Clicku470(e)
{

if (true) {

	self.location.href="辅助余额表查询.html" + GetQuerystring();

}

}
gv_vAlignTable['u470'] = 'top';
var u10 = document.getElementById('u10');

var u264 = document.getElementById('u264');
gv_vAlignTable['u264'] = 'top';
var u158 = document.getElementById('u158');

var u204 = document.getElementById('u204');
gv_vAlignTable['u204'] = 'top';
var u15 = document.getElementById('u15');

u15.style.cursor = 'pointer';
if (bIE) u15.attachEvent("onclick", Clicku15);
else u15.addEventListener("click", Clicku15, true);
function Clicku15(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u155 = document.getElementById('u155');

u155.style.cursor = 'pointer';
if (bIE) u155.attachEvent("onclick", Clicku155);
else u155.addEventListener("click", Clicku155, true);
function Clicku155(e)
{

if (true) {

	self.location.href="物流地域维护管理.html" + GetQuerystring();

}

}

var u249 = document.getElementById('u249');

u249.style.cursor = 'pointer';
if (bIE) u249.attachEvent("onclick", Clicku249);
else u249.addEventListener("click", Clicku249, true);
function Clicku249(e)
{

if (true) {

	self.location.href="系统参数管理.html" + GetQuerystring();

}

}

var u235 = document.getElementById('u235');

u235.style.cursor = 'pointer';
if (bIE) u235.attachEvent("onclick", Clicku235);
else u235.addEventListener("click", Clicku235, true);
function Clicku235(e)
{

if (true) {

	self.location.href="权限管理.html" + "";

}

}

var u47 = document.getElementById('u47');

u47.style.cursor = 'pointer';
if (bIE) u47.attachEvent("onclick", Clicku47);
else u47.addEventListener("click", Clicku47, true);
function Clicku47(e)
{

if (true) {

	self.location.href="请购单审核管理.html" + GetQuerystring();

}

}

var u392 = document.getElementById('u392');
gv_vAlignTable['u392'] = 'center';
var u413 = document.getElementById('u413');

var u87 = document.getElementById('u87');

u87.style.cursor = 'pointer';
if (bIE) u87.attachEvent("onclick", Clicku87);
else u87.addEventListener("click", Clicku87, true);
function Clicku87(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u244 = document.getElementById('u244');
gv_vAlignTable['u244'] = 'top';
var u266 = document.getElementById('u266');
gv_vAlignTable['u266'] = 'top';
var u7 = document.getElementById('u7');
gv_vAlignTable['u7'] = 'top';
var u110 = document.getElementById('u110');
gv_vAlignTable['u110'] = 'top';
var u271 = document.getElementById('u271');

u271.style.cursor = 'pointer';
if (bIE) u271.attachEvent("onclick", Clicku271);
else u271.addEventListener("click", Clicku271, true);
function Clicku271(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u307 = document.getElementById('u307');

u307.style.cursor = 'pointer';
if (bIE) u307.attachEvent("onclick", Clicku307);
else u307.addEventListener("click", Clicku307, true);
function Clicku307(e)
{

if (true) {

	self.location.href="入库管理.html" + GetQuerystring();

}

}

var u174 = document.getElementById('u174');
gv_vAlignTable['u174'] = 'top';
var u471 = document.getElementById('u471');

u471.style.cursor = 'pointer';
if (bIE) u471.attachEvent("onclick", Clicku471);
else u471.addEventListener("click", Clicku471, true);
function Clicku471(e)
{

if (true) {

	self.location.href="科目汇总表查询.html" + GetQuerystring();

}

}
gv_vAlignTable['u471'] = 'top';
var u279 = document.getElementById('u279');

u279.style.cursor = 'pointer';
if (bIE) u279.attachEvent("onclick", Clicku279);
else u279.addEventListener("click", Clicku279, true);
function Clicku279(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u325 = document.getElementById('u325');

u325.style.cursor = 'pointer';
if (bIE) u325.attachEvent("onclick", Clicku325);
else u325.addEventListener("click", Clicku325, true);
function Clicku325(e)
{

if (true) {

	self.location.href="借机出库.html" + GetQuerystring();

}

}

var u56 = document.getElementById('u56');
gv_vAlignTable['u56'] = 'top';
var u263 = document.getElementById('u263');

u263.style.cursor = 'pointer';
if (bIE) u263.attachEvent("onclick", Clicku263);
else u263.addEventListener("click", Clicku263, true);
function Clicku263(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u193 = document.getElementById('u193');

u193.style.cursor = 'pointer';
if (bIE) u193.attachEvent("onclick", Clicku193);
else u193.addEventListener("click", Clicku193, true);
function Clicku193(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

var u343 = document.getElementById('u343');

u343.style.cursor = 'pointer';
if (bIE) u343.attachEvent("onclick", Clicku343);
else u343.addEventListener("click", Clicku343, true);
function Clicku343(e)
{

if (true) {

	self.location.href="采购入库.html" + GetQuerystring();

}

}

var u188 = document.getElementById('u188');
gv_vAlignTable['u188'] = 'top';
var u248 = document.getElementById('u248');
gv_vAlignTable['u248'] = 'top';
var u338 = document.getElementById('u338');
gv_vAlignTable['u338'] = 'top';
var u457 = document.getElementById('u457');

u457.style.cursor = 'pointer';
if (bIE) u457.attachEvent("onclick", Clicku457);
else u457.addEventListener("click", Clicku457, true);
function Clicku457(e)
{

if (true) {

	self.location.href="成本核算管理.html" + GetQuerystring();

}

}

var u437 = document.getElementById('u437');

u437.style.cursor = 'pointer';
if (bIE) u437.attachEvent("onclick", Clicku437);
else u437.addEventListener("click", Clicku437, true);
function Clicku437(e)
{

if (true) {

	self.location.href="结转损益.html" + GetQuerystring();

}

}

var u105 = document.getElementById('u105');

u105.style.cursor = 'pointer';
if (bIE) u105.attachEvent("onclick", Clicku105);
else u105.addEventListener("click", Clicku105, true);
function Clicku105(e)
{

if (true) {

	self.location.href="#" + GetQuerystring();

}

}

if (window.OnLoad) OnLoad();
