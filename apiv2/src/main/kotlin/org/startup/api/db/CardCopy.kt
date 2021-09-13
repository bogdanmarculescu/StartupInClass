package org.startup.api.db

import org.startup.api.model.Suite
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "card_sample")
class CardCopy (
    @Id
    var id: String? = null,

    @Min(1)
    @Max(15)
    var value : Int? = null,

    @get:NotBlank
    var suite : Suite? = null
)