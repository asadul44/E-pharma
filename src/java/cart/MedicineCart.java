/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean

@SessionScoped
public class MedicineCart implements Serializable{
    private List<Item> cart = new ArrayList<>();
    private double total;
    int cartsize;
    String item = "item";

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        total=0.0;
        for(Item item:cart){
        total=total+(item.getQuantity()*item.getP().getProPrice());
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCartsize() {
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public String getItem() {
          if(cartsize > 1)
            item = "items";
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
      public String addToCart(Product p){
        System.out.println("Add to Cart..................");
        if(cart.size() > 0){
            for (Item item : cart){
                if(item.getP().getProId()==(p.getProId())){
                    item.setQuantity(item.getQuantity() + 1);
                    return "cart";
                    
                }
            }
        }
        Item i = new Item();
        i.setQuantity(1);
        i.setP(p);
        cart.add(i);
        System.out.println(i.getP().getProName() + " 1 item added..................");
        return "cart";
    }
        public void removeFromCart(Item i){
        for(Item item: cart){
            if(item.equals(i)){
                cart.remove(i);
                break;
            }
        }
    }
    
    public void updateCart(){
           
    }
    
    public String payment(){
        return "payment";
    }
}
