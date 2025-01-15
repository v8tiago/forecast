package dti.infra.entrypoint.api;

import dti.infra.entrypoint.dto.enterprise.EnterpriseDto;
import dti.infra.entrypoint.dto.enterprise.EnterpriseRequestDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface EnterpriseApi {

    @Tag(name = "Enterprise", description = "Operações relacionadas as enterprises")
    @Operation(
            operationId = "getEnterprise",
            summary = "Obter informações de uma enterprise",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalhes da enterprise", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Enterprise não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            parameters = {
                    @Parameter(name = "id", description = "ID da Enterprise", required = true)
            }
    )
    @Get(uri = "/enterprise/{id}")
    @Produces()
    HttpResponse<EnterpriseDto> getEnterprise(@PathVariable(value = "id") @NotNull Integer id);

    @Tag(name = "Enterprise", description = "Operações relacionadas a enterprises")
    @Operation(
            operationId = "getAllEnterprise",
            summary = "Obter informações de todas as enterprises",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de enterprises", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Enterprises não encontradas"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            parameters = {
                    @Parameter(name = "name", description = "Nome da Enterprise")
            }
    )
    @Get(uri = "/enterprise")
    @Produces()
    HttpResponse<List<EnterpriseDto>> getAllEnterprises(@Nullable @QueryValue(value = "name", defaultValue = "") String name);


    @Tag(name = "Enterprise", description = "Operações relacionadas as enterprises")
    @Operation(
            operationId = "insertEnterprise",
            summary = "Inserir uma nova enterprise",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Enterprise criada com sucesso", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @Post(uri = "/enterprise")
    @Produces()
    @Consumes()
    HttpResponse<EnterpriseDto> insertEnterprise(@Body @RequestBody(description = "Nome da Enterprise",
            required = true, content = @Content
            (schema = @Schema(implementation = EnterpriseRequestDto.class)))
                                                 @Valid EnterpriseRequestDto enterpriseRequestDto);


    @Tag(name = "Enterprise", description = "Operações relacionadas as enterprises")
    @Operation(
            operationId = "updateEnterprise",
            summary = "Atualizar uma enterprise existente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Enterprise atualizada com sucesso", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
                    @ApiResponse(responseCode = "404", description = "Enterprise não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @Put(uri = "/enterprise/{id}")
    @Produces()
    @Consumes()
    HttpResponse<EnterpriseDto> updateEnterprise(@PathVariable(value = "id") @NotNull Integer id,
                                                 @Body @RequestBody(description = "Novo nome da Enterprise",
                                                         required = true, content =
                                                 @Content(schema = @Schema(implementation = EnterpriseRequestDto.class)))
                                                 @Valid EnterpriseRequestDto enterpriseRequestDto);

}
