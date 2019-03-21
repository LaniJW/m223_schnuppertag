# m223_schnuppertag

## getAll

MapType: GET
RespnseEntity: List of Entities

## getById

MapType: GET
PathVariable: Long id
RespnseEntity: Entity

## create

MapType: POST
RequestBody: {
                "[Variable]": "[Input]",
                "[Variable2]": "[Input2]"
            }
RespnseEntity: new Entity

## deleteById

MapType: DELETE
PathVariable: Long id
RespnseEntity: old Entity

## updateById

MapType: PUT
PathVariable: Long id
RequestBody: {
                "[Variable]": "[Input]",
                "[Variable2]": "[Input2]"
            }
RespnseEntity: updatet Entity