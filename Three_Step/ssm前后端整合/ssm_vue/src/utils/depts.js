export function getDeptsTree(){
	return axios.get("/sysdept/list")
}