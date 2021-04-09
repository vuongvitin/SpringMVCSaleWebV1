/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function deleteProduct(productId) {
    if (confirm("Bạn chắc chắn xóa không?") == true) { 
        fetch(`/SaleApp/api/products/${productId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            if (res.status == 200) {
                let d = document.getElementById(`product${productId}`);
                d.style.display = "none";
            } else 
                alert("Something wrong!!!");
        })
    }
}


