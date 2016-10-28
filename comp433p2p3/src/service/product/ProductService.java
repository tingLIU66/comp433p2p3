package service.product;

import java.util.Set;

import javax.jws.WebService;

import service.representation.product.ProductRepresentation;
import service.representation.product.ProductRequest;

@WebService
public interface ProductService {

	public Set<ProductRepresentation> searchProduct(String productName);

	public ProductRepresentation getProduct(int productId);

	public ProductRepresentation addProduct(ProductRequest productRequest);

	// public Response updateEmployee(EmployeeRequest employeeRequest);
	// public Response deleteEmployee(String employeeId);

}
