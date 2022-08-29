package module;

public class ContractDetail {
    private int contractDetailId;
    private int contractId;
    private int attachId;
    private int contractDetailQuantity;


    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, int contractId, int attachId, int contractDetailQuantity) {
        this.contractDetailId = contractDetailId;
        this.contractId = contractId;
        this.attachId = attachId;
        this.contractDetailQuantity = contractDetailQuantity;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getAttachId() {
        return attachId;
    }

    public void setAttachId(int attachId) {
        this.attachId = attachId;
    }

    public int getContractDetailQuantity() {
        return contractDetailQuantity;
    }

    public void setContractDetailQuantity(int contractDetailQuantity) {
        this.contractDetailQuantity = contractDetailQuantity;
    }
}
