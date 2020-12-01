package presenter;

import view.ConvidarMoradorView;

public class ConvidarMoradorPresenter {
    private ConvidarMoradorView view;
    
    public ConvidarMoradorPresenter(){
        this.view = new ConvidarMoradorView();
        this.view.setVisible(true);
    }
}
