package com.example.ecommerce_apis.entity;

import com.example.ecommerce_apis.model.ShipmentModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Date shippingDate;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus shipmentStatus;
    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName = "id")
    private Order order;

    public static Shipment toEntity(ShipmentModel shipmentModel)
    {
        return Shipment.builder()
                .id(shipmentModel.getId())
                .shipmentStatus(shipmentModel.getShipmentStatus())
                .order(shipmentModel.getOrder())
                .build();
    }
}
