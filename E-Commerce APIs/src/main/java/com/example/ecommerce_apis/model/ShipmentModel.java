package com.example.ecommerce_apis.model;

import com.example.ecommerce_apis.entity.Order;
import com.example.ecommerce_apis.entity.Shipment;
import com.example.ecommerce_apis.entity.ShipmentStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentModel {
    private Long id;
//    private Date shippingDate;
    private ShipmentStatus shipmentStatus;
    private Order order;

    public static ShipmentModel toModel(Shipment shipment)
    {
        return ShipmentModel.builder()
                .id(shipment.getId())
                .shipmentStatus(shipment.getShipmentStatus())
                .order(shipment.getOrder())
                .build();
    }
}
