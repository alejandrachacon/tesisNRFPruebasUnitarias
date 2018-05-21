package tesis.tesisnrf;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ValidarCliente {

    private DataService dataService;

    public ValidarCliente(DataService dataService){

        this.dataService = dataService;

    }

    public boolean validateClientFields(){

            ClienteDTO clienteDTO = (ClienteDTO) dataService.retrieveClient();
            if(clienteDTO.getEmail().contentEquals("test@email.com")){
                return true;
            }else{
                return false;
            }
    }


    public String getMensajeSolicitudCanada() {
        ClienteDTO clienteDTO = (ClienteDTO) dataService.retrieveClient();

        return  "Hi! This is an automatic message to inform you that "+clienteDTO.getName()+" in " + dataService.getLocation() +
                " has requested an "+ dataService.getTypeOfMatter() + " matter in "+ dataService.getMatterField() +". Please check the platform for further information. Thanks! ";
    }
}
