function editCart(cartItemId,buyCount){
    window.location.href='cart.do?operate=editCart&cartItemId='+cartItemId+"&buyCount="+buyCount;
}
function cleanCart(){
    if(confirm('是否确认清空购物车？')){
        window.location.href='cart.do?operate=cleanCart';
    }
}
function settlement(){
    if(confirm('是否结算？')){
        window.location.href='cart.do?operate=checkoutCart';
    }
}