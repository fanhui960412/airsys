function updateUser(id){
	
}

function deleteUser(id){
	isDelete=confirm("您确认删除这条记录么")
		if(isDelete){
			window.location.href="deleteuser/"+id
		}
}