package br.ufac.sgcmapi.model;

public enum EStatus {

    CANCELADO,
    AGENDADO,
    CONFIRMADO,
    CHEGADA,
    ATENDIMENTO,
    ENCERRADO;

    public EStatus proximo() {
        EStatus status = this;
        int index = ordinal();
        if(index > 0){
            index++;
            if( index<values().length){
                status = values()[index];
            }
        }       
        return status;
    }
    
}
