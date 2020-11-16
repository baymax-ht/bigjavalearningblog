package power.work.bean;

public class Food {
    private Integer id;
    private String name;
    private Double price;
    private String imagepath;
    public Food(){}
    public Food(Integer id, String name, Double price, String imagepath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagepath = imagepath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imagepath='" + imagepath + '\'' +
                '}';
    }
}
