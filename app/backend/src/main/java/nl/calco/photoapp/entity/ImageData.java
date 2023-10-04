package nl.calco.photoapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "image_data")
public class ImageData {

    @Id
    @Column(name = "order_definition_id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "type")
    private String type;

    @NonNull
    @Lob
    @Column(name = "image", length = 10000)
    private byte[] image;

    @OneToOne
    @MapsId
    @JoinColumn(name = "order_definition_id")
    private OrderDefinition orderDefinition;
}