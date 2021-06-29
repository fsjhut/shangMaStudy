
var PageName = '返厂出库管理';
var PageId = 'pcd7b186afc6047c8a052567f376796f4'
var PageUrl = '返厂出库管理.html'
document.title = '返厂出库管理';

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
gv_vAlignTable['u33'] = 'center';
var u371 = document.getElementById('u371');
gv_vAlignTable['u371'] = 'center';
var u402 = document.getElementById('u402');

var u65 = document.getElementById('u65');

u65.style.cursor = 'pointer';
if (bIE) u65.attachEvent("onclick", Clicku65);
else u65.addEventListener("click", Clicku65, true);
function Clicku65(e)
{

if (true) {

	self.location.href="B2C退换货申请管理[-待定].html" + GetQuerystring();

}

}

var u290 = document.getElementById('u290');

var u372 = document.getElementById('u372');

var u126 = document.getElementById('u126');

var u283 = document.getElementById('u283');
gv_vAlignTable['u283'] = 'center';
var u445 = document.getElementById('u445');
gv_vAlignTable['u445'] = 'top';
var u420 = document.getElementById('u420');

var u173 = document.getElementById('u173');
gv_vAlignTable['u173'] = 'center';
var u470 = document.getElementById('u470');
gv_vAlignTable['u470'] = 'center';
var u157 = document.getElementById('u157');
gv_vAlignTable['u157'] = 'center';
var u129 = document.getElementById('u129');
gv_vAlignTable['u129'] = 'center';
var u417 = document.getElementById('u417');
gv_vAlignTable['u417'] = 'center';
var u86 = document.getElementById('u86');

var u428 = document.getElementById('u428');

var u162 = document.getElementById('u162');

var u0 = document.getElementById('u0');

var u262 = document.getElementById('u262');

var u131 = document.getElementById('u131');
gv_vAlignTable['u131'] = 'center';
var u42 = document.getElementById('u42');

var u506 = document.getElementById('u506');
gv_vAlignTable['u506'] = 'center';
var u493 = document.getElementById('u493');

u493.style.cursor = 'pointer';
if (bIE) u493.attachEvent("onclick", Clicku493);
else u493.addEventListener("click", Clicku493, true);
function Clicku493(e)
{

if (true) {

	self.location.href="04.审核不通过修改_6.html" + GetQuerystring();

}

}

var u82 = document.getElementById('u82');
gv_vAlignTable['u82'] = 'center';
var u324 = document.getElementById('u324');

var u74 = document.getElementById('u74');

u74.style.cursor = 'pointer';
if (bIE) u74.attachEvent("onclick", Clicku74);
else u74.addEventListener("click", Clicku74, true);
function Clicku74(e)
{

if (true) {

	self.location.href="B2C不同机型换货审核[-待定].html" + GetQuerystring();

}

}

var u216 = document.getElementById('u216');

var u99 = document.getElementById('u99');
gv_vAlignTable['u99'] = 'top';
var u351 = document.getElementById('u351');
gv_vAlignTable['u351'] = 'center';
var u133 = document.getElementById('u133');
gv_vAlignTable['u133'] = 'center';
var u386 = document.getElementById('u386');

var u510 = document.getElementById('u510');
gv_vAlignTable['u510'] = 'center';
var u277 = document.getElementById('u277');
gv_vAlignTable['u277'] = 'center';
var u247 = document.getElementById('u247');
gv_vAlignTable['u247'] = 'center';
var u104 = document.getElementById('u104');
gv_vAlignTable['u104'] = 'top';
var u512 = document.getElementById('u512');
gv_vAlignTable['u512'] = 'center';
var u518 = document.getElementById('u518');
gv_vAlignTable['u518'] = 'center';
var u391 = document.getElementById('u391');
gv_vAlignTable['u391'] = 'center';
var u327 = document.getElementById('u327');
gv_vAlignTable['u327'] = 'center';
var u229 = document.getElementById('u229');
gv_vAlignTable['u229'] = 'center';
var u399 = document.getElementById('u399');
gv_vAlignTable['u399'] = 'center';
var u366 = document.getElementById('u366');

var u51 = document.getElementById('u51');

u51.style.cursor = 'pointer';
if (bIE) u51.attachEvent("onclick", Clicku51);
else u51.addEventListener("click", Clicku51, true);
function Clicku51(e)
{

if (true) {

	self.location.href="Resources/reload.html#" + encodeURI(PageUrl + GetQuerystring());

}

}

var u459 = document.getElementById('u459');

u459.style.cursor = 'pointer';
if (bIE) u459.attachEvent("onclick", Clicku459);
else u459.addEventListener("click", Clicku459, true);
function Clicku459(e)
{

if (true) {

	self.location.href="03.修改.html" + GetQuerystring();

}

}

var u172 = document.getElementById('u172');

var u270 = document.getElementById('u270');

var u264 = document.getElementById('u264');

var u128 = document.getElementById('u128');

var u68 = document.getElementById('u68');

u68.style.cursor = 'pointer';
if (bIE) u68.attachEvent("onclick", Clicku68);
else u68.addEventListener("click", Clicku68, true);
function Clicku68(e)
{

if (true) {

	self.location.href="B2C退换货审核.html" + GetQuerystring();

}

}

var u416 = document.getElementById('u416');

var u257 = document.getElementById('u257');
gv_vAlignTable['u257'] = 'center';
var u306 = document.getElementById('u306');

var u278 = document.getElementById('u278');

var u358 = document.getElementById('u358');

var u240 = document.getElementById('u240');

var u261 = document.getElementById('u261');
gv_vAlignTable['u261'] = 'center';
var u187 = document.getElementById('u187');
gv_vAlignTable['u187'] = 'center';
var u311 = document.getElementById('u311');
gv_vAlignTable['u311'] = 'center';
var u481 = document.getElementById('u481');

u481.style.cursor = 'pointer';
if (bIE) u481.attachEvent("onclick", Clicku481);
else u481.addEventListener("click", Clicku481, true);
function Clicku481(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u241 = document.getElementById('u241');
gv_vAlignTable['u241'] = 'center';
var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'top';
var u192 = document.getElementById('u192');

var u355 = document.getElementById('u355');
gv_vAlignTable['u355'] = 'center';
var u108 = document.getElementById('u108');

var u350 = document.getElementById('u350');

var u489 = document.getElementById('u489');

u489.style.cursor = 'pointer';
if (bIE) u489.attachEvent("onclick", Clicku489);
else u489.addEventListener("click", Clicku489, true);
function Clicku489(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u60 = document.getElementById('u60');

var u59 = document.getElementById('u59');
gv_vAlignTable['u59'] = 'center';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u360 = document.getElementById('u360');

var u103 = document.getElementById('u103');
gv_vAlignTable['u103'] = 'center';
var u529 = document.getElementById('u529');

var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'top';
var u107 = document.getElementById('u107');
gv_vAlignTable['u107'] = 'top';
var u368 = document.getElementById('u368');

var u401 = document.getElementById('u401');
gv_vAlignTable['u401'] = 'center';
var u365 = document.getElementById('u365');
gv_vAlignTable['u365'] = 'center';
var u171 = document.getElementById('u171');
gv_vAlignTable['u171'] = 'center';
var u314 = document.getElementById('u314');

var u125 = document.getElementById('u125');
gv_vAlignTable['u125'] = 'center';
var u36 = document.getElementById('u36');

var u282 = document.getElementById('u282');

var u415 = document.getElementById('u415');
gv_vAlignTable['u415'] = 'center';
var u432 = document.getElementById('u432');

var u143 = document.getElementById('u143');
gv_vAlignTable['u143'] = 'center';
var u454 = document.getElementById('u454');
gv_vAlignTable['u454'] = 'center';
var u122 = document.getElementById('u122');

var u260 = document.getElementById('u260');

var u450 = document.getElementById('u450');

var u505 = document.getElementById('u505');

u505.style.cursor = 'pointer';
if (bIE) u505.attachEvent("onclick", Clicku505);
else u505.addEventListener("click", Clicku505, true);
function Clicku505(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u504 = document.getElementById('u504');
gv_vAlignTable['u504'] = 'center';
var u138 = document.getElementById('u138');

var u194 = document.getElementById('u194');

var u474 = document.getElementById('u474');
gv_vAlignTable['u474'] = 'center';
var u439 = document.getElementById('u439');
gv_vAlignTable['u439'] = 'center';
var u444 = document.getElementById('u444');

var u349 = document.getElementById('u349');
gv_vAlignTable['u349'] = 'center';
var u475 = document.getElementById('u475');

u475.style.cursor = 'pointer';
if (bIE) u475.attachEvent("onclick", Clicku475);
else u475.addEventListener("click", Clicku475, true);
function Clicku475(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u231 = document.getElementById('u231');
gv_vAlignTable['u231'] = 'center';
var u169 = document.getElementById('u169');
gv_vAlignTable['u169'] = 'center';
var u215 = document.getElementById('u215');
gv_vAlignTable['u215'] = 'center';
var u137 = document.getElementById('u137');
gv_vAlignTable['u137'] = 'center';
var u434 = document.getElementById('u434');

var u102 = document.getElementById('u102');

var u180 = document.getElementById('u180');

var u385 = document.getElementById('u385');
gv_vAlignTable['u385'] = 'center';
var u85 = document.getElementById('u85');
gv_vAlignTable['u85'] = 'center';
var u77 = document.getElementById('u77');

u77.style.cursor = 'pointer';
if (bIE) u77.attachEvent("onclick", Clicku77);
else u77.addEventListener("click", Clicku77, true);
function Clicku77(e)
{

if (true) {

	self.location.href="B2B更换货管理.html" + GetQuerystring();

}

}

var u300 = document.getElementById('u300');

var u246 = document.getElementById('u246');

var u67 = document.getElementById('u67');
gv_vAlignTable['u67'] = 'center';
var u20 = document.getElementById('u20');

var u390 = document.getElementById('u390');

var u523 = document.getElementById('u523');

u523.style.cursor = 'pointer';
if (bIE) u523.attachEvent("onclick", Clicku523);
else u523.addEventListener("click", Clicku523, true);
function Clicku523(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u458 = document.getElementById('u458');

var u228 = document.getElementById('u228');

var u109 = document.getElementById('u109');
gv_vAlignTable['u109'] = 'top';
var u476 = document.getElementById('u476');
gv_vAlignTable['u476'] = 'center';
var u414 = document.getElementById('u414');

var u255 = document.getElementById('u255');
gv_vAlignTable['u255'] = 'center';
var u183 = document.getElementById('u183');
gv_vAlignTable['u183'] = 'center';
var u508 = document.getElementById('u508');
gv_vAlignTable['u508'] = 'center';
var u259 = document.getElementById('u259');
gv_vAlignTable['u259'] = 'center';
var u467 = document.getElementById('u467');

u467.style.cursor = 'pointer';
if (bIE) u467.attachEvent("onclick", Clicku467);
else u467.addEventListener("click", Clicku467, true);
function Clicku467(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u466 = document.getElementById('u466');
gv_vAlignTable['u466'] = 'center';
var u121 = document.getElementById('u121');

var u54 = document.getElementById('u54');

u54.style.cursor = 'pointer';
if (bIE) u54.attachEvent("onclick", Clicku54);
else u54.addEventListener("click", Clicku54, true);
function Clicku54(e)
{

if (true) {

	self.location.href="返厂出库单审核.html" + GetQuerystring();

}

}

var u387 = document.getElementById('u387');
gv_vAlignTable['u387'] = 'center';
var u344 = document.getElementById('u344');

var u94 = document.getElementById('u94');

u94.style.cursor = 'pointer';
if (bIE) u94.attachEvent("onclick", Clicku94);
else u94.addEventListener("click", Clicku94, true);
function Clicku94(e)
{

if (true) {

	self.location.href="特殊申诉单审核.html" + GetQuerystring();

}

}

var u186 = document.getElementById('u186');

var u279 = document.getElementById('u279');
gv_vAlignTable['u279'] = 'center';
var u323 = document.getElementById('u323');
gv_vAlignTable['u323'] = 'center';
var u480 = document.getElementById('u480');
gv_vAlignTable['u480'] = 'center';
var u210 = document.getElementById('u210');

var u318 = document.getElementById('u318');

var u191 = document.getElementById('u191');
gv_vAlignTable['u191'] = 'center';
var u136 = document.getElementById('u136');

var u274 = document.getElementById('u274');

var u101 = document.getElementById('u101');
gv_vAlignTable['u101'] = 'center';
var u488 = document.getElementById('u488');
gv_vAlignTable['u488'] = 'center';
var u199 = document.getElementById('u199');
gv_vAlignTable['u199'] = 'center';
var u31 = document.getElementById('u31');
gv_vAlignTable['u31'] = 'center';
var u140 = document.getElementById('u140');

var u48 = document.getElementById('u48');

u48.style.cursor = 'pointer';
if (bIE) u48.attachEvent("onclick", Clicku48);
else u48.addEventListener("click", Clicku48, true);
function Clicku48(e)
{

if (true) {

	self.location.href="返厂入库单审核.html" + GetQuerystring();

}

}

var u225 = document.getElementById('u225');
gv_vAlignTable['u225'] = 'center';
var u63 = document.getElementById('u63');
gv_vAlignTable['u63'] = 'center';
var u106 = document.getElementById('u106');
gv_vAlignTable['u106'] = 'center';
var u88 = document.getElementById('u88');

var u297 = document.getElementById('u297');
gv_vAlignTable['u297'] = 'center';
var u400 = document.getElementById('u400');

var u111 = document.getElementById('u111');
gv_vAlignTable['u111'] = 'top';
var u281 = document.getElementById('u281');
gv_vAlignTable['u281'] = 'center';
var u431 = document.getElementById('u431');
gv_vAlignTable['u431'] = 'center';
var u120 = document.getElementById('u120');
gv_vAlignTable['u120'] = 'center';
var u119 = document.getElementById('u119');

u119.style.cursor = 'pointer';
if (bIE) u119.attachEvent("onclick", Clicku119);
else u119.addEventListener("click", Clicku119, true);
function Clicku119(e)
{

if (true) {

	self.location.href="02.添加.html" + GetQuerystring();

}

}

var u205 = document.getElementById('u205');
gv_vAlignTable['u205'] = 'center';
var u302 = document.getElementById('u302');

var u289 = document.getElementById('u289');
gv_vAlignTable['u289'] = 'center';
var u40 = document.getElementById('u40');

var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'top';
var u160 = document.getElementById('u160');

var u72 = document.getElementById('u72');

var u80 = document.getElementById('u80');

u80.style.cursor = 'pointer';
if (bIE) u80.attachEvent("onclick", Clicku80);
else u80.addEventListener("click", Clicku80, true);
function Clicku80(e)
{

if (true) {

	self.location.href="B2B更换货审核.html" + GetQuerystring();

}

}

var u413 = document.getElementById('u413');
gv_vAlignTable['u413'] = 'center';
var u330 = document.getElementById('u330');

var u503 = document.getElementById('u503');

u503.style.cursor = 'pointer';
if (bIE) u503.attachEvent("onclick", Clicku503);
else u503.addEventListener("click", Clicku503, true);
function Clicku503(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u168 = document.getElementById('u168');

var u201 = document.getElementById('u201');
gv_vAlignTable['u201'] = 'center';
var u96 = document.getElementById('u96');
gv_vAlignTable['u96'] = 'center';
var u397 = document.getElementById('u397');
gv_vAlignTable['u397'] = 'center';
var u521 = document.getElementById('u521');

u521.style.cursor = 'pointer';
if (bIE) u521.attachEvent("onclick", Clicku521);
else u521.addEventListener("click", Clicku521, true);
function Clicku521(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u16 = document.getElementById('u16');

var u224 = document.getElementById('u224');

var u232 = document.getElementById('u232');

var u296 = document.getElementById('u296');

var u144 = document.getElementById('u144');

var u333 = document.getElementById('u333');
gv_vAlignTable['u333'] = 'center';
var u522 = document.getElementById('u522');
gv_vAlignTable['u522'] = 'center';
var u209 = document.getElementById('u209');
gv_vAlignTable['u209'] = 'center';
var u263 = document.getElementById('u263');
gv_vAlignTable['u263'] = 'center';
var u154 = document.getElementById('u154');

var u451 = document.getElementById('u451');
gv_vAlignTable['u451'] = 'top';
var u334 = document.getElementById('u334');

var u514 = document.getElementById('u514');
gv_vAlignTable['u514'] = 'center';
var u377 = document.getElementById('u377');
gv_vAlignTable['u377'] = 'center';
var u204 = document.getElementById('u204');

var u342 = document.getElementById('u342');

var u317 = document.getElementById('u317');
gv_vAlignTable['u317'] = 'center';
var u139 = document.getElementById('u139');
gv_vAlignTable['u139'] = 'center';
var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u336 = document.getElementById('u336');

var u525 = document.getElementById('u525');
gv_vAlignTable['u525'] = 'top';
var u179 = document.getElementById('u179');
gv_vAlignTable['u179'] = 'center';
var u185 = document.getElementById('u185');
gv_vAlignTable['u185'] = 'center';
var u322 = document.getElementById('u322');

var u376 = document.getElementById('u376');

var u57 = document.getElementById('u57');

u57.style.cursor = 'pointer';
if (bIE) u57.attachEvent("onclick", Clicku57);
else u57.addEventListener("click", Clicku57, true);
function Clicku57(e)
{

if (true) {

	self.location.href="维修点管理.html" + GetQuerystring();

}

}

var u337 = document.getElementById('u337');
gv_vAlignTable['u337'] = 'center';
var u526 = document.getElementById('u526');

var u92 = document.getElementById('u92');

var u369 = document.getElementById('u369');
gv_vAlignTable['u369'] = 'center';
var u97 = document.getElementById('u97');

var u516 = document.getElementById('u516');
gv_vAlignTable['u516'] = 'center';
var u190 = document.getElementById('u190');

var u340 = document.getElementById('u340');

var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'center';
var u198 = document.getElementById('u198');

var u348 = document.getElementById('u348');

var u253 = document.getElementById('u253');
gv_vAlignTable['u253'] = 'center';
var u295 = document.getElementById('u295');
gv_vAlignTable['u295'] = 'center';
var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u34 = document.getElementById('u34');

var u312 = document.getElementById('u312');

var u425 = document.getElementById('u425');
gv_vAlignTable['u425'] = 'center';
var u66 = document.getElementById('u66');

var u123 = document.getElementById('u123');
gv_vAlignTable['u123'] = 'center';
var u384 = document.getElementById('u384');

var u280 = document.getElementById('u280');

var u430 = document.getElementById('u430');

var u118 = document.getElementById('u118');
gv_vAlignTable['u118'] = 'center';
var u167 = document.getElementById('u167');
gv_vAlignTable['u167'] = 'center';
var u288 = document.getElementById('u288');

var u438 = document.getElementById('u438');

var u465 = document.getElementById('u465');

u465.style.cursor = 'pointer';
if (bIE) u465.attachEvent("onclick", Clicku465);
else u465.addEventListener("click", Clicku465, true);
function Clicku465(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u515 = document.getElementById('u515');

u515.style.cursor = 'pointer';
if (bIE) u515.attachEvent("onclick", Clicku515);
else u515.addEventListener("click", Clicku515, true);
function Clicku515(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u28 = document.getElementById('u28');
gv_vAlignTable['u28'] = 'top';
var u356 = document.getElementById('u356');

var u43 = document.getElementById('u43');
gv_vAlignTable['u43'] = 'center';
var u502 = document.getElementById('u502');
gv_vAlignTable['u502'] = 'center';
var u75 = document.getElementById('u75');

var u83 = document.getElementById('u83');

u83.style.cursor = 'pointer';
if (bIE) u83.attachEvent("onclick", Clicku83);
else u83.addEventListener("click", Clicku83, true);
function Clicku83(e)
{

if (true) {

	self.location.href="B2C退换货申请记录管理.html" + GetQuerystring();

}

}

var u222 = document.getElementById('u222');

var u213 = document.getElementById('u213');
gv_vAlignTable['u213'] = 'center';
var u383 = document.getElementById('u383');
gv_vAlignTable['u383'] = 'center';
var u520 = document.getElementById('u520');
gv_vAlignTable['u520'] = 'center';
var u294 = document.getElementById('u294');

var u208 = document.getElementById('u208');

var u152 = document.getElementById('u152');

var u528 = document.getElementById('u528');

var u275 = document.getElementById('u275');
gv_vAlignTable['u275'] = 'center';
var u237 = document.getElementById('u237');
gv_vAlignTable['u237'] = 'center';
var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u202 = document.getElementById('u202');

var u52 = document.getElementById('u52');

var u469 = document.getElementById('u469');

u469.style.cursor = 'pointer';
if (bIE) u469.attachEvent("onclick", Clicku469);
else u469.addEventListener("click", Clicku469, true);
function Clicku469(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u490 = document.getElementById('u490');
gv_vAlignTable['u490'] = 'center';
var u69 = document.getElementById('u69');

var u519 = document.getElementById('u519');

u519.style.cursor = 'pointer';
if (bIE) u519.attachEvent("onclick", Clicku519);
else u519.addEventListener("click", Clicku519, true);
function Clicku519(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u316 = document.getElementById('u316');

var u30 = document.getElementById('u30');

var u326 = document.getElementById('u326');

var u464 = document.getElementById('u464');
gv_vAlignTable['u464'] = 'center';
var u132 = document.getElementById('u132');

var u184 = document.getElementById('u184');

var u347 = document.getElementById('u347');
gv_vAlignTable['u347'] = 'center';
var u195 = document.getElementById('u195');
gv_vAlignTable['u195'] = 'center';
var u449 = document.getElementById('u449');
gv_vAlignTable['u449'] = 'top';
var u161 = document.getElementById('u161');
gv_vAlignTable['u161'] = 'center';
var u491 = document.getElementById('u491');

u491.style.cursor = 'pointer';
if (bIE) u491.attachEvent("onclick", Clicku491);
else u491.addEventListener("click", Clicku491, true);
function Clicku491(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
var u221 = document.getElementById('u221');
gv_vAlignTable['u221'] = 'center';
var u352 = document.getElementById('u352');

var u487 = document.getElementById('u487');

u487.style.cursor = 'pointer';
if (bIE) u487.attachEvent("onclick", Clicku487);
else u487.addEventListener("click", Clicku487, true);
function Clicku487(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u61 = document.getElementById('u61');
gv_vAlignTable['u61'] = 'center';
var u147 = document.getElementById('u147');
gv_vAlignTable['u147'] = 'center';
var u293 = document.getElementById('u293');
gv_vAlignTable['u293'] = 'center';
var u370 = document.getElementById('u370');

var u379 = document.getElementById('u379');
gv_vAlignTable['u379'] = 'center';
var u78 = document.getElementById('u78');

var u310 = document.getElementById('u310');

var u151 = document.getElementById('u151');
gv_vAlignTable['u151'] = 'center';
var u117 = document.getElementById('u117');

var u378 = document.getElementById('u378');

var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
var u236 = document.getElementById('u236');

var u374 = document.getElementById('u374');

var u287 = document.getElementById('u287');
gv_vAlignTable['u287'] = 'center';
var u468 = document.getElementById('u468');
gv_vAlignTable['u468'] = 'center';
var u424 = document.getElementById('u424');

var u135 = document.getElementById('u135');
gv_vAlignTable['u135'] = 'center';
var u127 = document.getElementById('u127');
gv_vAlignTable['u127'] = 'center';
var u292 = document.getElementById('u292');

var u419 = document.getElementById('u419');
gv_vAlignTable['u419'] = 'center';
var u359 = document.getElementById('u359');
gv_vAlignTable['u359'] = 'center';
var u166 = document.getElementById('u166');

var u463 = document.getElementById('u463');

u463.style.cursor = 'pointer';
if (bIE) u463.attachEvent("onclick", Clicku463);
else u463.addEventListener("click", Clicku463, true);
function Clicku463(e)
{

if (true) {

	self.location.href="03.修改.html" + GetQuerystring();

}

}

var u331 = document.getElementById('u331');
gv_vAlignTable['u331'] = 'center';
var u153 = document.getElementById('u153');
gv_vAlignTable['u153'] = 'center';
var u70 = document.getElementById('u70');
gv_vAlignTable['u70'] = 'center';
var u6 = document.getElementById('u6');

var u460 = document.getElementById('u460');
gv_vAlignTable['u460'] = 'center';
var u148 = document.getElementById('u148');

var u524 = document.getElementById('u524');
gv_vAlignTable['u524'] = 'center';
var u207 = document.getElementById('u207');
gv_vAlignTable['u207'] = 'center';
var u220 = document.getElementById('u220');

var u501 = document.getElementById('u501');

u501.style.cursor = 'pointer';
if (bIE) u501.attachEvent("onclick", Clicku501);
else u501.addEventListener("click", Clicku501, true);
function Clicku501(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u14 = document.getElementById('u14');

u14.style.cursor = 'pointer';
if (bIE) u14.attachEvent("onclick", Clicku14);
else u14.addEventListener("click", Clicku14, true);
function Clicku14(e)
{

if (true) {

}

}

var u305 = document.getElementById('u305');
gv_vAlignTable['u305'] = 'center';
var u12 = document.getElementById('u12');

u12.style.cursor = 'pointer';
if (bIE) u12.attachEvent("onclick", Clicku12);
else u12.addEventListener("click", Clicku12, true);
function Clicku12(e)
{

if (true) {

	self.location.href="B2C销售订单管理.html" + GetQuerystring();

}

}

var u443 = document.getElementById('u443');
gv_vAlignTable['u443'] = 'top';
var u427 = document.getElementById('u427');
gv_vAlignTable['u427'] = 'center';
var u212 = document.getElementById('u212');

var u46 = document.getElementById('u46');

var u382 = document.getElementById('u382');

var u517 = document.getElementById('u517');

u517.style.cursor = 'pointer';
if (bIE) u517.attachEvent("onclick", Clicku517);
else u517.addEventListener("click", Clicku517, true);
function Clicku517(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u509 = document.getElementById('u509');

u509.style.cursor = 'pointer';
if (bIE) u509.attachEvent("onclick", Clicku509);
else u509.addEventListener("click", Clicku509, true);
function Clicku509(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u150 = document.getElementById('u150');

var u243 = document.getElementById('u243');
gv_vAlignTable['u243'] = 'center';
var u39 = document.getElementById('u39');
gv_vAlignTable['u39'] = 'center';
var u381 = document.getElementById('u381');
gv_vAlignTable['u381'] = 'center';
var u373 = document.getElementById('u373');
gv_vAlignTable['u373'] = 'center';
var u329 = document.getElementById('u329');
gv_vAlignTable['u329'] = 'center';
var u238 = document.getElementById('u238');

var u165 = document.getElementById('u165');
gv_vAlignTable['u165'] = 'center';
var u462 = document.getElementById('u462');
gv_vAlignTable['u462'] = 'center';
var u269 = document.getElementById('u269');
gv_vAlignTable['u269'] = 'center';
var u130 = document.getElementById('u130');

var u315 = document.getElementById('u315');
gv_vAlignTable['u315'] = 'center';
var u55 = document.getElementById('u55');

var u345 = document.getElementById('u345');
gv_vAlignTable['u345'] = 'center';
var u485 = document.getElementById('u485');

u485.style.cursor = 'pointer';
if (bIE) u485.attachEvent("onclick", Clicku485);
else u485.addEventListener("click", Clicku485, true);
function Clicku485(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u95 = document.getElementById('u95');

var u196 = document.getElementById('u196');

var u254 = document.getElementById('u254');

var u346 = document.getElementById('u346');

var u332 = document.getElementById('u332');

var u477 = document.getElementById('u477');

u477.style.cursor = 'pointer';
if (bIE) u477.attachEvent("onclick", Clicku477);
else u477.addEventListener("click", Clicku477, true);
function Clicku477(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u304 = document.getElementById('u304');

var u442 = document.getElementById('u442');

var u364 = document.getElementById('u364');

var u239 = document.getElementById('u239');
gv_vAlignTable['u239'] = 'center';
var u498 = document.getElementById('u498');
gv_vAlignTable['u498'] = 'center';
var u527 = document.getElementById('u527');
gv_vAlignTable['u527'] = 'top';
var u32 = document.getElementById('u32');

var u375 = document.getElementById('u375');
gv_vAlignTable['u375'] = 'center';
var u105 = document.getElementById('u105');

var u234 = document.getElementById('u234');

var u405 = document.getElementById('u405');
gv_vAlignTable['u405'] = 'center';
var u64 = document.getElementById('u64');

var u328 = document.getElementById('u328');

var u116 = document.getElementById('u116');

var u452 = document.getElementById('u452');
gv_vAlignTable['u452'] = 'top';
var u89 = document.getElementById('u89');
gv_vAlignTable['u89'] = 'center';
var u100 = document.getElementById('u100');

var u286 = document.getElementById('u286');

var u219 = document.getElementById('u219');
gv_vAlignTable['u219'] = 'center';
var u436 = document.getElementById('u436');

var u453 = document.getElementById('u453');

u453.style.cursor = 'pointer';
if (bIE) u453.attachEvent("onclick", Clicku453);
else u453.addEventListener("click", Clicku453, true);
function Clicku453(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u134 = document.getElementById('u134');

var u461 = document.getElementById('u461');

u461.style.cursor = 'pointer';
if (bIE) u461.attachEvent("onclick", Clicku461);
else u461.addEventListener("click", Clicku461, true);
function Clicku461(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u258 = document.getElementById('u258');

var u418 = document.getElementById('u418');

var u291 = document.getElementById('u291');
gv_vAlignTable['u291'] = 'center';
var u395 = document.getElementById('u395');
gv_vAlignTable['u395'] = 'center';
var u441 = document.getElementById('u441');
gv_vAlignTable['u441'] = 'center';
var u214 = document.getElementById('u214');

var u308 = document.getElementById('u308');

var u149 = document.getElementById('u149');
gv_vAlignTable['u149'] = 'center';
var u299 = document.getElementById('u299');
gv_vAlignTable['u299'] = 'center';
var u412 = document.getElementById('u412');

var u41 = document.getElementById('u41');
gv_vAlignTable['u41'] = 'center';
var u170 = document.getElementById('u170');

var u58 = document.getElementById('u58');

var u45 = document.getElementById('u45');

u45.style.cursor = 'pointer';
if (bIE) u45.attachEvent("onclick", Clicku45);
else u45.addEventListener("click", Clicku45, true);
function Clicku45(e)
{

if (true) {

	self.location.href="返厂入库管理.html" + GetQuerystring();

}

}

var u73 = document.getElementById('u73');
gv_vAlignTable['u73'] = 'center';
var u303 = document.getElementById('u303');
gv_vAlignTable['u303'] = 'center';
var u206 = document.getElementById('u206');

var u433 = document.getElementById('u433');
gv_vAlignTable['u433'] = 'center';
var u98 = document.getElementById('u98');
gv_vAlignTable['u98'] = 'center';
var u178 = document.getElementById('u178');

var u500 = document.getElementById('u500');
gv_vAlignTable['u500'] = 'center';
var u211 = document.getElementById('u211');
gv_vAlignTable['u211'] = 'center';
var u394 = document.getElementById('u394');

var u233 = document.getElementById('u233');
gv_vAlignTable['u233'] = 'center';
var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u242 = document.getElementById('u242');

var u456 = document.getElementById('u456');

var u389 = document.getElementById('u389');
gv_vAlignTable['u389'] = 'center';
var u50 = document.getElementById('u50');
gv_vAlignTable['u50'] = 'center';
var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u273 = document.getElementById('u273');
gv_vAlignTable['u273'] = 'center';
var u163 = document.getElementById('u163');
gv_vAlignTable['u163'] = 'center';
var u90 = document.getElementById('u90');

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

var u486 = document.getElementById('u486');
gv_vAlignTable['u486'] = 'center';
var u407 = document.getElementById('u407');
gv_vAlignTable['u407'] = 'center';
var u268 = document.getElementById('u268');

var u301 = document.getElementById('u301');
gv_vAlignTable['u301'] = 'center';
var u411 = document.getElementById('u411');
gv_vAlignTable['u411'] = 'center';
var u252 = document.getElementById('u252');

var u484 = document.getElementById('u484');
gv_vAlignTable['u484'] = 'center';
var u256 = document.getElementById('u256');

var u26 = document.getElementById('u26');

var u182 = document.getElementById('u182');

var u309 = document.getElementById('u309');
gv_vAlignTable['u309'] = 'center';
var u446 = document.getElementById('u446');

var u341 = document.getElementById('u341');
gv_vAlignTable['u341'] = 'center';
var u363 = document.getElementById('u363');
gv_vAlignTable['u363'] = 'center';
var u203 = document.getElementById('u203');
gv_vAlignTable['u203'] = 'center';
var u426 = document.getElementById('u426');

var u447 = document.getElementById('u447');
gv_vAlignTable['u447'] = 'top';
var u396 = document.getElementById('u396');

var u455 = document.getElementById('u455');
gv_vAlignTable['u455'] = 'top';
var u404 = document.getElementById('u404');

var u398 = document.getElementById('u398');

var u115 = document.getElementById('u115');
gv_vAlignTable['u115'] = 'top';
var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'center';
var u321 = document.getElementById('u321');
gv_vAlignTable['u321'] = 'center';
var u81 = document.getElementById('u81');

var u285 = document.getElementById('u285');
gv_vAlignTable['u285'] = 'center';
var u435 = document.getElementById('u435');
gv_vAlignTable['u435'] = 'center';
var u406 = document.getElementById('u406');

var u393 = document.getElementById('u393');
gv_vAlignTable['u393'] = 'center';
var u146 = document.getElementById('u146');

var u479 = document.getElementById('u479');

u479.style.cursor = 'pointer';
if (bIE) u479.attachEvent("onclick", Clicku479);
else u479.addEventListener("click", Clicku479, true);
function Clicku479(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u113 = document.getElementById('u113');
gv_vAlignTable['u113'] = 'top';
var u410 = document.getElementById('u410');

var u440 = document.getElementById('u440');

var u164 = document.getElementById('u164');

var u298 = document.getElementById('u298');

var u177 = document.getElementById('u177');
gv_vAlignTable['u177'] = 'center';
var u448 = document.getElementById('u448');

var u142 = document.getElementById('u142');

var u159 = document.getElementById('u159');
gv_vAlignTable['u159'] = 'center';
var u507 = document.getElementById('u507');

u507.style.cursor = 'pointer';
if (bIE) u507.attachEvent("onclick", Clicku507);
else u507.addEventListener("click", Clicku507, true);
function Clicku507(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u227 = document.getElementById('u227');
gv_vAlignTable['u227'] = 'center';
var u29 = document.getElementById('u29');
gv_vAlignTable['u29'] = 'top';
var u367 = document.getElementById('u367');
gv_vAlignTable['u367'] = 'center';
var u44 = document.getElementById('u44');

var u84 = document.getElementById('u84');

var u124 = document.getElementById('u124');

var u76 = document.getElementById('u76');
gv_vAlignTable['u76'] = 'center';
var u223 = document.getElementById('u223');
gv_vAlignTable['u223'] = 'center';
var u380 = document.getElementById('u380');

var u530 = document.getElementById('u530');
gv_vAlignTable['u530'] = 'center';
var u218 = document.getElementById('u218');

var u267 = document.getElementById('u267');
gv_vAlignTable['u267'] = 'center';
var u320 = document.getElementById('u320');

var u388 = document.getElementById('u388');

var u22 = document.getElementById('u22');

u22.style.cursor = 'pointer';
if (bIE) u22.attachEvent("onclick", Clicku22);
else u22.addEventListener("click", Clicku22, true);
function Clicku22(e)
{

if (true) {

	self.location.href="返厂出入库管理.html" + GetQuerystring();

}

}

var u272 = document.getElementById('u272');

var u38 = document.getElementById('u38');

var u112 = document.getElementById('u112');

var u53 = document.getElementById('u53');
gv_vAlignTable['u53'] = 'center';
var u250 = document.getElementById('u250');

var u49 = document.getElementById('u49');

var u93 = document.getElementById('u93');
gv_vAlignTable['u93'] = 'center';
var u335 = document.getElementById('u335');
gv_vAlignTable['u335'] = 'center';
var u473 = document.getElementById('u473');

u473.style.cursor = 'pointer';
if (bIE) u473.attachEvent("onclick", Clicku473);
else u473.addEventListener("click", Clicku473, true);
function Clicku473(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u313 = document.getElementById('u313');
gv_vAlignTable['u313'] = 'center';
var u483 = document.getElementById('u483');

u483.style.cursor = 'pointer';
if (bIE) u483.attachEvent("onclick", Clicku483);
else u483.addEventListener("click", Clicku483, true);
function Clicku483(e)
{

if (true) {

	self.location.href="01.详情_8.html" + GetQuerystring();

}

}

var u492 = document.getElementById('u492');
gv_vAlignTable['u492'] = 'center';
var u181 = document.getElementById('u181');
gv_vAlignTable['u181'] = 'center';
var u357 = document.getElementById('u357');
gv_vAlignTable['u357'] = 'center';
var u265 = document.getElementById('u265');
gv_vAlignTable['u265'] = 'center';
var u230 = document.getElementById('u230');

var u189 = document.getElementById('u189');
gv_vAlignTable['u189'] = 'center';
var u362 = document.getElementById('u362');

var u494 = document.getElementById('u494');
gv_vAlignTable['u494'] = 'center';
var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
var u156 = document.getElementById('u156');

var u62 = document.getElementById('u62');

var u409 = document.getElementById('u409');
gv_vAlignTable['u409'] = 'center';
var u513 = document.getElementById('u513');

u513.style.cursor = 'pointer';
if (bIE) u513.attachEvent("onclick", Clicku513);
else u513.addEventListener("click", Clicku513, true);
function Clicku513(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u354 = document.getElementById('u354');

var u79 = document.getElementById('u79');
gv_vAlignTable['u79'] = 'center';
var u403 = document.getElementById('u403');
gv_vAlignTable['u403'] = 'center';
var u114 = document.getElementById('u114');

var u496 = document.getElementById('u496');
gv_vAlignTable['u496'] = 'center';
var u245 = document.getElementById('u245');
gv_vAlignTable['u245'] = 'center';
var u339 = document.getElementById('u339');
gv_vAlignTable['u339'] = 'center';
var u284 = document.getElementById('u284');

var u421 = document.getElementById('u421');
gv_vAlignTable['u421'] = 'center';
var u497 = document.getElementById('u497');

u497.style.cursor = 'pointer';
if (bIE) u497.attachEvent("onclick", Clicku497);
else u497.addEventListener("click", Clicku497, true);
function Clicku497(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u145 = document.getElementById('u145');
gv_vAlignTable['u145'] = 'center';
var u175 = document.getElementById('u175');
gv_vAlignTable['u175'] = 'center';
var u472 = document.getElementById('u472');
gv_vAlignTable['u472'] = 'center';
var u429 = document.getElementById('u429');
gv_vAlignTable['u429'] = 'center';
var u176 = document.getElementById('u176');

var u71 = document.getElementById('u71');

u71.style.cursor = 'pointer';
if (bIE) u71.attachEvent("onclick", Clicku71);
else u71.addEventListener("click", Clicku71, true);
function Clicku71(e)
{

if (true) {

	self.location.href="B2C不同机型换货管理[-待定].html" + GetQuerystring();

}

}

var u200 = document.getElementById('u200');

var u276 = document.getElementById('u276');

var u319 = document.getElementById('u319');
gv_vAlignTable['u319'] = 'center';
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

var u423 = document.getElementById('u423');
gv_vAlignTable['u423'] = 'center';
var u158 = document.getElementById('u158');

var u217 = document.getElementById('u217');
gv_vAlignTable['u217'] = 'center';
var u478 = document.getElementById('u478');
gv_vAlignTable['u478'] = 'center';
var u495 = document.getElementById('u495');

u495.style.cursor = 'pointer';
if (bIE) u495.attachEvent("onclick", Clicku495);
else u495.addEventListener("click", Clicku495, true);
function Clicku495(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u155 = document.getElementById('u155');
gv_vAlignTable['u155'] = 'center';
var u408 = document.getElementById('u408');

var u249 = document.getElementById('u249');
gv_vAlignTable['u249'] = 'center';
var u235 = document.getElementById('u235');
gv_vAlignTable['u235'] = 'center';
var u353 = document.getElementById('u353');
gv_vAlignTable['u353'] = 'center';
var u47 = document.getElementById('u47');
gv_vAlignTable['u47'] = 'center';
var u392 = document.getElementById('u392');

var u251 = document.getElementById('u251');
gv_vAlignTable['u251'] = 'center';
var u87 = document.getElementById('u87');
gv_vAlignTable['u87'] = 'center';
var u244 = document.getElementById('u244');

var u266 = document.getElementById('u266');

var u91 = document.getElementById('u91');

u91.style.cursor = 'pointer';
if (bIE) u91.attachEvent("onclick", Clicku91);
else u91.addEventListener("click", Clicku91, true);
function Clicku91(e)
{

if (true) {

	self.location.href="特殊申诉管理.html" + GetQuerystring();

}

}

var u338 = document.getElementById('u338');

var u7 = document.getElementById('u7');

var u110 = document.getElementById('u110');

var u271 = document.getElementById('u271');
gv_vAlignTable['u271'] = 'center';
var u226 = document.getElementById('u226');

var u307 = document.getElementById('u307');
gv_vAlignTable['u307'] = 'center';
var u174 = document.getElementById('u174');

var u471 = document.getElementById('u471');

u471.style.cursor = 'pointer';
if (bIE) u471.attachEvent("onclick", Clicku471);
else u471.addEventListener("click", Clicku471, true);
function Clicku471(e)
{

if (true) {

	self.location.href="03.修改.html" + GetQuerystring();

}

}

var u24 = document.getElementById('u24');

var u141 = document.getElementById('u141');
gv_vAlignTable['u141'] = 'center';
var u499 = document.getElementById('u499');

u499.style.cursor = 'pointer';
if (bIE) u499.attachEvent("onclick", Clicku499);
else u499.addEventListener("click", Clicku499, true);
function Clicku499(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u325 = document.getElementById('u325');
gv_vAlignTable['u325'] = 'center';
var u56 = document.getElementById('u56');
gv_vAlignTable['u56'] = 'center';
var u482 = document.getElementById('u482');
gv_vAlignTable['u482'] = 'center';
var u422 = document.getElementById('u422');

var u193 = document.getElementById('u193');
gv_vAlignTable['u193'] = 'center';
var u343 = document.getElementById('u343');
gv_vAlignTable['u343'] = 'center';
var u197 = document.getElementById('u197');
gv_vAlignTable['u197'] = 'center';
var u188 = document.getElementById('u188');

var u248 = document.getElementById('u248');

var u361 = document.getElementById('u361');
gv_vAlignTable['u361'] = 'center';
var u511 = document.getElementById('u511');

u511.style.cursor = 'pointer';
if (bIE) u511.attachEvent("onclick", Clicku511);
else u511.addEventListener("click", Clicku511, true);
function Clicku511(e)
{

if (true) {

	self.location.href="05.审核跟踪_5.html" + GetQuerystring();

}

}

var u457 = document.getElementById('u457');

var u437 = document.getElementById('u437');
gv_vAlignTable['u437'] = 'center';
var u18 = document.getElementById('u18');

if (window.OnLoad) OnLoad();
