<template>
  <div class="container">
    <!--     <h1>ESTUDIANTES PAGE</h1>
 -->
    <InsertarEstudiante />
    <ConsultarActualizarEstudiante/>
    <ElimiarEstudiante/>
  </div>
</template>

<script>
import InsertarEstudiante from "../components/InsertarEstudiante.vue";
import ConsultarActualizarEstudiante from "../components/ConsultarActualizarEstudiante.vue"
import ElimiarEstudiante from "../components/ElimiarEstudiante.vue"
export default {
  components: {
    InsertarEstudiante,
    ConsultarActualizarEstudiante,
    ElimiarEstudiante
  },
};
</script>

<style>
</style>