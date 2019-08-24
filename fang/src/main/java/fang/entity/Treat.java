package fang.entity;

import javax.persistence.*;

@Entity
@Table(name = "daily_treats")
public class Treat extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Daily daily;
    String region;

    @Column(name = "house_totla")
    int houseTotal;
    @Column(name = "house_area")
    float houseArea;

    public Treat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getHouseTotal() {
        return houseTotal;
    }

    public void setHouseTotal(int houseTotal) {
        this.houseTotal = houseTotal;
    }

    public float getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(float houseArea) {
        this.houseArea = houseArea;
    }
}
