package service.resource.product;

import java.util.List;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import service.representation.product.ProductRepresentation;
import service.representation.product.ProductRequest;
import service.workflow.ProductActivity;

@Path("/productservice/")
public class ProductResource implements ProductService {

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/products/{productname}")
  
	public Set<ProductRepresentation> searchProduct(@PathParam("productname") String productName) {
		
		System.out.println("GET METHOD Request for all Products ............." + productName);
		ProductActivity pdtActivity = new ProductActivity();
		return pdtActivity.searchProduct(productName);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/product/{productId}")
	public ProductRepresentation getProduct(@PathParam("productId") int id) {
		System.out.println("GET METHOD Request from Client with ProductRequest String ............." + id);
		ProductActivity pdtActivity = new ProductActivity();
		return pdtActivity.getProduct(id);
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/product")
	public ProductRepresentation addProduct(ProductRequest ProductRequest) {
		System.out.println("POST METHOD Request from Client with ............." 
				+ ProductRequest.getProductname()+ "  "
						+ ProductRequest.getProductdecription()+ "  "
								+ ProductRequest.getProductprice()+ "  "
										+ ProductRequest.getProductownerID()+ "  "
												+ ProductRequest.getProductownerID() + "  "
												+ ProductRequest.getProductquantity());
		ProductActivity pdtActivity = new ProductActivity();
		return pdtActivity.addProduct(ProductRequest.getProductname(), ProductRequest.getProductdecription(), ProductRequest.getProductprice(),
				ProductRequest.getProductownerID(), ProductRequest.getProductquantity());
	}
	
	

	@DELETE
	@Produces({ "application/xml", "application/json" })
	@Path("/product/{ProductId}")
	public Response deleteProduct(@PathParam("ProductId") int id) {
		System.out.println("Delete METHOD Request from Client with ProductRequest String ............." + id);
		ProductActivity pdtActivity = new ProductActivity();
		String res = pdtActivity.deleteProduct(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}



}
