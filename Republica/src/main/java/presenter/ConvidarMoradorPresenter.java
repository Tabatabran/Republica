package presenter;

import view.ConvidarMoradorView;

public class ConvidarMoradorPresenter {
    private ConvidarMoradorView view;
    
    public ConvidarMoradorPresenter(){
        this.view = new ConvidarMoradorView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setVisible(true);
    }
}
