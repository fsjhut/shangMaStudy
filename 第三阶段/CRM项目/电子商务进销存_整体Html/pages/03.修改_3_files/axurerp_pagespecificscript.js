
var PageName = '03.修改';
var PageId = 'p6da41318ed044361a520e7c7cb50e0d0'
var PageUrl = '03.修改_3.html'
document.title = '03.修改';

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

var u62 = document.getElementById('u62');

var u195 = document.getElementById('u195');

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

var u28 = document.getElementById('u28');
gv_vAlignTable['u28'] = 'top';
var u226 = document.getElementById('u226');

var u142 = document.getElementById('u142');

var u180 = document.getElementById('u180');

var u190 = document.getElementById('u190');
gv_vAlignTable['u190'] = 'top';
var u59 = document.getElementById('u59');
gv_vAlignTable['u59'] = 'center';
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

var u104 = document.getElementById('u104');
gv_vAlignTable['u104'] = 'top';
var u93 = document.getElementById('u93');
gv_vAlignTable['u93'] = 'center';
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

var u73 = document.getElementById('u73');
gv_vAlignTable['u73'] = 'center';
var u112 = document.getElementById('u112');

var u128 = document.getElementById('u128');

var u193 = document.getElementById('u193');

var u56 = document.getElementById('u56');
gv_vAlignTable['u56'] = 'center';
var u161 = document.getElementById('u161');
gv_vAlignTable['u161'] = 'top';
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

var u206 = document.getElementById('u206');

var u173 = document.getElementById('u173');
gv_vAlignTable['u173'] = 'top';
var u90 = document.getElementById('u90');

var u40 = document.getElementById('u40');

var u163 = document.getElementById('u163');
gv_vAlignTable['u163'] = 'top';
var u179 = document.getElementById('u179');
gv_vAlignTable['u179'] = 'top';
var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
var u147 = document.getElementById('u147');
gv_vAlignTable['u147'] = 'top';
var u143 = document.getElementById('u143');
gv_vAlignTable['u143'] = 'top';
var u88 = document.getElementById('u88');

var u130 = document.getElementById('u130');

var u108 = document.getElementById('u108');

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

var u100 = document.getElementById('u100');

var u181 = document.getElementById('u181');
gv_vAlignTable['u181'] = 'top';
var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'center';
var u209 = document.getElementById('u209');

var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'top';
var u105 = document.getElementById('u105');

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

var u159 = document.getElementById('u159');
gv_vAlignTable['u159'] = 'top';
var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
var u113 = document.getElementById('u113');
gv_vAlignTable['u113'] = 'top';
var u129 = document.getElementById('u129');
gv_vAlignTable['u129'] = 'top';
var u194 = document.getElementById('u194');
gv_vAlignTable['u194'] = 'top';
var u156 = document.getElementById('u156');

var u207 = document.getElementById('u207');

u207.style.cursor = 'pointer';
if (bIE) u207.attachEvent("onclick", Clicku207);
else u207.addEventListener("click", Clicku207, true);
function Clicku207(e)
{

if (true) {

	self.location.href="修改商品.html" + GetQuerystring();

}

}

var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'center';
var u18 = document.getElementById('u18');

var u126 = document.getElementById('u126');

var u170 = document.getElementById('u170');

var u185 = document.getElementById('u185');
gv_vAlignTable['u185'] = 'top';
var u166 = document.getElementById('u166');

var u197 = document.getElementById('u197');

var u49 = document.getElementById('u49');

var u131 = document.getElementById('u131');
gv_vAlignTable['u131'] = 'top';
var u220 = document.getElementById('u220');

var u109 = document.getElementById('u109');
gv_vAlignTable['u109'] = 'top';
var u97 = document.getElementById('u97');

var u63 = document.getElementById('u63');
gv_vAlignTable['u63'] = 'center';
var u84 = document.getElementById('u84');

var u106 = document.getElementById('u106');

var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'top';
var u182 = document.getElementById('u182');

var u46 = document.getElementById('u46');

var u198 = document.getElementById('u198');

var u81 = document.getElementById('u81');

var u144 = document.getElementById('u144');

var u172 = document.getElementById('u172');

var u151 = document.getElementById('u151');
gv_vAlignTable['u151'] = 'top';
var u30 = document.getElementById('u30');

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

var u152 = document.getElementById('u152');

var u61 = document.getElementById('u61');
gv_vAlignTable['u61'] = 'center';
var u168 = document.getElementById('u168');

var u7 = document.getElementById('u7');

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u95 = document.getElementById('u95');

var u125 = document.getElementById('u125');
gv_vAlignTable['u125'] = 'top';
var u137 = document.getElementById('u137');
gv_vAlignTable['u137'] = 'top';
var u44 = document.getElementById('u44');

var u165 = document.getElementById('u165');
gv_vAlignTable['u165'] = 'top';
var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'top';
var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
var u75 = document.getElementById('u75');

var u132 = document.getElementById('u132');

var u221 = document.getElementById('u221');

var u148 = document.getElementById('u148');

var u58 = document.getElementById('u58');

var u140 = document.getElementById('u140');

var u183 = document.getElementById('u183');
gv_vAlignTable['u183'] = 'top';
var u199 = document.getElementById('u199');

var u42 = document.getElementById('u42');

var u145 = document.getElementById('u145');
gv_vAlignTable['u145'] = 'top';
var u191 = document.getElementById('u191');

u191.style.cursor = 'pointer';
if (bIE) u191.attachEvent("onclick", Clicku191);
else u191.addEventListener("click", Clicku191, true);
function Clicku191(e)
{

if (true) {

	self.location.href="B2B更换货管理.html" + GetQuerystring();

}

}

var u103 = document.getElementById('u103');
gv_vAlignTable['u103'] = 'center';
var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u153 = document.getElementById('u153');
gv_vAlignTable['u153'] = 'top';
var u169 = document.getElementById('u169');
gv_vAlignTable['u169'] = 'top';
var u196 = document.getElementById('u196');

var u201 = document.getElementById('u201');
gv_vAlignTable['u201'] = 'top';
var u127 = document.getElementById('u127');
gv_vAlignTable['u127'] = 'top';
var u160 = document.getElementById('u160');

var u39 = document.getElementById('u39');
gv_vAlignTable['u39'] = 'center';
var u70 = document.getElementById('u70');
gv_vAlignTable['u70'] = 'center';
var u120 = document.getElementById('u120');

var u187 = document.getElementById('u187');
gv_vAlignTable['u187'] = 'top';
var u87 = document.getElementById('u87');
gv_vAlignTable['u87'] = 'center';
var u53 = document.getElementById('u53');
gv_vAlignTable['u53'] = 'center';
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

var u214 = document.getElementById('u214');

var u36 = document.getElementById('u36');

var u171 = document.getElementById('u171');
gv_vAlignTable['u171'] = 'top';
var u222 = document.getElementById('u222');

var u149 = document.getElementById('u149');
gv_vAlignTable['u149'] = 'top';
var u20 = document.getElementById('u20');

var u67 = document.getElementById('u67');
gv_vAlignTable['u67'] = 'center';
var u52 = document.getElementById('u52');

var u141 = document.getElementById('u141');
gv_vAlignTable['u141'] = 'top';
var u6 = document.getElementById('u6');

var u184 = document.getElementById('u184');

var u85 = document.getElementById('u85');
gv_vAlignTable['u85'] = 'center';
var u146 = document.getElementById('u146');

var u34 = document.getElementById('u34');

var u154 = document.getElementById('u154');

var u99 = document.getElementById('u99');
gv_vAlignTable['u99'] = 'top';
var u202 = document.getElementById('u202');

var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u218 = document.getElementById('u218');
gv_vAlignTable['u218'] = 'center';
var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
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

var u121 = document.getElementById('u121');
gv_vAlignTable['u121'] = 'top';
var u210 = document.getElementById('u210');

var u96 = document.getElementById('u96');
gv_vAlignTable['u96'] = 'center';
var u203 = document.getElementById('u203');

var u215 = document.getElementById('u215');
gv_vAlignTable['u215'] = 'top';
var u79 = document.getElementById('u79');
gv_vAlignTable['u79'] = 'center';
var u188 = document.getElementById('u188');

var u32 = document.getElementById('u32');

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

var u134 = document.getElementById('u134');

var u175 = document.getElementById('u175');
gv_vAlignTable['u175'] = 'top';
var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u76 = document.getElementById('u76');
gv_vAlignTable['u76'] = 'center';
var u155 = document.getElementById('u155');
gv_vAlignTable['u155'] = 'top';
var u158 = document.getElementById('u158');

var u101 = document.getElementById('u101');
gv_vAlignTable['u101'] = 'center';
var u204 = document.getElementById('u204');

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

var u60 = document.getElementById('u60');

var u117 = document.getElementById('u117');
gv_vAlignTable['u117'] = 'top';
var u51 = document.getElementById('u51');

u51.style.cursor = 'pointer';
if (bIE) u51.attachEvent("onclick", Clicku51);
else u51.addEventListener("click", Clicku51, true);
function Clicku51(e)
{

if (true) {

	self.location.href="返厂出库管理.html" + GetQuerystring();

}

}

var u150 = document.getElementById('u150');

var u43 = document.getElementById('u43');
gv_vAlignTable['u43'] = 'center';
var u114 = document.getElementById('u114');

var u89 = document.getElementById('u89');
gv_vAlignTable['u89'] = 'center';
var u174 = document.getElementById('u174');

var u26 = document.getElementById('u26');

var u219 = document.getElementById('u219');
gv_vAlignTable['u219'] = 'top';
var u124 = document.getElementById('u124');

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

var u122 = document.getElementById('u122');

var u211 = document.getElementById('u211');
gv_vAlignTable['u211'] = 'top';
var u138 = document.getElementById('u138');

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

var u92 = document.getElementById('u92');

var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u189 = document.getElementById('u189');
gv_vAlignTable['u189'] = 'top';
var u41 = document.getElementById('u41');
gv_vAlignTable['u41'] = 'center';
var u135 = document.getElementById('u135');
gv_vAlignTable['u135'] = 'top';
var u224 = document.getElementById('u224');

u224.style.cursor = 'pointer';
if (bIE) u224.attachEvent("onclick", Clicku224);
else u224.addEventListener("click", Clicku224, true);
function Clicku224(e)
{

if (true) {

	self.location.href="添加商品.html" + GetQuerystring();

}

}

var u24 = document.getElementById('u24');

var u72 = document.getElementById('u72');

var u186 = document.getElementById('u186');

var u167 = document.getElementById('u167');
gv_vAlignTable['u167'] = 'top';
var u118 = document.getElementById('u118');

var u0 = document.getElementById('u0');

var u55 = document.getElementById('u55');

var u38 = document.getElementById('u38');

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

var u110 = document.getElementById('u110');

var u102 = document.getElementById('u102');

var u50 = document.getElementById('u50');
gv_vAlignTable['u50'] = 'center';
var u86 = document.getElementById('u86');

var u223 = document.getElementById('u223');

var u115 = document.getElementById('u115');
gv_vAlignTable['u115'] = 'top';
var u69 = document.getElementById('u69');

var u216 = document.getElementById('u216');

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

var u123 = document.getElementById('u123');
gv_vAlignTable['u123'] = 'top';
var u212 = document.getElementById('u212');

var u139 = document.getElementById('u139');
gv_vAlignTable['u139'] = 'top';
var u177 = document.getElementById('u177');
gv_vAlignTable['u177'] = 'top';
var u66 = document.getElementById('u66');

var u217 = document.getElementById('u217');

u217.style.cursor = 'pointer';
if (bIE) u217.attachEvent("onclick", Clicku217);
else u217.addEventListener("click", Clicku217, true);
function Clicku217(e)
{

if (true) {

	self.location.href="B2B更换货管理.html" + GetQuerystring();

}

}

var u133 = document.getElementById('u133');
gv_vAlignTable['u133'] = 'top';
var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u136 = document.getElementById('u136');

var u225 = document.getElementById('u225');
gv_vAlignTable['u225'] = 'center';
var u157 = document.getElementById('u157');
gv_vAlignTable['u157'] = 'top';
var u33 = document.getElementById('u33');
gv_vAlignTable['u33'] = 'center';
var u107 = document.getElementById('u107');
gv_vAlignTable['u107'] = 'top';
var u98 = document.getElementById('u98');
gv_vAlignTable['u98'] = 'center';
var u16 = document.getElementById('u16');

var u119 = document.getElementById('u119');
gv_vAlignTable['u119'] = 'top';
var u208 = document.getElementById('u208');
gv_vAlignTable['u208'] = 'center';
var u64 = document.getElementById('u64');

var u164 = document.getElementById('u164');

var u111 = document.getElementById('u111');
gv_vAlignTable['u111'] = 'top';
var u200 = document.getElementById('u200');

var u192 = document.getElementById('u192');
gv_vAlignTable['u192'] = 'center';
var u176 = document.getElementById('u176');

var u47 = document.getElementById('u47');
gv_vAlignTable['u47'] = 'center';
var u82 = document.getElementById('u82');
gv_vAlignTable['u82'] = 'center';
var u116 = document.getElementById('u116');

var u205 = document.getElementById('u205');

var u78 = document.getElementById('u78');

var u31 = document.getElementById('u31');
gv_vAlignTable['u31'] = 'center';
var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u162 = document.getElementById('u162');

var u213 = document.getElementById('u213');
gv_vAlignTable['u213'] = 'top';
var u29 = document.getElementById('u29');
gv_vAlignTable['u29'] = 'top';
var u178 = document.getElementById('u178');

var u14 = document.getElementById('u14');

u14.style.cursor = 'pointer';
if (bIE) u14.attachEvent("onclick", Clicku14);
else u14.addEventListener("click", Clicku14, true);
function Clicku14(e)
{

if (true) {

}

}

if (window.OnLoad) OnLoad();
