export function getdicts(dkey){
	return axios.get("/sysdictsList/type/"+dkey);
}

export function parseDicts(dicts,cellValue){
	let lname='-';
	dicts.forEach((d,i)=>{
		let k = d.lkey;
		if(k==cellValue){
			lname= d.lname;
			return;
		}
	})
	return lname;
}