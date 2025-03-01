package ra.business.design.IGeneric.service;

import ra.business.design.IGeneric.IGenericService;
import ra.business.entity.Catalog;

import java.util.List;
import java.util.Scanner;

import static ra.business.design.IGeneric.service.ProductService.inputNum;
import static ra.presentation.run.BookManagement.catalogList;
import static ra.presentation.run.BookManagement.productList;


public class CatalogService implements IGenericService<Catalog, Integer> {
    static CatalogService catalogService = new CatalogService();
    @Override
    public List<Catalog> getAll() {
        return List.of();
    }

    @Override
    public void save(Catalog catalog) {
    }

    @Override
    public Catalog findById(Integer id) {
        if(catalogList.stream().anyMatch(c-> c.getCatalogId() == id)){
            return catalogList.stream().filter(c-> c.getCatalogId() == id).findFirst().get();
        }else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        if(findById(id) == null){
            System.err.println("Catalog not found");
        }else{
            if(productList.stream().anyMatch(p-> p.getCatalog().equals(findById(id)))){
                System.err.println("This catalog has products. Can't delete");
            }else{
                catalogList.remove(findById(id));
                System.err.println("Deleted successfully !");
            }
        }
    }

    public static void addCatalog(Scanner sc) {
        System.out.println("Enter the number of Catalog you want to add:");
        int number = inputNum(sc);
        for (int i = 0; i < number; i++) {
            System.out.println("Catalog #" + (i + 1) + ":");
            Catalog catalogNew = new Catalog();
            catalogNew.inputCatalog(sc);
            catalogList.add(catalogNew);
        }
        showAllCatalog();
    }

    public static void showAllCatalog() {
        if (catalogList.size() <= 0) {
            System.err.println("Catalog List is empty");
        }else {
            catalogList.forEach(Catalog::displayCatalog);
            System.out.println("---------------------------------------------------------------------------------------");
        }
    }

    public static void editCatalogById(Scanner sc) {
        showAllCatalog();
        System.out.println("Enter the id of the catalog you want to edit:");
        int id = inputNum(sc);
        if (catalogService.findById(id) != null) {
            Catalog catalogOld = catalogService.findById(id);
            catalogList.remove(catalogOld);
            Catalog catalogNew = new Catalog();
            catalogNew.inputCatalogUpdate(sc);
            catalogNew.setCatalogId(catalogOld.getCatalogId());
            catalogList.add(catalogNew);
            System.out.println("Catalog #" + id + " has been updated");
        }else {
            System.err.println("Catalog #" + id + " does not exist");
        }
        showAllCatalog();
    }

    public static void deleteCatalogById(Scanner sc) {
        showAllCatalog();
        System.out.println("Enter the id of the catalog ID you want to delete:");
        int id = inputNum(sc);
        catalogService.delete(id);
        showAllCatalog();
    }
}
