package main.patterns.mapper;

import main.patterns.domain.Client;
import main.patterns.dto.ClientDTO;

public class ClientToDTOMapper {

    public ClientDTO map(final Client client) {
        final ClientDTO clientDTO = new ClientDTO();
        if (client != null) {
            clientDTO.setClientId(client.getId())
                    .setStatus(client.getStatus())
                    .setName(client.getName())
                    .setSurname(client.getSurname())
                    .setDaysStaying(client.getDaysStaying());
        }
        return clientDTO;
    }
}
