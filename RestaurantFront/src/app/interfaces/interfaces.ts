export interface Product{
    id?:number,
    name?:string,
    description?:string,
    weight?:number,
    stock?:number,
    price?:number,
    categories?:Category
    quantity?:number
}
export interface CartItem{
    id:number,
    quantity:number
}
export interface Cart{
    restaurant_id:number,
    cartItems:CartItem[]
}
export interface Category{
    id?:number,
    name?:string,
    description?:string,
    productsList?:Product[]
    
}
export interface Orders{
    id?:number,
    v_Date?:Date,
    sent?:number,
    restaurant?:Restaurant,
    
}
export interface ProductsOrders{
    id?:Id,
    orders?:Orders
    product:Product
    units:number
    
}
export interface Admin{
    mail:string,
    pwd:string
}
export interface Restaurant{
    id?:number,
    address?:string,
    city?:string,
    country?:string,
    cp?:string,
    mail?:string,
    pwd?:string,
    ordersList?:Orders[]
}
export interface Credential{
    mail?:string,
    pwd?:string
}
export interface Id{
    productId:number,
    orderId:number
}
