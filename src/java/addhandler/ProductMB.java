/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.AddDao;
import dao.ListDao;
import entity.Product;
import entity.SubCategory;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;




/**
 *
 * @author HP
 */
@ManagedBean
@SessionScoped
public class ProductMB {

    Product product = new Product();
    SubCategory subcat = new SubCategory();
    String subcatname;
    String catname = "";
    List<SubCategory> listSubCat;
    UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public List<SubCategory> getListSubCat() {
        return listSubCat;
    }

    public void setListSubCat(List<SubCategory> listSubCat) {
        this.listSubCat = listSubCat;
    }

    public String addProduct() {
        upload();
        listSubCat = new ListDao().subcatListByName(subcatname);
        //System.out.println(listCat.get(0).getCatId());
        subcat.setSubCatId(listSubCat.get(0).getSubCatId());
        product.setSubCategory(subcat);
        product.setSubCategory(subcat);
        product.setProName(product.getProName());
        product.setProQty(product.getProQty());
        product.setProPrice(product.getProPrice());
        product.setProUrl(product.getProUrl());
        product.setProDesc(product.getProDesc());
        boolean status = new AddDao().addProduct(product);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data not Saved", ""));

        }
        return null;
    }

    public void upload() {

        if (file != null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
                String dbpath = servletContext.getRealPath("/");
                String webcat = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                String buildcat = webcat.substring(0, webcat.lastIndexOf("\\"));
                String mainURLPath = buildcat.substring(0, buildcat.lastIndexOf("\\"));

                InputStream inputStream = file.getInputstream();
                String path = mainURLPath + "\\web\\resources\\images\\" + file.getFileName();

                File destFile = new File(path);
                if (!destFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputStream, destFile);
                     System.err.println("An IOException was caught :" + inputStream);
                }
                product.setProUrl(file.getFileName().toString());
            } catch (Exception e) {
                e.printStackTrace();

            }

        }
    }

    public List<SelectItem> getSubCategoryName() {
        List<SelectItem> subcatname = new ListDao().subcatList(catname);

        return subcatname;
    }
}
