package org.startup.api.db

import org.startup.api.model.Suite
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
class CardCopy (
    @Id
    var id: String? = null,

    @Min(1)
    @Max(15)
    var value : Int? = null,

    var suite : Suite? = null
)