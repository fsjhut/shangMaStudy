
var PageName = '01.选择商品';
var PageId = 'p36633dfdb6244490b7316405512239fb'
var PageUrl = '01.选择商品.html'
document.title = '01.选择商品';

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

var u290 = document.getElementById('u290');
gv_vAlignTable['u290'] = 'center';
var u126 = document.getElementById('u126');
gv_vAlignTable['u126'] = 'center';
var u296 = document.getElementById('u296');
gv_vAlignTable['u296'] = 'center';
var u420 = document.getElementById('u420');

u420.style.cursor = 'pointer';
if (bIE) u420.attachEvent("onclick", Clicku420);
else u420.addEventListener("click", Clicku420, true);
function Clicku420(e)
{

if (true) {

	self.location.href="03.选用供应商品.html" + GetQuerystring();

}

}

var u332 = document.getElementById('u332');
gv_vAlignTable['u332'] = 'center';
var u108 = document.getElementById('u108');
gv_vAlignTable['u108'] = 'center';
var u129 = document.getElementById('u129');

var u417 = document.getElementById('u417');

var u86 = document.getElementById('u86');
gv_vAlignTable['u86'] = 'center';
var u428 = document.getElementById('u428');

var u175 = document.getElementById('u175');

var u0 = document.getElementById('u0');

var u262 = document.getElementById('u262');
gv_vAlignTable['u262'] = 'center';
var u131 = document.getElementById('u131');

var u42 = document.getElementById('u42');
gv_vAlignTable['u42'] = 'top';
var u347 = document.getElementById('u347');

u347.style.cursor = 'pointer';
if (bIE) u347.attachEvent("onclick", Clicku347);
else u347.addEventListener("click", Clicku347, true);
function Clicku347(e)
{

if (true) {

	self.location.href="产品查询.html" + GetQuerystring();

}

}

var u82 = document.getElementById('u82');
gv_vAlignTable['u82'] = 'center';
var u74 = document.getElementById('u74');
gv_vAlignTable['u74'] = 'center';
var u321 = document.getElementById('u321');

var u216 = document.getElementById('u216');
gv_vAlignTable['u216'] = 'center';
var u99 = document.getElementById('u99');

var u351 = document.getElementById('u351');

var u133 = document.getElementById('u133');

var u386 = document.getElementById('u386');

var u277 = document.getElementById('u277');

var u221 = document.getElementById('u221');

var u104 = document.getElementById('u104');
gv_vAlignTable['u104'] = 'center';
var u242 = document.getElementById('u242');
gv_vAlignTable['u242'] = 'center';
var u323 = document.getElementById('u323');

var u391 = document.getElementById('u391');

var u440 = document.getElementById('u440');

var u229 = document.getElementById('u229');

var u399 = document.getElementById('u399');

u399.style.cursor = 'pointer';
if (bIE) u399.attachEvent("onclick", Clicku399);
else u399.addEventListener("click", Clicku399, true);
function Clicku399(e)
{

if (true) {

	self.location.href="赠品转商品管理.html" + GetQuerystring();

}

}

var u366 = document.getElementById('u366');

var u51 = document.getElementById('u51');

var u459 = document.getElementById('u459');

var u331 = document.getElementById('u331');

var u270 = document.getElementById('u270');
gv_vAlignTable['u270'] = 'center';
var u128 = document.getElementById('u128');
gv_vAlignTable['u128'] = 'center';
var u68 = document.getElementById('u68');
gv_vAlignTable['u68'] = 'center';
var u416 = document.getElementById('u416');
gv_vAlignTable['u416'] = 'center';
var u257 = document.getElementById('u257');

var u306 = document.getElementById('u306');
gv_vAlignTable['u306'] = 'center';
var u278 = document.getElementById('u278');
gv_vAlignTable['u278'] = 'center';
var u261 = document.getElementById('u261');

var u187 = document.getElementById('u187');

var u324 = document.getElementById('u324');
gv_vAlignTable['u324'] = 'center';
var u32 = document.getElementById('u32');

var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'top';
var u192 = document.getElementById('u192');
gv_vAlignTable['u192'] = 'center';
var u319 = document.getElementById('u319');

var u212 = document.getElementById('u212');
gv_vAlignTable['u212'] = 'center';
var u350 = document.getElementById('u350');

u350.style.cursor = 'pointer';
if (bIE) u350.attachEvent("onclick", Clicku350);
else u350.addEventListener("click", Clicku350, true);
function Clicku350(e)
{

if (true) {

	self.location.href="商品管理_1.html" + GetQuerystring();

}

}

var u60 = document.getElementById('u60');
gv_vAlignTable['u60'] = 'center';
var u59 = document.getElementById('u59');

var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u373 = document.getElementById('u373');

u373.style.cursor = 'pointer';
if (bIE) u373.attachEvent("onclick", Clicku373);
else u373.addEventListener("click", Clicku373, true);
function Clicku373(e)
{

if (true) {

	self.location.href="促销活动管理.html" + GetQuerystring();

}

}

var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'top';
var u107 = document.getElementById('u107');

var u368 = document.getElementById('u368');

var u401 = document.getElementById('u401');
gv_vAlignTable['u401'] = 'center';
var u171 = document.getElementById('u171');

var u314 = document.getElementById('u314');
gv_vAlignTable['u314'] = 'center';
var u112 = document.getElementById('u112');
gv_vAlignTable['u112'] = 'center';
var u36 = document.getElementById('u36');

var u295 = document.getElementById('u295');

var u415 = document.getElementById('u415');

var u256 = document.getElementById('u256');
gv_vAlignTable['u256'] = 'center';
var u143 = document.getElementById('u143');

var u454 = document.getElementById('u454');

var u260 = document.getElementById('u260');
gv_vAlignTable['u260'] = 'center';
var u450 = document.getElementById('u450');

var u161 = document.getElementById('u161');

var u345 = document.getElementById('u345');
gv_vAlignTable['u345'] = 'center';
var u439 = document.getElementById('u439');
gv_vAlignTable['u439'] = 'top';
var u349 = document.getElementById('u349');
gv_vAlignTable['u349'] = 'center';
var u211 = document.getElementById('u211');

var u231 = document.getElementById('u231');

var u169 = document.getElementById('u169');

var u215 = document.getElementById('u215');

var u137 = document.getElementById('u137');

var u275 = document.getElementById('u275');

var u102 = document.getElementById('u102');
gv_vAlignTable['u102'] = 'center';
var u180 = document.getElementById('u180');
gv_vAlignTable['u180'] = 'center';
var u369 = document.getElementById('u369');
gv_vAlignTable['u369'] = 'center';
var u85 = document.getElementById('u85');

var u77 = document.getElementById('u77');

var u300 = document.getElementById('u300');
gv_vAlignTable['u300'] = 'center';
var u246 = document.getElementById('u246');
gv_vAlignTable['u246'] = 'center';
var u181 = document.getElementById('u181');

var u20 = document.getElementById('u20');

var u226 = document.getElementById('u226');
gv_vAlignTable['u226'] = 'center';
var u458 = document.getElementById('u458');
gv_vAlignTable['u458'] = 'top';
var u264 = document.getElementById('u264');
gv_vAlignTable['u264'] = 'center';
var u109 = document.getElementById('u109');

var u414 = document.getElementById('u414');

u414.style.cursor = 'pointer';
if (bIE) u414.attachEvent("onclick", Clicku414);
else u414.addEventListener("click", Clicku414, true);
function Clicku414(e)
{

if (true) {

	self.location.href="赠品捆绑信息审核.html" + GetQuerystring();

}

}

var u424 = document.getElementById('u424');

var u259 = document.getElementById('u259');

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u466 = document.getElementById('u466');

var u305 = document.getElementById('u305');

var u425 = document.getElementById('u425');
gv_vAlignTable['u425'] = 'top';
var u54 = document.getElementById('u54');
gv_vAlignTable['u54'] = 'center';
var u387 = document.getElementById('u387');
gv_vAlignTable['u387'] = 'center';
var u206 = document.getElementById('u206');
gv_vAlignTable['u206'] = 'center';
var u344 = document.getElementById('u344');

var u94 = document.getElementById('u94');
gv_vAlignTable['u94'] = 'center';
var u186 = document.getElementById('u186');
gv_vAlignTable['u186'] = 'center';
var u336 = document.getElementById('u336');
gv_vAlignTable['u336'] = 'center';
var u340 = document.getElementById('u340');

var u210 = document.getElementById('u210');
gv_vAlignTable['u210'] = 'center';
var u164 = document.getElementById('u164');
gv_vAlignTable['u164'] = 'center';
var u318 = document.getElementById('u318');
gv_vAlignTable['u318'] = 'center';
var u191 = document.getElementById('u191');

var u136 = document.getElementById('u136');
gv_vAlignTable['u136'] = 'center';
var u367 = document.getElementById('u367');
gv_vAlignTable['u367'] = 'center';
var u101 = document.getElementById('u101');

var u199 = document.getElementById('u199');

var u31 = document.getElementById('u31');
gv_vAlignTable['u31'] = 'center';
var u140 = document.getElementById('u140');
gv_vAlignTable['u140'] = 'center';
var u48 = document.getElementById('u48');

var u63 = document.getElementById('u63');

var u106 = document.getElementById('u106');
gv_vAlignTable['u106'] = 'center';
var u88 = document.getElementById('u88');
gv_vAlignTable['u88'] = 'center';
var u116 = document.getElementById('u116');
gv_vAlignTable['u116'] = 'center';
var u380 = document.getElementById('u380');

var u400 = document.getElementById('u400');

var u348 = document.getElementById('u348');

var u124 = document.getElementById('u124');
gv_vAlignTable['u124'] = 'center';
var u294 = document.getElementById('u294');
gv_vAlignTable['u294'] = 'center';
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
gv_vAlignTable['u120'] = 'center';
var u119 = document.getElementById('u119');

var u205 = document.getElementById('u205');

var u343 = document.getElementById('u343');
gv_vAlignTable['u343'] = 'center';
var u302 = document.getElementById('u302');
gv_vAlignTable['u302'] = 'center';
var u289 = document.getElementById('u289');

var u40 = document.getElementById('u40');

var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'top';
var u390 = document.getElementById('u390');
gv_vAlignTable['u390'] = 'center';
var u160 = document.getElementById('u160');
gv_vAlignTable['u160'] = 'center';
var u72 = document.getElementById('u72');
gv_vAlignTable['u72'] = 'center';
var u80 = document.getElementById('u80');
gv_vAlignTable['u80'] = 'center';
var u467 = document.getElementById('u467');

var u163 = document.getElementById('u163');

var u135 = document.getElementById('u135');

var u281 = document.getElementById('u281');

var u168 = document.getElementById('u168');
gv_vAlignTable['u168'] = 'center';
var u201 = document.getElementById('u201');

var u96 = document.getElementById('u96');
gv_vAlignTable['u96'] = 'center';
var u384 = document.getElementById('u384');
gv_vAlignTable['u384'] = 'center';
var u16 = document.getElementById('u16');

var u362 = document.getElementById('u362');

u362.style.cursor = 'pointer';
if (bIE) u362.attachEvent("onclick", Clicku362);
else u362.addEventListener("click", Clicku362, true);
function Clicku362(e)
{

if (true) {

	self.location.href="价格调整管理.html" + GetQuerystring();

}

}

var u245 = document.getElementById('u245');

var u447 = document.getElementById('u447');
gv_vAlignTable['u447'] = 'top';
var u333 = document.getElementById('u333');

var u209 = document.getElementById('u209');

var u276 = document.getElementById('u276');
gv_vAlignTable['u276'] = 'center';
var u421 = document.getElementById('u421');
gv_vAlignTable['u421'] = 'center';
var u313 = document.getElementById('u313');

var u154 = document.getElementById('u154');
gv_vAlignTable['u154'] = 'center';
var u451 = document.getElementById('u451');
gv_vAlignTable['u451'] = 'top';
var u334 = document.getElementById('u334');
gv_vAlignTable['u334'] = 'center';
var u282 = document.getElementById('u282');
gv_vAlignTable['u282'] = 'center';
var u377 = document.getElementById('u377');

var u258 = document.getElementById('u258');
gv_vAlignTable['u258'] = 'center';
var u342 = document.getElementById('u342');

var u304 = document.getElementById('u304');
gv_vAlignTable['u304'] = 'center';
var u139 = document.getElementById('u139');

var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u284 = document.getElementById('u284');
gv_vAlignTable['u284'] = 'center';
var u179 = document.getElementById('u179');

var u185 = document.getElementById('u185');

var u335 = document.getElementById('u335');

var u57 = document.getElementById('u57');

var u280 = document.getElementById('u280');
gv_vAlignTable['u280'] = 'center';
var u431 = document.getElementById('u431');
gv_vAlignTable['u431'] = 'top';
var u92 = document.getElementById('u92');
gv_vAlignTable['u92'] = 'center';
var u228 = document.getElementById('u228');
gv_vAlignTable['u228'] = 'center';
var u97 = document.getElementById('u97');

var u190 = document.getElementById('u190');
gv_vAlignTable['u190'] = 'center';
var u353 = document.getElementById('u353');

u353.style.cursor = 'pointer';
if (bIE) u353.attachEvent("onclick", Clicku353);
else u353.addEventListener("click", Clicku353, true);
function Clicku353(e)
{

if (true) {

	self.location.href="商品品牌管理.html" + GetQuerystring();

}

}

var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'center';
var u198 = document.getElementById('u198');
gv_vAlignTable['u198'] = 'center';
var u371 = document.getElementById('u371');
gv_vAlignTable['u371'] = 'center';
var u253 = document.getElementById('u253');

var u407 = document.getElementById('u407');
gv_vAlignTable['u407'] = 'center';
var u114 = document.getElementById('u114');
gv_vAlignTable['u114'] = 'center';
var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u208 = document.getElementById('u208');
gv_vAlignTable['u208'] = 'center';
var u34 = document.getElementById('u34');

var u312 = document.getElementById('u312');
gv_vAlignTable['u312'] = 'center';
var u153 = document.getElementById('u153');

var u412 = document.getElementById('u412');

var u66 = document.getElementById('u66');
gv_vAlignTable['u66'] = 'center';
var u123 = document.getElementById('u123');

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

var u430 = document.getElementById('u430');

var u138 = document.getElementById('u138');
gv_vAlignTable['u138'] = 'center';
var u118 = document.getElementById('u118');
gv_vAlignTable['u118'] = 'center';
var u167 = document.getElementById('u167');

var u288 = document.getElementById('u288');
gv_vAlignTable['u288'] = 'center';
var u438 = document.getElementById('u438');

var u465 = document.getElementById('u465');

var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u28 = document.getElementById('u28');
gv_vAlignTable['u28'] = 'top';
var u356 = document.getElementById('u356');

u356.style.cursor = 'pointer';
if (bIE) u356.attachEvent("onclick", Clicku356);
else u356.addEventListener("click", Clicku356, true);
function Clicku356(e)
{

if (true) {

	self.location.href="商品类型管理.html" + GetQuerystring();

}

}

var u43 = document.getElementById('u43');

var u75 = document.getElementById('u75');

var u83 = document.getElementById('u83');

var u222 = document.getElementById('u222');
gv_vAlignTable['u222'] = 'center';
var u360 = document.getElementById('u360');

var u213 = document.getElementById('u213');

var u383 = document.getElementById('u383');

var u445 = document.getElementById('u445');
gv_vAlignTable['u445'] = 'top';
var u244 = document.getElementById('u244');
gv_vAlignTable['u244'] = 'center';
var u311 = document.getElementById('u311');

var u152 = document.getElementById('u152');
gv_vAlignTable['u152'] = 'center';
var u432 = document.getElementById('u432');

var u239 = document.getElementById('u239');

var u237 = document.getElementById('u237');

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u202 = document.getElementById('u202');
gv_vAlignTable['u202'] = 'center';
var u52 = document.getElementById('u52');
gv_vAlignTable['u52'] = 'center';
var u69 = document.getElementById('u69');

var u434 = document.getElementById('u434');

var u316 = document.getElementById('u316');
gv_vAlignTable['u316'] = 'center';
var u30 = document.getElementById('u30');

var u464 = document.getElementById('u464');
gv_vAlignTable['u464'] = 'top';
var u435 = document.getElementById('u435');
gv_vAlignTable['u435'] = 'top';
var u132 = document.getElementById('u132');
gv_vAlignTable['u132'] = 'center';
var u184 = document.getElementById('u184');
gv_vAlignTable['u184'] = 'center';
var u217 = document.getElementById('u217');

var u195 = document.getElementById('u195');

var u355 = document.getElementById('u355');
gv_vAlignTable['u355'] = 'center';
var u449 = document.getElementById('u449');
gv_vAlignTable['u449'] = 'top';
var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
var u385 = document.getElementById('u385');

u385.style.cursor = 'pointer';
if (bIE) u385.attachEvent("onclick", Clicku385);
else u385.addEventListener("click", Clicku385, true);
function Clicku385(e)
{

if (true) {

	self.location.href="赠品退库管理.html" + GetQuerystring();

}

}

var u365 = document.getElementById('u365');

u365.style.cursor = 'pointer';
if (bIE) u365.attachEvent("onclick", Clicku365);
else u365.addEventListener("click", Clicku365, true);
function Clicku365(e)
{

if (true) {

	self.location.href="价格调整审核.html" + GetQuerystring();

}

}

var u61 = document.getElementById('u61');

var u147 = document.getElementById('u147');

var u444 = document.getElementById('u444');

var u370 = document.getElementById('u370');

var u283 = document.getElementById('u283');

var u78 = document.getElementById('u78');
gv_vAlignTable['u78'] = 'center';
var u310 = document.getElementById('u310');
gv_vAlignTable['u310'] = 'center';
var u117 = document.getElementById('u117');

var u378 = document.getElementById('u378');
gv_vAlignTable['u378'] = 'center';
var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
var u236 = document.getElementById('u236');
gv_vAlignTable['u236'] = 'center';
var u374 = document.getElementById('u374');

var u287 = document.getElementById('u287');

var u411 = document.getElementById('u411');

u411.style.cursor = 'pointer';
if (bIE) u411.attachEvent("onclick", Clicku411);
else u411.addEventListener("click", Clicku411, true);
function Clicku411(e)
{

if (true) {

	self.location.href="赠品捆绑管理.html" + GetQuerystring();

}

}

var u122 = document.getElementById('u122');
gv_vAlignTable['u122'] = 'center';
var u240 = document.getElementById('u240');
gv_vAlignTable['u240'] = 'center';
var u292 = document.getElementById('u292');
gv_vAlignTable['u292'] = 'center';
var u419 = document.getElementById('u419');

var u463 = document.getElementById('u463');

var u166 = document.getElementById('u166');
gv_vAlignTable['u166'] = 'center';
var u70 = document.getElementById('u70');
gv_vAlignTable['u70'] = 'center';
var u6 = document.getElementById('u6');

var u397 = document.getElementById('u397');

var u460 = document.getElementById('u460');
gv_vAlignTable['u460'] = 'top';
var u148 = document.getElementById('u148');
gv_vAlignTable['u148'] = 'center';
var u207 = document.getElementById('u207');

var u220 = document.getElementById('u220');
gv_vAlignTable['u220'] = 'center';
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

	self.location.href="#" + GetQuerystring();

}

}

var u443 = document.getElementById('u443');
gv_vAlignTable['u443'] = 'top';
var u427 = document.getElementById('u427');
gv_vAlignTable['u427'] = 'top';
var u225 = document.getElementById('u225');

var u46 = document.getElementById('u46');
gv_vAlignTable['u46'] = 'center';
var u382 = document.getElementById('u382');

u382.style.cursor = 'pointer';
if (bIE) u382.attachEvent("onclick", Clicku382);
else u382.addEventListener("click", Clicku382, true);
function Clicku382(e)
{

if (true) {

	self.location.href="市场活动审核.html" + GetQuerystring();

}

}

var u150 = document.getElementById('u150');
gv_vAlignTable['u150'] = 'center';
var u230 = document.getElementById('u230');
gv_vAlignTable['u230'] = 'center';
var u39 = document.getElementById('u39');
gv_vAlignTable['u39'] = 'center';
var u329 = document.getElementById('u329');

var u274 = document.getElementById('u274');
gv_vAlignTable['u274'] = 'center';
var u165 = document.getElementById('u165');

var u462 = document.getElementById('u462');
gv_vAlignTable['u462'] = 'top';
var u269 = document.getElementById('u269');

var u130 = document.getElementById('u130');
gv_vAlignTable['u130'] = 'center';
var u315 = document.getElementById('u315');

var u55 = document.getElementById('u55');

var u95 = document.getElementById('u95');

var u196 = document.getElementById('u196');
gv_vAlignTable['u196'] = 'center';
var u254 = document.getElementById('u254');
gv_vAlignTable['u254'] = 'center';
var u346 = document.getElementById('u346');

var u337 = document.getElementById('u337');

var u442 = document.getElementById('u442');

var u364 = document.getElementById('u364');
gv_vAlignTable['u364'] = 'center';
var u359 = document.getElementById('u359');

u359.style.cursor = 'pointer';
if (bIE) u359.attachEvent("onclick", Clicku359);
else u359.addEventListener("click", Clicku359, true);
function Clicku359(e)
{

if (true) {

	self.location.href="供应商管理.html" + GetQuerystring();

}

}

var u375 = document.getElementById('u375');
gv_vAlignTable['u375'] = 'center';
var u105 = document.getElementById('u105');

var u234 = document.getElementById('u234');
gv_vAlignTable['u234'] = 'center';
var u372 = document.getElementById('u372');

var u64 = document.getElementById('u64');
gv_vAlignTable['u64'] = 'center';
var u328 = document.getElementById('u328');
gv_vAlignTable['u328'] = 'center';
var u103 = document.getElementById('u103');

var u452 = document.getElementById('u452');

var u89 = document.getElementById('u89');

var u100 = document.getElementById('u100');
gv_vAlignTable['u100'] = 'center';
var u286 = document.getElementById('u286');
gv_vAlignTable['u286'] = 'center';
var u219 = document.getElementById('u219');

var u410 = document.getElementById('u410');
gv_vAlignTable['u410'] = 'center';
var u453 = document.getElementById('u453');
gv_vAlignTable['u453'] = 'top';
var u134 = document.getElementById('u134');
gv_vAlignTable['u134'] = 'center';
var u461 = document.getElementById('u461');

var u418 = document.getElementById('u418');

var u291 = document.getElementById('u291');

var u395 = document.getElementById('u395');

var u441 = document.getElementById('u441');
gv_vAlignTable['u441'] = 'top';
var u214 = document.getElementById('u214');
gv_vAlignTable['u214'] = 'center';
var u308 = document.getElementById('u308');
gv_vAlignTable['u308'] = 'center';
var u149 = document.getElementById('u149');

var u299 = document.getElementById('u299');

var u41 = document.getElementById('u41');
gv_vAlignTable['u41'] = 'center';
var u170 = document.getElementById('u170');
gv_vAlignTable['u170'] = 'center';
var u58 = document.getElementById('u58');
gv_vAlignTable['u58'] = 'center';
var u45 = document.getElementById('u45');

var u73 = document.getElementById('u73');

var u303 = document.getElementById('u303');

var u144 = document.getElementById('u144');
gv_vAlignTable['u144'] = 'center';
var u433 = document.getElementById('u433');
gv_vAlignTable['u433'] = 'top';
var u98 = document.getElementById('u98');
gv_vAlignTable['u98'] = 'center';
var u238 = document.getElementById('u238');
gv_vAlignTable['u238'] = 'center';
var u178 = document.getElementById('u178');
gv_vAlignTable['u178'] = 'center';
var u224 = document.getElementById('u224');
gv_vAlignTable['u224'] = 'center';
var u393 = document.getElementById('u393');

var u381 = document.getElementById('u381');
gv_vAlignTable['u381'] = 'center';
var u233 = document.getElementById('u233');

var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u255 = document.getElementById('u255');

var u456 = document.getElementById('u456');
gv_vAlignTable['u456'] = 'top';
var u389 = document.getElementById('u389');

var u50 = document.getElementById('u50');

var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u273 = document.getElementById('u273');

var u322 = document.getElementById('u322');
gv_vAlignTable['u322'] = 'center';
var u90 = document.getElementById('u90');
gv_vAlignTable['u90'] = 'center';
var u8 = document.getElementById('u8');

u8.style.cursor = 'pointer';
if (bIE) u8.attachEvent("onclick", Clicku8);
else u8.addEventListener("click", Clicku8, true);
function Clicku8(e)
{

if (true) {

	self.location.href="产品查询.html" + GetQuerystring();

}

}

var u394 = document.getElementById('u394');
gv_vAlignTable['u394'] = 'center';
var u268 = document.getElementById('u268');
gv_vAlignTable['u268'] = 'center';
var u327 = document.getElementById('u327');

var u252 = document.getElementById('u252');
gv_vAlignTable['u252'] = 'center';
var u26 = document.getElementById('u26');

var u182 = document.getElementById('u182');
gv_vAlignTable['u182'] = 'center';
var u309 = document.getElementById('u309');

var u379 = document.getElementById('u379');

u379.style.cursor = 'pointer';
if (bIE) u379.attachEvent("onclick", Clicku379);
else u379.addEventListener("click", Clicku379, true);
function Clicku379(e)
{

if (true) {

	self.location.href="市场活动管理.html" + GetQuerystring();

}

}

var u446 = document.getElementById('u446');

var u341 = document.getElementById('u341');

var u363 = document.getElementById('u363');

var u203 = document.getElementById('u203');

var u426 = document.getElementById('u426');

var u241 = document.getElementById('u241');

var u232 = document.getElementById('u232');
gv_vAlignTable['u232'] = 'center';
var u172 = document.getElementById('u172');
gv_vAlignTable['u172'] = 'center';
var u361 = document.getElementById('u361');
gv_vAlignTable['u361'] = 'center';
var u317 = document.getElementById('u317');

var u358 = document.getElementById('u358');
gv_vAlignTable['u358'] = 'center';
var u455 = document.getElementById('u455');
gv_vAlignTable['u455'] = 'top';
var u173 = document.getElementById('u173');

var u398 = document.getElementById('u398');
gv_vAlignTable['u398'] = 'center';
var u115 = document.getElementById('u115');

var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'center';
var u162 = document.getElementById('u162');
gv_vAlignTable['u162'] = 'center';
var u81 = document.getElementById('u81');

var u285 = document.getElementById('u285');

var u422 = document.getElementById('u422');

u422.style.cursor = 'pointer';
if (bIE) u422.attachEvent("onclick", Clicku422);
else u422.addEventListener("click", Clicku422, true);
function Clicku422(e)
{

if (true) {

	self.location.href="03.选用供应商品.html" + GetQuerystring();

}

}

var u406 = document.getElementById('u406');

var u67 = document.getElementById('u67');

var u146 = document.getElementById('u146');
gv_vAlignTable['u146'] = 'center';
var u113 = document.getElementById('u113');

var u251 = document.getElementById('u251');

var u121 = document.getElementById('u121');

var u151 = document.getElementById('u151');

var u298 = document.getElementById('u298');
gv_vAlignTable['u298'] = 'center';
var u177 = document.getElementById('u177');

var u448 = document.getElementById('u448');

var u301 = document.getElementById('u301');

var u142 = document.getElementById('u142');
gv_vAlignTable['u142'] = 'center';
var u159 = document.getElementById('u159');

var u227 = document.getElementById('u227');

var u29 = document.getElementById('u29');
gv_vAlignTable['u29'] = 'top';
var u44 = document.getElementById('u44');
gv_vAlignTable['u44'] = 'center';
var u24 = document.getElementById('u24');

var u84 = document.getElementById('u84');
gv_vAlignTable['u84'] = 'center';
var u76 = document.getElementById('u76');
gv_vAlignTable['u76'] = 'center';
var u223 = document.getElementById('u223');

var u157 = document.getElementById('u157');

var u218 = document.getElementById('u218');
gv_vAlignTable['u218'] = 'center';
var u267 = document.getElementById('u267');

var u320 = document.getElementById('u320');
gv_vAlignTable['u320'] = 'center';
var u388 = document.getElementById('u388');

u388.style.cursor = 'pointer';
if (bIE) u388.attachEvent("onclick", Clicku388);
else u388.addEventListener("click", Clicku388, true);
function Clicku388(e)
{

if (true) {

	self.location.href="赠品退库审核.html" + GetQuerystring();

}

}

var u405 = document.getElementById('u405');

u405.style.cursor = 'pointer';
if (bIE) u405.attachEvent("onclick", Clicku405);
else u405.addEventListener("click", Clicku405, true);
function Clicku405(e)
{

if (true) {

	self.location.href="商品转赠品管理.html" + GetQuerystring();

}

}

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
gv_vAlignTable['u272'] = 'center';
var u38 = document.getElementById('u38');

var u53 = document.getElementById('u53');

var u250 = document.getElementById('u250');
gv_vAlignTable['u250'] = 'center';
var u49 = document.getElementById('u49');
gv_vAlignTable['u49'] = 'center';
var u93 = document.getElementById('u93');

var u326 = document.getElementById('u326');
gv_vAlignTable['u326'] = 'center';
var u194 = document.getElementById('u194');
gv_vAlignTable['u194'] = 'center';
var u357 = document.getElementById('u357');

var u265 = document.getElementById('u265');

var u189 = document.getElementById('u189');

var u339 = document.getElementById('u339');
gv_vAlignTable['u339'] = 'top';
var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
var u156 = document.getElementById('u156');
gv_vAlignTable['u156'] = 'center';
var u62 = document.getElementById('u62');
gv_vAlignTable['u62'] = 'center';
var u409 = document.getElementById('u409');

var u354 = document.getElementById('u354');

var u79 = document.getElementById('u79');

var u403 = document.getElementById('u403');

var u243 = document.getElementById('u243');

var u127 = document.getElementById('u127');

var u404 = document.getElementById('u404');
gv_vAlignTable['u404'] = 'center';
var u297 = document.getElementById('u297');

var u247 = document.getElementById('u247');

var u111 = document.getElementById('u111');

var u145 = document.getElementById('u145');

var u436 = document.getElementById('u436');

var u183 = document.getElementById('u183');

var u429 = document.getElementById('u429');
gv_vAlignTable['u429'] = 'top';
var u176 = document.getElementById('u176');
gv_vAlignTable['u176'] = 'center';
var u71 = document.getElementById('u71');

var u200 = document.getElementById('u200');
gv_vAlignTable['u200'] = 'center';
var u396 = document.getElementById('u396');

u396.style.cursor = 'pointer';
if (bIE) u396.attachEvent("onclick", Clicku396);
else u396.addEventListener("click", Clicku396, true);
function Clicku396(e)
{

if (true) {

	self.location.href="赠品管理_1.html" + GetQuerystring();

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

var u423 = document.getElementById('u423');
gv_vAlignTable['u423'] = 'center';
var u158 = document.getElementById('u158');
gv_vAlignTable['u158'] = 'center';
var u204 = document.getElementById('u204');
gv_vAlignTable['u204'] = 'center';
var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u155 = document.getElementById('u155');

var u249 = document.getElementById('u249');

var u235 = document.getElementById('u235');

var u47 = document.getElementById('u47');
gv_vAlignTable['u47'] = 'top';
var u392 = document.getElementById('u392');
gv_vAlignTable['u392'] = 'center';
var u413 = document.getElementById('u413');
gv_vAlignTable['u413'] = 'center';
var u87 = document.getElementById('u87');

var u266 = document.getElementById('u266');
gv_vAlignTable['u266'] = 'center';
var u91 = document.getElementById('u91');

var u7 = document.getElementById('u7');

var u110 = document.getElementById('u110');
gv_vAlignTable['u110'] = 'center';
var u271 = document.getElementById('u271');

var u307 = document.getElementById('u307');

var u174 = document.getElementById('u174');
gv_vAlignTable['u174'] = 'center';
var u279 = document.getElementById('u279');

var u141 = document.getElementById('u141');

var u325 = document.getElementById('u325');

var u56 = document.getElementById('u56');
gv_vAlignTable['u56'] = 'center';
var u125 = document.getElementById('u125');

var u263 = document.getElementById('u263');

var u193 = document.getElementById('u193');

var u330 = document.getElementById('u330');
gv_vAlignTable['u330'] = 'center';
var u197 = document.getElementById('u197');

var u188 = document.getElementById('u188');
gv_vAlignTable['u188'] = 'center';
var u248 = document.getElementById('u248');
gv_vAlignTable['u248'] = 'center';
var u338 = document.getElementById('u338');
gv_vAlignTable['u338'] = 'center';
var u352 = document.getElementById('u352');
gv_vAlignTable['u352'] = 'center';
var u457 = document.getElementById('u457');

var u437 = document.getElementById('u437');
gv_vAlignTable['u437'] = 'top';
var u18 = document.getElementById('u18');

if (window.OnLoad) OnLoad();
