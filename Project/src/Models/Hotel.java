package Models;

/**
 *
 * @author juan
 */
public class Hotel {

    private int id;
    private String nameHotel;
    private String adress;
    private String classification;
    //hotel ame  example: games room, jacuzzi etc.
    private String modCons;
    private String pictures;
    private int idCity;

    public Hotel(int id, String nameHotel, String adress, String classification, String modCons, String pictures, int idCity) {
        this.id = id;
        this.nameHotel = nameHotel;
        this.adress = adress;
        this.classification = classification;
        this.modCons = modCons;
        this.pictures = pictures;
        this.idCity = idCity;
    }

    @Override
    public String toString() {
        return   "Nombre: "+this.nameHotel+" ID: "+this.id;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getModCons() {
        return modCons;
    }

    public void setModCons(String modCons) {
        this.modCons = modCons;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }
    
}
