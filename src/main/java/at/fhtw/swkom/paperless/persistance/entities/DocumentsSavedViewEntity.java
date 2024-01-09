package at.fhtw.swkom.paperless.persistance.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents_savedview")
public class DocumentsSavedViewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "show_on_dashboard", nullable = false)
    private Boolean showOnDashboard;

    @Column(name = "show_in_sidebar", nullable = false)
    private Boolean showInSidebar;

    @Column(name = "sort_field", length = 128)
    private String sortField;

    @Column(name = "sort_reverse", nullable = false)
    private Boolean sortReverse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;

    @OneToMany(mappedBy = "savedView")
    private Set<DocumentsSavedViewFilterRuleEntity> savedViewSavedViewFilterRules;
}

