var newName=$(".new-name")
var newPrice=$(".new-price")
var create=$(".create")
var del=$(".delete")
var update=$(".update")
var next=$(".next")
var previous=$(".previous")
create.click(function(){
	$.ajax({
		type : "post",
		url : "add",
		dataType: 'json',
		data:{"name":newName.val(),"price":parseFloat( newPrice.val())},
		success : function(data) {
			window.location.reload()
		}
	});
	}	
)
del.on("click",function(){
    $.ajax({
		type : "post",
		url : "delete",
		dataType: 'json',
		data:{"id":parseFloat($(this).parent().parent().find(".id").text())},
		success : function(data) {
			window.location.reload()
		}
	});
    
});

update.on("click",function(){
    $.ajax({
		type : "post",
		url : "update",
		dataType: 'json',
		data:{
			"id":parseFloat($(this).parent().parent().find(".id").text()),
			"name":$(this).parent().parent().find(".name").val(),
			"price":parseFloat($(this).parent().parent().find(".price").val())
		},
		success : function(data) {
			window.location.reload()
		}
	});
    
});

next.click(function(){
	setPage(1)
})


previous.click(function(){
	setPage(-1)
})

function setPage(offset){
	$.ajax({
		type : "post",
		url : "setpage",
		dataType: 'json',
		data:{"pageOffset":offset},
		success : function(data) {
			window.location.reload()
		}
	});
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/HaoNanLa/crm-app.git
}
