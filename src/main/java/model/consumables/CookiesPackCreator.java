package model.consumables;

import model.Cart;

import java.util.Iterator;
import java.util.List;

public class CookiesPackCreator {

    public CookiesPackCreator(){

    }

    /**
     * You got some cookies to put many times so I need this method
     * @param currentCookie some cookie to dd to the pack
     * @param pack the named pack
     * @param nbCookies yhe number of cookies to add
     * @param currentNumberOfCookies the number of cookies already added
     * @return
     */
    public int addingCookiesToPack(Cart cart ,Consumable currentCookie ,CookiesPack pack,int nbCookies, int currentNumberOfCookies){
        int a=currentNumberOfCookies;
        if (nbCookies > 1) {
            a =currentNumberOfCookies+ (nbCookies-1) ;
        }
        pack.addConsumablesToPack(currentCookie, nbCookies);

        return a;
    }



    /**
     * Helping you to create some packs
     * @param cart the cart which contains cookies
     * @param nbCookiesToCreatePack as its name said
     * @param packPrice one more time as its name said
     *
     */
    public void createPack(Cart cart, int nbCookiesToCreatePack, double packPrice) throws CloneNotSupportedException {
        int cookies = cart.getNbCookiesDirectlyInTheCart();

            try {
                //THis is the biggest pack you can ever get

                if (cart.getNbCookies() > nbCookiesToCreatePack) { // Check if there is enough cookie to build this pack
                    CookiesPack pack = new CookiesPack(nbCookiesToCreatePack, packPrice); //So we create a new pack
                    Cart secondCart = cart.clone();
                    Iterator<Consumable> it = secondCart.getItems().keySet().iterator();
                    for (int i = 0; i < nbCookiesToCreatePack; i++) {

                        Consumable currentCookie = it.next();//Running the pack

                        int nbThisCookie = cart.getItems().get(currentCookie);
                        int nbCookiesNeededToCompleteThePAck = (nbCookiesToCreatePack - i);

                        if (currentCookie.isCookie()) {
                            if (cart.getItems().get(currentCookie) <= nbCookiesNeededToCompleteThePAck) {//If there is not too much of this type of cookies for the pack


                                i = addingCookiesToPack(cart, currentCookie, pack, nbThisCookie, i); // adding cookies to pack
                                cart.getItems().remove(currentCookie); //removing  them from the cart
                                cookies -= nbThisCookie;//Getting the number of cookies down by
                            } else if (cart.getItems().get(currentCookie) > nbCookiesNeededToCompleteThePAck) {

                                i = addingCookiesToPack(cart, currentCookie, pack, nbCookiesNeededToCompleteThePAck, i);
                                cart.getItems().replace(currentCookie, nbThisCookie, (nbThisCookie - nbCookiesNeededToCompleteThePAck));
                                cookies -= nbCookiesNeededToCompleteThePAck;
                            }
                        } else if (!currentCookie.isCookie()) {
                            nbCookiesToCreatePack++;
                        }


                    }

                    cart.addConsumables(pack, 1);

                }

                cart.setNbCookiesDirectlyInTheCart(cookies);
                cart.recalculateFinalPrice();
            }
            catch (CloneNotSupportedException e){
                e.printStackTrace();
            }
    }


    public void createAllPossiblePacks(Cart cart, List<PackComposition> packCompositions) throws CloneNotSupportedException {

        int nbPacks = packCompositions.size();
        while (cart.getNbCookiesDirectlyInTheCart() >packCompositions.get(0).getCookiesNumber()) {

            for ( int i= nbPacks; i>0 ; i=i-1) {
                createPack(cart,packCompositions.get( i- 1).getCookiesNumber(),packCompositions.get( nbPacks- 1).getPackPrice());
            }


       }
    }
}
