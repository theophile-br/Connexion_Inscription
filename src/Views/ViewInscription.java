package Views;

import Controllers.ControllerInscription;
import Models.ModelUser;
import Tools.NodeIniter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Hashtable;

public class ViewInscription {
    private Group root;
    private Text titleFormulaire;
    private Label lblLogin, lblMotDePasse, lblNom,lblPrenom,lblAdresse, lblCodePostal,lblVille,lblEmail;
    private TextField fieldLogin, fieldNom,fieldPrenom, fieldAdresse,fieldCodePostal, fieldVille, fieldEmail;
    private PasswordField fieldMotDePasse;
    private Hashtable<Integer,TextField> listTextFiled = new Hashtable<Integer,TextField>();
    private Button btnValider;
    private VBox vBoxMainContainer;

    ViewInscription(Group root){
        this.root=root;

        initElementOfTheView();

        clearAndInitRoot();
    }

    void initElementOfTheView(){

        titleFormulaire = NodeIniter.initTitle("Inscription");

        lblLogin = NodeIniter.initLabel("Login :");
        fieldLogin = NodeIniter.initTextField();
        listTextFiled.put(ModelUser.KEY_LOGIN, fieldLogin);

        lblMotDePasse = NodeIniter.initLabel("Mot de passe :");
        fieldMotDePasse = NodeIniter.initPasswordField();
        listTextFiled.put(ModelUser.KEY_MDP, fieldMotDePasse);

        lblNom = NodeIniter.initLabel("Nom :");
        fieldNom = NodeIniter.initTextField();
        listTextFiled.put(ModelUser.KEY_NOM, fieldNom);

        lblPrenom = NodeIniter.initLabel("Prenom :");
        fieldPrenom = NodeIniter.initTextField();
        listTextFiled.put(ModelUser.KEY_PRENOM, fieldPrenom);

        lblAdresse = NodeIniter.initLabel("Adresse :");
        fieldAdresse = NodeIniter.initTextField();
        listTextFiled.put(ModelUser.KEY_ADRESSE, fieldAdresse);

        lblCodePostal = NodeIniter.initLabel("Code Postal :");
        fieldCodePostal = NodeIniter.initTextField();
        listTextFiled.put(ModelUser.KEY_CODE_VILLE, fieldCodePostal);

        lblVille = NodeIniter.initLabel("Ville :");
        fieldVille = NodeIniter.initTextField();
        listTextFiled.put(ModelUser.KEY_VILLE, fieldVille);

        lblEmail = NodeIniter.initLabel("E-Mail :");
        fieldEmail = NodeIniter.initTextField();
        listTextFiled.put(ModelUser.KEY_EMAIL, fieldEmail);

        btnValider = NodeIniter.initButton("Valider");
        btnValider.disarm();

        addToVBox();

    }

    void addToVBox(){
        vBoxMainContainer = NodeIniter.initVBox();
        vBoxMainContainer.getChildren().add(titleFormulaire);
        vBoxMainContainer.getChildren().add(NodeIniter.initLabelAndFieldHBox(lblLogin,fieldLogin));
        vBoxMainContainer.getChildren().add(NodeIniter.initLabelAndFieldHBox(lblMotDePasse,fieldMotDePasse));
        vBoxMainContainer.getChildren().add(NodeIniter.initLabelAndFieldHBox(lblNom,fieldNom));
        vBoxMainContainer.getChildren().add(NodeIniter.initLabelAndFieldHBox(lblPrenom,fieldPrenom));
        vBoxMainContainer.getChildren().add(NodeIniter.initLabelAndFieldHBox(lblAdresse,fieldAdresse));
        vBoxMainContainer.getChildren().add(NodeIniter.initLabelAndFieldHBox(lblCodePostal,fieldCodePostal));
        vBoxMainContainer.getChildren().add(NodeIniter.initLabelAndFieldHBox(lblVille,fieldVille));
        vBoxMainContainer.getChildren().add(NodeIniter.initLabelAndFieldHBox(lblEmail,fieldEmail));
        vBoxMainContainer.getChildren().add(btnValider);
    }

    void clearAndInitRoot(){
        root.getChildren().clear();
        root.getChildren().add(vBoxMainContainer);
    }

    void setEvents(ControllerInscription controllerInscription){
        btnValider.setOnMouseClicked(controllerInscription);
    }

    public TextField getFieldMotDePasse() {
        return fieldMotDePasse;
    }

    public Button getBtnValider() {
        return btnValider;
    }

    public Hashtable<Integer,TextField> getListTextField() {
        return listTextFiled;
    }
}
