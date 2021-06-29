
var PageName = '当当对帐记录';
var PageId = 'p1a089a3227504915a17fc05117f4ac4f'
var PageUrl = '当当对帐记录.html'
document.title = '当当对帐记录';

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

	self.location.href="B2C销售出库单记录.html" + GetQuerystring();

}

}

var u372 = document.getElementById('u372');

var u100 = document.getElementById('u100');

u100.style.cursor = 'pointer';
if (bIE) u100.attachEvent("onclick", Clicku100);
else u100.addEventListener("click", Clicku100, true);
function Clicku100(e)
{

if (true) {

	self.location.href="Resources/reload.html#" + encodeURI(PageUrl + GetQuerystring());

}

}

var u296 = document.getElementById('u296');

var u446 = document.getElementById('u446');

var u181 = document.getElementById('u181');
gv_vAlignTable['u181'] = 'center';
var u144 = document.getElementById('u144');

var u129 = document.getElementById('u129');
gv_vAlignTable['u129'] = 'center';
var u417 = document.getElementById('u417');
gv_vAlignTable['u417'] = 'center';
var u86 = document.getElementById('u86');

var u428 = document.getElementById('u428');

var u139 = document.getElementById('u139');
gv_vAlignTable['u139'] = 'center';
var u0 = document.getElementById('u0');

var u421 = document.getElementById('u421');
gv_vAlignTable['u421'] = 'center';
var u91 = document.getElementById('u91');

u91.style.cursor = 'pointer';
if (bIE) u91.attachEvent("onclick", Clicku91);
else u91.addEventListener("click", Clicku91, true);
function Clicku91(e)
{

if (true) {

	self.location.href="中邮平账单.html" + GetQuerystring();

}

}

var u459 = document.getElementById('u459');
gv_vAlignTable['u459'] = 'center';
var u506 = document.getElementById('u506');

var u347 = document.getElementById('u347');
gv_vAlignTable['u347'] = 'center';
var u82 = document.getElementById('u82');

u82.style.cursor = 'pointer';
if (bIE) u82.attachEvent("onclick", Clicku82);
else u82.addEventListener("click", Clicku82, true);
function Clicku82(e)
{

if (true) {

	self.location.href="中邮EMS对帐.html" + GetQuerystring();

}

}

var u324 = document.getElementById('u324');

var u74 = document.getElementById('u74');

var u321 = document.getElementById('u321');
gv_vAlignTable['u321'] = 'center';
var u203 = document.getElementById('u203');
gv_vAlignTable['u203'] = 'center';
var u99 = document.getElementById('u99');
gv_vAlignTable['u99'] = 'center';
var u351 = document.getElementById('u351');
gv_vAlignTable['u351'] = 'center';
var u133 = document.getElementById('u133');
gv_vAlignTable['u133'] = 'center';
var u386 = document.getElementById('u386');

var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u41 = document.getElementById('u41');
gv_vAlignTable['u41'] = 'center';
var u436 = document.getElementById('u436');

var u247 = document.getElementById('u247');
gv_vAlignTable['u247'] = 'center';
var u104 = document.getElementById('u104');

var u134 = document.getElementById('u134');

var u391 = document.getElementById('u391');
gv_vAlignTable['u391'] = 'center';
var u229 = document.getElementById('u229');
gv_vAlignTable['u229'] = 'center';
var u399 = document.getElementById('u399');
gv_vAlignTable['u399'] = 'center';
var u366 = document.getElementById('u366');

var u51 = document.getElementById('u51');

var u331 = document.getElementById('u331');
gv_vAlignTable['u331'] = 'center';
var u270 = document.getElementById('u270');

var u128 = document.getElementById('u128');

var u68 = document.getElementById('u68');

u68.style.cursor = 'pointer';
if (bIE) u68.attachEvent("onclick", Clicku68);
else u68.addEventListener("click", Clicku68, true);
function Clicku68(e)
{

if (true) {

	self.location.href="B2C销售退货管理.html" + GetQuerystring();

}

}

var u416 = document.getElementById('u416');

var u306 = document.getElementById('u306');

var u278 = document.getElementById('u278');

var u240 = document.getElementById('u240');

var u123 = document.getElementById('u123');
gv_vAlignTable['u123'] = 'center';
var u261 = document.getElementById('u261');
gv_vAlignTable['u261'] = 'center';
var u187 = document.getElementById('u187');
gv_vAlignTable['u187'] = 'center';
var u337 = document.getElementById('u337');
gv_vAlignTable['u337'] = 'center';
var u481 = document.getElementById('u481');
gv_vAlignTable['u481'] = 'top';
var u32 = document.getElementById('u32');

var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'top';
var u192 = document.getElementById('u192');

var u319 = document.getElementById('u319');
gv_vAlignTable['u319'] = 'center';
var u108 = document.getElementById('u108');
gv_vAlignTable['u108'] = 'center';
var u212 = document.getElementById('u212');

var u350 = document.getElementById('u350');

var u489 = document.getElementById('u489');
gv_vAlignTable['u489'] = 'top';
var u60 = document.getElementById('u60');

var u59 = document.getElementById('u59');

u59.style.cursor = 'pointer';
if (bIE) u59.attachEvent("onclick", Clicku59);
else u59.addEventListener("click", Clicku59, true);
function Clicku59(e)
{

if (true) {

	self.location.href="B2C网店订单管理.html" + GetQuerystring();

}

}

var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u360 = document.getElementById('u360');

var u103 = document.getElementById('u103');

u103.style.cursor = 'pointer';
if (bIE) u103.attachEvent("onclick", Clicku103);
else u103.addEventListener("click", Clicku103, true);
function Clicku103(e)
{

if (true) {

	self.location.href="当当对账记录审核[待定].html" + GetQuerystring();

}

}

var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'top';
var u107 = document.getElementById('u107');

var u368 = document.getElementById('u368');

var u401 = document.getElementById('u401');
gv_vAlignTable['u401'] = 'center';
var u330 = document.getElementById('u330');

var u314 = document.getElementById('u314');

var u125 = document.getElementById('u125');
gv_vAlignTable['u125'] = 'center';
var u36 = document.getElementById('u36');

var u295 = document.getElementById('u295');
gv_vAlignTable['u295'] = 'center';
var u415 = document.getElementById('u415');
gv_vAlignTable['u415'] = 'center';
var u432 = document.getElementById('u432');

var u143 = document.getElementById('u143');
gv_vAlignTable['u143'] = 'center';
var u201 = document.getElementById('u201');
gv_vAlignTable['u201'] = 'center';
var u454 = document.getElementById('u454');

var u260 = document.getElementById('u260');

var u450 = document.getElementById('u450');

var u505 = document.getElementById('u505');

var u504 = document.getElementById('u504');
gv_vAlignTable['u504'] = 'top';
var u138 = document.getElementById('u138');

var u345 = document.getElementById('u345');
gv_vAlignTable['u345'] = 'center';
var u439 = document.getElementById('u439');
gv_vAlignTable['u439'] = 'center';
var u349 = document.getElementById('u349');
gv_vAlignTable['u349'] = 'center';
var u211 = document.getElementById('u211');
gv_vAlignTable['u211'] = 'center';
var u231 = document.getElementById('u231');
gv_vAlignTable['u231'] = 'center';
var u169 = document.getElementById('u169');
gv_vAlignTable['u169'] = 'center';
var u420 = document.getElementById('u420');

var u202 = document.getElementById('u202');

var u137 = document.getElementById('u137');
gv_vAlignTable['u137'] = 'center';
var u275 = document.getElementById('u275');
gv_vAlignTable['u275'] = 'center';
var u102 = document.getElementById('u102');
gv_vAlignTable['u102'] = 'center';
var u180 = document.getElementById('u180');

var u385 = document.getElementById('u385');
gv_vAlignTable['u385'] = 'center';
var u85 = document.getElementById('u85');

u85.style.cursor = 'pointer';
if (bIE) u85.attachEvent("onclick", Clicku85);
else u85.addEventListener("click", Clicku85, true);
function Clicku85(e)
{

if (true) {

	self.location.href="中邮EMS对账记录.html" + GetQuerystring();

}

}

var u77 = document.getElementById('u77');
gv_vAlignTable['u77'] = 'center';
var u300 = document.getElementById('u300');

var u246 = document.getElementById('u246');

var u419 = document.getElementById('u419');
gv_vAlignTable['u419'] = 'center';
var u20 = document.getElementById('u20');

var u226 = document.getElementById('u226');

var u462 = document.getElementById('u462');

var u234 = document.getElementById('u234');

var u458 = document.getElementById('u458');

var u228 = document.getElementById('u228');

var u109 = document.getElementById('u109');

var u476 = document.getElementById('u476');

var u414 = document.getElementById('u414');

var u255 = document.getElementById('u255');
gv_vAlignTable['u255'] = 'center';
var u508 = document.getElementById('u508');

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

var u453 = document.getElementById('u453');
gv_vAlignTable['u453'] = 'center';
var u466 = document.getElementById('u466');

var u305 = document.getElementById('u305');
gv_vAlignTable['u305'] = 'center';
var u54 = document.getElementById('u54');
gv_vAlignTable['u54'] = 'center';
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

	self.location.href="当当订单查询.html" + GetQuerystring();

}

}

var u186 = document.getElementById('u186');

var u323 = document.getElementById('u323');
gv_vAlignTable['u323'] = 'center';
var u480 = document.getElementById('u480');

var u164 = document.getElementById('u164');

var u318 = document.getElementById('u318');

var u191 = document.getElementById('u191');
gv_vAlignTable['u191'] = 'center';
var u341 = document.getElementById('u341');
gv_vAlignTable['u341'] = 'center';
var u101 = document.getElementById('u101');

var u488 = document.getElementById('u488');

var u199 = document.getElementById('u199');
gv_vAlignTable['u199'] = 'center';
var u31 = document.getElementById('u31');
gv_vAlignTable['u31'] = 'center';
var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u259 = document.getElementById('u259');
gv_vAlignTable['u259'] = 'center';
var u48 = document.getElementById('u48');
gv_vAlignTable['u48'] = 'top';
var u63 = document.getElementById('u63');

var u106 = document.getElementById('u106');

u106.style.cursor = 'pointer';
if (bIE) u106.attachEvent("onclick", Clicku106);
else u106.addEventListener("click", Clicku106, true);
function Clicku106(e)
{

if (true) {

	self.location.href="当当平账单.html" + GetQuerystring();

}

}

var u88 = document.getElementById('u88');

u88.style.cursor = 'pointer';
if (bIE) u88.attachEvent("onclick", Clicku88);
else u88.addEventListener("click", Clicku88, true);
function Clicku88(e)
{

if (true) {

	self.location.href="中邮EMS对账记录审核[待定].html" + GetQuerystring();

}

}

var u400 = document.getElementById('u400');

var u124 = document.getElementById('u124');

var u294 = document.getElementById('u294');

var u408 = document.getElementById('u408');

var u120 = document.getElementById('u120');

var u119 = document.getElementById('u119');
gv_vAlignTable['u119'] = 'center';
var u205 = document.getElementById('u205');
gv_vAlignTable['u205'] = 'center';
var u302 = document.getElementById('u302');

var u289 = document.getElementById('u289');
gv_vAlignTable['u289'] = 'center';
var u40 = document.getElementById('u40');

var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'top';
var u390 = document.getElementById('u390');

var u173 = document.getElementById('u173');
gv_vAlignTable['u173'] = 'center';
var u72 = document.getElementById('u72');

var u80 = document.getElementById('u80');

var u467 = document.getElementById('u467');
gv_vAlignTable['u467'] = 'top';
var u135 = document.getElementById('u135');
gv_vAlignTable['u135'] = 'center';
var u281 = document.getElementById('u281');
gv_vAlignTable['u281'] = 'center';
var u503 = document.getElementById('u503');

var u168 = document.getElementById('u168');

var u214 = document.getElementById('u214');

var u142 = document.getElementById('u142');

var u96 = document.getElementById('u96');
gv_vAlignTable['u96'] = 'center';
var u397 = document.getElementById('u397');
gv_vAlignTable['u397'] = 'center';
var u16 = document.getElementById('u16');

var u362 = document.getElementById('u362');

var u232 = document.getElementById('u232');

var u333 = document.getElementById('u333');
gv_vAlignTable['u333'] = 'center';
var u209 = document.getElementById('u209');
gv_vAlignTable['u209'] = 'center';
var u276 = document.getElementById('u276');

var u154 = document.getElementById('u154');

var u451 = document.getElementById('u451');
gv_vAlignTable['u451'] = 'center';
var u282 = document.getElementById('u282');

var u377 = document.getElementById('u377');
gv_vAlignTable['u377'] = 'center';
var u204 = document.getElementById('u204');

var u342 = document.getElementById('u342');

var u304 = document.getElementById('u304');

var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u336 = document.getElementById('u336');

var u284 = document.getElementById('u284');

var u179 = document.getElementById('u179');
gv_vAlignTable['u179'] = 'center';
var u185 = document.getElementById('u185');
gv_vAlignTable['u185'] = 'center';
var u322 = document.getElementById('u322');

var u376 = document.getElementById('u376');

var u57 = document.getElementById('u57');

var u280 = document.getElementById('u280');

var u431 = document.getElementById('u431');
gv_vAlignTable['u431'] = 'center';
var u92 = document.getElementById('u92');

var u369 = document.getElementById('u369');
gv_vAlignTable['u369'] = 'center';
var u97 = document.getElementById('u97');

u97.style.cursor = 'pointer';
if (bIE) u97.attachEvent("onclick", Clicku97);
else u97.addEventListener("click", Clicku97, true);
function Clicku97(e)
{

if (true) {

	self.location.href="当当对帐.html" + GetQuerystring();

}

}

var u190 = document.getElementById('u190');

var u340 = document.getElementById('u340');

var u266 = document.getElementById('u266');

var u198 = document.getElementById('u198');

var u223 = document.getElementById('u223');
gv_vAlignTable['u223'] = 'center';
var u348 = document.getElementById('u348');

var u42 = document.getElementById('u42');
gv_vAlignTable['u42'] = 'top';
var u114 = document.getElementById('u114');

var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u208 = document.getElementById('u208');

var u34 = document.getElementById('u34');

var u153 = document.getElementById('u153');
gv_vAlignTable['u153'] = 'center';
var u425 = document.getElementById('u425');
gv_vAlignTable['u425'] = 'center';
var u66 = document.getElementById('u66');

var u136 = document.getElementById('u136');

var u384 = document.getElementById('u384');

var u293 = document.getElementById('u293');
gv_vAlignTable['u293'] = 'center';
var u430 = document.getElementById('u430');

var u118 = document.getElementById('u118');

var u167 = document.getElementById('u167');
gv_vAlignTable['u167'] = 'center';
var u288 = document.getElementById('u288');

var u438 = document.getElementById('u438');

var u465 = document.getElementById('u465');
gv_vAlignTable['u465'] = 'top';
var u149 = document.getElementById('u149');
gv_vAlignTable['u149'] = 'center';
var u28 = document.getElementById('u28');
gv_vAlignTable['u28'] = 'top';
var u356 = document.getElementById('u356');

var u43 = document.getElementById('u43');

var u502 = document.getElementById('u502');
gv_vAlignTable['u502'] = 'top';
var u75 = document.getElementById('u75');
gv_vAlignTable['u75'] = 'center';
var u83 = document.getElementById('u83');

var u222 = document.getElementById('u222');

var u213 = document.getElementById('u213');
gv_vAlignTable['u213'] = 'center';
var u383 = document.getElementById('u383');
gv_vAlignTable['u383'] = 'center';
var u445 = document.getElementById('u445');
gv_vAlignTable['u445'] = 'center';
var u219 = document.getElementById('u219');
gv_vAlignTable['u219'] = 'center';
var u257 = document.getElementById('u257');
gv_vAlignTable['u257'] = 'center';
var u311 = document.getElementById('u311');
gv_vAlignTable['u311'] = 'center';
var u152 = document.getElementById('u152');

var u239 = document.getElementById('u239');
gv_vAlignTable['u239'] = 'center';
var u237 = document.getElementById('u237');
gv_vAlignTable['u237'] = 'center';
var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u433 = document.getElementById('u433');
gv_vAlignTable['u433'] = 'center';
var u52 = document.getElementById('u52');
gv_vAlignTable['u52'] = 'center';
var u469 = document.getElementById('u469');
gv_vAlignTable['u469'] = 'top';
var u490 = document.getElementById('u490');

var u69 = document.getElementById('u69');

var u434 = document.getElementById('u434');

var u316 = document.getElementById('u316');

var u30 = document.getElementById('u30');

var u326 = document.getElementById('u326');

var u464 = document.getElementById('u464');

var u435 = document.getElementById('u435');
gv_vAlignTable['u435'] = 'center';
var u132 = document.getElementById('u132');

var u184 = document.getElementById('u184');

var u334 = document.getElementById('u334');

var u355 = document.getElementById('u355');
gv_vAlignTable['u355'] = 'center';
var u491 = document.getElementById('u491');
gv_vAlignTable['u491'] = 'top';
var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
var u196 = document.getElementById('u196');

var u221 = document.getElementById('u221');
gv_vAlignTable['u221'] = 'center';
var u365 = document.getElementById('u365');
gv_vAlignTable['u365'] = 'center';
var u487 = document.getElementById('u487');
gv_vAlignTable['u487'] = 'top';
var u61 = document.getElementById('u61');
gv_vAlignTable['u61'] = 'center';
var u147 = document.getElementById('u147');
gv_vAlignTable['u147'] = 'center';
var u444 = document.getElementById('u444');

var u370 = document.getElementById('u370');

var u379 = document.getElementById('u379');
gv_vAlignTable['u379'] = 'center';
var u78 = document.getElementById('u78');

var u406 = document.getElementById('u406');

var u151 = document.getElementById('u151');
gv_vAlignTable['u151'] = 'center';
var u117 = document.getElementById('u117');
gv_vAlignTable['u117'] = 'center';
var u378 = document.getElementById('u378');

var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
var u236 = document.getElementById('u236');

var u374 = document.getElementById('u374');

var u287 = document.getElementById('u287');
gv_vAlignTable['u287'] = 'center';
var u468 = document.getElementById('u468');

var u437 = document.getElementById('u437');
gv_vAlignTable['u437'] = 'center';
var u122 = document.getElementById('u122');

var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'center';
var u292 = document.getElementById('u292');

var u455 = document.getElementById('u455');
gv_vAlignTable['u455'] = 'center';
var u166 = document.getElementById('u166');

var u463 = document.getElementById('u463');
gv_vAlignTable['u463'] = 'top';
var u140 = document.getElementById('u140');

var u70 = document.getElementById('u70');
gv_vAlignTable['u70'] = 'center';
var u6 = document.getElementById('u6');

var u460 = document.getElementById('u460');

var u216 = document.getElementById('u216');

var u171 = document.getElementById('u171');
gv_vAlignTable['u171'] = 'center';
var u113 = document.getElementById('u113');
gv_vAlignTable['u113'] = 'center';
var u207 = document.getElementById('u207');
gv_vAlignTable['u207'] = 'center';
var u131 = document.getElementById('u131');
gv_vAlignTable['u131'] = 'center';
var u220 = document.getElementById('u220');

var u501 = document.getElementById('u501');

var u14 = document.getElementById('u14');

u14.style.cursor = 'pointer';
if (bIE) u14.attachEvent("onclick", Clicku14);
else u14.addEventListener("click", Clicku14, true);
function Clicku14(e)
{

if (true) {

}

}

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
gv_vAlignTable['u443'] = 'center';
var u427 = document.getElementById('u427');
gv_vAlignTable['u427'] = 'center';
var u225 = document.getElementById('u225');
gv_vAlignTable['u225'] = 'center';
var u46 = document.getElementById('u46');
gv_vAlignTable['u46'] = 'center';
var u382 = document.getElementById('u382');

var u509 = document.getElementById('u509');
gv_vAlignTable['u509'] = 'center';
var u150 = document.getElementById('u150');

var u243 = document.getElementById('u243');
gv_vAlignTable['u243'] = 'center';
var u39 = document.getElementById('u39');
gv_vAlignTable['u39'] = 'center';
var u373 = document.getElementById('u373');
gv_vAlignTable['u373'] = 'center';
var u329 = document.getElementById('u329');
gv_vAlignTable['u329'] = 'center';
var u238 = document.getElementById('u238');

var u165 = document.getElementById('u165');
gv_vAlignTable['u165'] = 'center';
var u267 = document.getElementById('u267');
gv_vAlignTable['u267'] = 'center';
var u269 = document.getElementById('u269');
gv_vAlignTable['u269'] = 'center';
var u130 = document.getElementById('u130');

var u315 = document.getElementById('u315');
gv_vAlignTable['u315'] = 'center';
var u55 = document.getElementById('u55');

var u215 = document.getElementById('u215');
gv_vAlignTable['u215'] = 'center';
var u485 = document.getElementById('u485');
gv_vAlignTable['u485'] = 'top';
var u95 = document.getElementById('u95');

var u157 = document.getElementById('u157');
gv_vAlignTable['u157'] = 'center';
var u183 = document.getElementById('u183');
gv_vAlignTable['u183'] = 'center';
var u346 = document.getElementById('u346');

var u320 = document.getElementById('u320');

var u332 = document.getElementById('u332');

var u477 = document.getElementById('u477');
gv_vAlignTable['u477'] = 'top';
var u145 = document.getElementById('u145');
gv_vAlignTable['u145'] = 'center';
var u442 = document.getElementById('u442');

var u364 = document.getElementById('u364');

var u413 = document.getElementById('u413');
gv_vAlignTable['u413'] = 'center';
var u498 = document.getElementById('u498');
gv_vAlignTable['u498'] = 'top';
var u359 = document.getElementById('u359');
gv_vAlignTable['u359'] = 'center';
var u262 = document.getElementById('u262');

var u105 = document.getElementById('u105');
gv_vAlignTable['u105'] = 'center';
var u380 = document.getElementById('u380');

var u49 = document.getElementById('u49');

var u64 = document.getElementById('u64');
gv_vAlignTable['u64'] = 'center';
var u328 = document.getElementById('u328');

var u116 = document.getElementById('u116');

var u325 = document.getElementById('u325');
gv_vAlignTable['u325'] = 'center';
var u89 = document.getElementById('u89');

var u286 = document.getElementById('u286');

var u264 = document.getElementById('u264');

var u410 = document.getElementById('u410');

var u121 = document.getElementById('u121');
gv_vAlignTable['u121'] = 'center';
var u461 = document.getElementById('u461');
gv_vAlignTable['u461'] = 'center';
var u265 = document.getElementById('u265');
gv_vAlignTable['u265'] = 'center';
var u418 = document.getElementById('u418');

var u291 = document.getElementById('u291');
gv_vAlignTable['u291'] = 'center';
var u395 = document.getElementById('u395');
gv_vAlignTable['u395'] = 'center';
var u441 = document.getElementById('u441');
gv_vAlignTable['u441'] = 'center';
var u308 = document.getElementById('u308');

var u299 = document.getElementById('u299');
gv_vAlignTable['u299'] = 'center';
var u412 = document.getElementById('u412');

var u449 = document.getElementById('u449');
gv_vAlignTable['u449'] = 'center';
var u170 = document.getElementById('u170');

var u58 = document.getElementById('u58');
gv_vAlignTable['u58'] = 'center';
var u45 = document.getElementById('u45');

var u73 = document.getElementById('u73');
gv_vAlignTable['u73'] = 'center';
var u303 = document.getElementById('u303');
gv_vAlignTable['u303'] = 'center';
var u206 = document.getElementById('u206');

var u98 = document.getElementById('u98');

var u178 = document.getElementById('u178');

var u500 = document.getElementById('u500');
gv_vAlignTable['u500'] = 'top';
var u224 = document.getElementById('u224');

var u381 = document.getElementById('u381');
gv_vAlignTable['u381'] = 'center';
var u233 = document.getElementById('u233');
gv_vAlignTable['u233'] = 'center';
var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u242 = document.getElementById('u242');

var u456 = document.getElementById('u456');

var u389 = document.getElementById('u389');
gv_vAlignTable['u389'] = 'center';
var u50 = document.getElementById('u50');

var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u273 = document.getElementById('u273');
gv_vAlignTable['u273'] = 'center';
var u90 = document.getElementById('u90');
gv_vAlignTable['u90'] = 'center';
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

var u407 = document.getElementById('u407');
gv_vAlignTable['u407'] = 'center';
var u394 = document.getElementById('u394');

var u268 = document.getElementById('u268');

var u327 = document.getElementById('u327');
gv_vAlignTable['u327'] = 'center';
var u411 = document.getElementById('u411');
gv_vAlignTable['u411'] = 'center';
var u252 = document.getElementById('u252');

var u484 = document.getElementById('u484');

var u256 = document.getElementById('u256');

var u26 = document.getElementById('u26');

var u195 = document.getElementById('u195');
gv_vAlignTable['u195'] = 'center';
var u309 = document.getElementById('u309');
gv_vAlignTable['u309'] = 'center';
var u363 = document.getElementById('u363');
gv_vAlignTable['u363'] = 'center';
var u426 = document.getElementById('u426');

var u241 = document.getElementById('u241');
gv_vAlignTable['u241'] = 'center';
var u172 = document.getElementById('u172');

var u361 = document.getElementById('u361');
gv_vAlignTable['u361'] = 'center';
var u317 = document.getElementById('u317');
gv_vAlignTable['u317'] = 'center';
var u358 = document.getElementById('u358');

var u404 = document.getElementById('u404');

var u398 = document.getElementById('u398');

var u115 = document.getElementById('u115');
gv_vAlignTable['u115'] = 'center';
var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'center';
var u162 = document.getElementById('u162');

var u174 = document.getElementById('u174');

var u81 = document.getElementById('u81');
gv_vAlignTable['u81'] = 'center';
var u285 = document.getElementById('u285');
gv_vAlignTable['u285'] = 'center';
var u422 = document.getElementById('u422');

var u67 = document.getElementById('u67');
gv_vAlignTable['u67'] = 'center';
var u146 = document.getElementById('u146');

var u479 = document.getElementById('u479');
gv_vAlignTable['u479'] = 'top';
var u290 = document.getElementById('u290');

var u440 = document.getElementById('u440');

var u176 = document.getElementById('u176');

var u310 = document.getElementById('u310');

var u177 = document.getElementById('u177');
gv_vAlignTable['u177'] = 'center';
var u298 = document.getElementById('u298');

var u474 = document.getElementById('u474');

var u448 = document.getElementById('u448');

var u301 = document.getElementById('u301');
gv_vAlignTable['u301'] = 'center';
var u429 = document.getElementById('u429');
gv_vAlignTable['u429'] = 'center';
var u159 = document.getElementById('u159');
gv_vAlignTable['u159'] = 'center';
var u507 = document.getElementById('u507');
gv_vAlignTable['u507'] = 'center';
var u227 = document.getElementById('u227');
gv_vAlignTable['u227'] = 'center';
var u29 = document.getElementById('u29');
gv_vAlignTable['u29'] = 'top';
var u367 = document.getElementById('u367');
gv_vAlignTable['u367'] = 'center';
var u44 = document.getElementById('u44');
gv_vAlignTable['u44'] = 'center';
var u24 = document.getElementById('u24');

var u84 = document.getElementById('u84');
gv_vAlignTable['u84'] = 'center';
var u76 = document.getElementById('u76');

var u210 = document.getElementById('u210');

var u393 = document.getElementById('u393');
gv_vAlignTable['u393'] = 'center';
var u218 = document.getElementById('u218');

var u283 = document.getElementById('u283');
gv_vAlignTable['u283'] = 'center';
var u254 = document.getElementById('u254');

var u161 = document.getElementById('u161');
gv_vAlignTable['u161'] = 'center';
var u388 = document.getElementById('u388');

var u405 = document.getElementById('u405');
gv_vAlignTable['u405'] = 'center';
var u272 = document.getElementById('u272');

var u38 = document.getElementById('u38');

var u112 = document.getElementById('u112');

var u53 = document.getElementById('u53');

var u250 = document.getElementById('u250');

var u93 = document.getElementById('u93');
gv_vAlignTable['u93'] = 'center';
var u335 = document.getElementById('u335');
gv_vAlignTable['u335'] = 'center';
var u473 = document.getElementById('u473');
gv_vAlignTable['u473'] = 'top';
var u313 = document.getElementById('u313');
gv_vAlignTable['u313'] = 'center';
var u483 = document.getElementById('u483');
gv_vAlignTable['u483'] = 'top';
var u492 = document.getElementById('u492');

var u194 = document.getElementById('u194');

var u357 = document.getElementById('u357');
gv_vAlignTable['u357'] = 'center';
var u493 = document.getElementById('u493');
gv_vAlignTable['u493'] = 'top';
var u424 = document.getElementById('u424');

var u230 = document.getElementById('u230');

var u189 = document.getElementById('u189');
gv_vAlignTable['u189'] = 'center';
var u375 = document.getElementById('u375');
gv_vAlignTable['u375'] = 'center';
var u494 = document.getElementById('u494');

var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
var u156 = document.getElementById('u156');

var u62 = document.getElementById('u62');

u62.style.cursor = 'pointer';
if (bIE) u62.attachEvent("onclick", Clicku62);
else u62.addEventListener("click", Clicku62, true);
function Clicku62(e)
{

if (true) {

	self.location.href="B2C销售出库管理.html" + GetQuerystring();

}

}

var u409 = document.getElementById('u409');
gv_vAlignTable['u409'] = 'center';
var u354 = document.getElementById('u354');

var u79 = document.getElementById('u79');

u79.style.cursor = 'pointer';
if (bIE) u79.attachEvent("onclick", Clicku79);
else u79.addEventListener("click", Clicku79, true);
function Clicku79(e)
{

if (true) {

	self.location.href="中邮订单查询.html" + GetQuerystring();

}

}

var u160 = document.getElementById('u160');

var u403 = document.getElementById('u403');
gv_vAlignTable['u403'] = 'center';
var u127 = document.getElementById('u127');
gv_vAlignTable['u127'] = 'center';
var u496 = document.getElementById('u496');
gv_vAlignTable['u496'] = 'top';
var u245 = document.getElementById('u245');
gv_vAlignTable['u245'] = 'center';
var u339 = document.getElementById('u339');
gv_vAlignTable['u339'] = 'center';
var u297 = document.getElementById('u297');
gv_vAlignTable['u297'] = 'center';
var u447 = document.getElementById('u447');
gv_vAlignTable['u447'] = 'center';
var u497 = document.getElementById('u497');

var u111 = document.getElementById('u111');
gv_vAlignTable['u111'] = 'center';
var u148 = document.getElementById('u148');

var u274 = document.getElementById('u274');

var u175 = document.getElementById('u175');
gv_vAlignTable['u175'] = 'center';
var u472 = document.getElementById('u472');

var u452 = document.getElementById('u452');

var u163 = document.getElementById('u163');
gv_vAlignTable['u163'] = 'center';
var u71 = document.getElementById('u71');

u71.style.cursor = 'pointer';
if (bIE) u71.attachEvent("onclick", Clicku71);
else u71.addEventListener("click", Clicku71, true);
function Clicku71(e)
{

if (true) {

	self.location.href="B2C销售退货单记录.html" + GetQuerystring();

}

}

var u200 = document.getElementById('u200');

var u396 = document.getElementById('u396');

var u470 = document.getElementById('u470');

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

var u126 = document.getElementById('u126');

var u423 = document.getElementById('u423');
gv_vAlignTable['u423'] = 'center';
var u158 = document.getElementById('u158');

var u277 = document.getElementById('u277');
gv_vAlignTable['u277'] = 'center';
var u217 = document.getElementById('u217');
gv_vAlignTable['u217'] = 'center';
var u478 = document.getElementById('u478');

var u495 = document.getElementById('u495');
gv_vAlignTable['u495'] = 'center';
var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u155 = document.getElementById('u155');
gv_vAlignTable['u155'] = 'center';
var u249 = document.getElementById('u249');
gv_vAlignTable['u249'] = 'center';
var u235 = document.getElementById('u235');
gv_vAlignTable['u235'] = 'center';
var u353 = document.getElementById('u353');
gv_vAlignTable['u353'] = 'center';
var u47 = document.getElementById('u47');
gv_vAlignTable['u47'] = 'top';
var u392 = document.getElementById('u392');

var u251 = document.getElementById('u251');
gv_vAlignTable['u251'] = 'center';
var u87 = document.getElementById('u87');
gv_vAlignTable['u87'] = 'center';
var u244 = document.getElementById('u244');

var u253 = document.getElementById('u253');
gv_vAlignTable['u253'] = 'center';
var u475 = document.getElementById('u475');
gv_vAlignTable['u475'] = 'top';
var u7 = document.getElementById('u7');

var u110 = document.getElementById('u110');

var u271 = document.getElementById('u271');
gv_vAlignTable['u271'] = 'center';
var u258 = document.getElementById('u258');

var u307 = document.getElementById('u307');
gv_vAlignTable['u307'] = 'center';
var u182 = document.getElementById('u182');

var u471 = document.getElementById('u471');
gv_vAlignTable['u471'] = 'top';
var u279 = document.getElementById('u279');
gv_vAlignTable['u279'] = 'center';
var u141 = document.getElementById('u141');
gv_vAlignTable['u141'] = 'center';
var u499 = document.getElementById('u499');

var u312 = document.getElementById('u312');

var u56 = document.getElementById('u56');

u56.style.cursor = 'pointer';
if (bIE) u56.attachEvent("onclick", Clicku56);
else u56.addEventListener("click", Clicku56, true);
function Clicku56(e)
{

if (true) {

	self.location.href="B2C销售订单查询.html" + GetQuerystring();

}

}

var u482 = document.getElementById('u482');

var u263 = document.getElementById('u263');
gv_vAlignTable['u263'] = 'center';
var u193 = document.getElementById('u193');
gv_vAlignTable['u193'] = 'center';
var u343 = document.getElementById('u343');
gv_vAlignTable['u343'] = 'center';
var u197 = document.getElementById('u197');
gv_vAlignTable['u197'] = 'center';
var u188 = document.getElementById('u188');

var u248 = document.getElementById('u248');

var u338 = document.getElementById('u338');

var u352 = document.getElementById('u352');

var u457 = document.getElementById('u457');
gv_vAlignTable['u457'] = 'center';
var u18 = document.getElementById('u18');

if (window.OnLoad) OnLoad();
