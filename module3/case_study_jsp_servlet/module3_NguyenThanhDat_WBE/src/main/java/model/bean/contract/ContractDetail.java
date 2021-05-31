package model.bean.contract;

public class ContractDetail {
    private int id;
    private int idContract;
    private int idServiceAttach;
    private int quality;

    public ContractDetail() {
    }

    public ContractDetail(int id, int idContract, int idServiceAttach, int quality) {
        this.id = id;
        this.idContract = idContract;
        this.idServiceAttach = idServiceAttach;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdServiceAttach() {
        return idServiceAttach;
    }

    public void setIdServiceAttach(int idServiceAttach) {
        this.idServiceAttach = idServiceAttach;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
