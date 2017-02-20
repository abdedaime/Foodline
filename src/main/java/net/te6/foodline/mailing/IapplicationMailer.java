package net.te6.foodline.mailing;

import net.te6.foodline.models.Snack;


public interface IapplicationMailer  {

    public void sendMailNewAccount(Snack snack)throws  Exception;

}
