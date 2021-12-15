package es.udc.psi.citizen.data;

import es.udc.psi.citizen.domain.Model;

public class DataRepository {
    private static Model data;

    public static Model getData() {
        if (data==null)
            data = new ModelImplMock();
        return data;
    }
}
