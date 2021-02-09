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
    restaurant?:Restaurant
    
}
export interface Order{
    id?:number,
    order:Orders
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
    pwd?:string
}
export interface Credential{
    mail?:string,
    pwd?:string
}
