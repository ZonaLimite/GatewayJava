import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import util.CallerRunSystem;
import util.CreaReporte;
import util.PreparaFormatIni;



@Path("/services")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class MiService {

	
	@GET
    @Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        return Response.ok().entity("{Service online:yes}").build();
    }
	
	@GET
	@Path("/Report-GET")
	@Produces(MediaType.APPLICATION_JSON)
	public Response SolicitarInforme(@QueryParam("Informe") String maskReport ,@QueryParam("EnviarSIE") String okSIE,@QueryParam("TipoAutomatizacion") String tipoAut) {

		CreaReporte cr = new CreaReporte(maskReport,okSIE,tipoAut);
		return Response.ok().entity("Solicitado Informe :"+maskReport).build();
	}
	

}
