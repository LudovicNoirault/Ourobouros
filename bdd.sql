#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: AdresseFacture
#------------------------------------------------------------

CREATE TABLE AdresseFacture(
        idAdresseFacture         int (11) Auto_increment  NOT NULL ,
        numeroAdresseFacture     Int ,
        rueAdresseFacture        Varchar (25) ,
        villeAdresseFacture      Varchar (25) ,
        codepostalAdresseFacture Int ,
        paysAdresseFacture       Varchar (25) ,
        idDevis                  Int ,
        idClient                 Int ,
        PRIMARY KEY (idAdresseFacture )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Produit
#------------------------------------------------------------

CREATE TABLE Produit(
        idProduit           int (11) Auto_increment  NOT NULL ,
        nomProduit          Varchar (25) ,
        prixUnitaireProduit Float ,
        PRIMARY KEY (idProduit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: AdresseLivraison
#------------------------------------------------------------

CREATE TABLE AdresseLivraison(
        idAdresseLivraison         int (11) Auto_increment  NOT NULL ,
        numeroAdresseLivraison     Int NOT NULL ,
        rueAdresseLivraison        Varchar (25) NOT NULL ,
        villeAdresseLivraison      Varchar (25) NOT NULL ,
        codepostalAdresseLivraison Int NOT NULL ,
        paysAdresseLivraison       Varchar (25) NOT NULL ,
        idDevis                    Int ,
        idClient                   Int ,
        PRIMARY KEY (idAdresseLivraison )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Client
#------------------------------------------------------------

CREATE TABLE Client(
        idClient           int (11) Auto_increment  NOT NULL ,
        nomClient          Varchar (25) ,
        idAdresseFacture   Int ,
        idAdresseLivraison Int ,
        nomDirigeantClient Varchar (25) ,
        idAdresseFacture_1 Int ,
        PRIMARY KEY (idClient ) ,
        INDEX (idAdresseFacture ,idAdresseLivraison )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Devis
#------------------------------------------------------------

CREATE TABLE Devis(
        idDevis            int (11) Auto_increment  NOT NULL ,
        idClient           Int ,
        idAdresseFacture   Int ,
        idAdresseLivraison Int ,
        idProduit          Int ,
        quantiteDevis      Int ,
        prixUnitaireDevis  Float ,
        idClient_1         Int ,
        idAdresseFacture_2 Int ,
        idFacture          Int ,
        PRIMARY KEY (idDevis ) ,
        INDEX (idClient ,idAdresseFacture ,idAdresseLivraison ,idProduit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Facture
#------------------------------------------------------------

CREATE TABLE Facture(
        idFacture    int (11) Auto_increment  NOT NULL ,
        idDevis      Int ,
        idClient     Int ,
        totalFacture Float ,
        idDevis_1    Int ,
        PRIMARY KEY (idFacture ) ,
        INDEX (idDevis ,idClient )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: estcomptedans
#------------------------------------------------------------

CREATE TABLE estcomptedans(
        idProduit Int NOT NULL ,
        idDevis   Int NOT NULL ,
        PRIMARY KEY (idProduit ,idDevis )
)ENGINE=InnoDB;

ALTER TABLE AdresseFacture ADD CONSTRAINT FK_AdresseFacture_idDevis FOREIGN KEY (idDevis) REFERENCES Devis(idDevis);
ALTER TABLE AdresseFacture ADD CONSTRAINT FK_AdresseFacture_idClient FOREIGN KEY (idClient) REFERENCES Client(idClient);
ALTER TABLE AdresseLivraison ADD CONSTRAINT FK_AdresseLivraison_idDevis FOREIGN KEY (idDevis) REFERENCES Devis(idDevis);
ALTER TABLE AdresseLivraison ADD CONSTRAINT FK_AdresseLivraison_idClient FOREIGN KEY (idClient) REFERENCES Client(idClient);
ALTER TABLE Client ADD CONSTRAINT FK_Client_idAdresseFacture_1 FOREIGN KEY (idAdresseFacture_1) REFERENCES AdresseFacture(idAdresseFacture);
ALTER TABLE Devis ADD CONSTRAINT FK_Devis_idClient_1 FOREIGN KEY (idClient_1) REFERENCES Client(idClient);
ALTER TABLE Devis ADD CONSTRAINT FK_Devis_idAdresseFacture_2 FOREIGN KEY (idAdresseFacture_2) REFERENCES AdresseFacture(idAdresseFacture);
ALTER TABLE Devis ADD CONSTRAINT FK_Devis_idFacture FOREIGN KEY (idFacture) REFERENCES Facture(idFacture);
ALTER TABLE Facture ADD CONSTRAINT FK_Facture_idDevis_1 FOREIGN KEY (idDevis_1) REFERENCES Devis(idDevis);
ALTER TABLE estcomptedans ADD CONSTRAINT FK_estcomptedans_idProduit FOREIGN KEY (idProduit) REFERENCES Produit(idProduit);
ALTER TABLE estcomptedans ADD CONSTRAINT FK_estcomptedans_idDevis FOREIGN KEY (idDevis) REFERENCES Devis(idDevis);
