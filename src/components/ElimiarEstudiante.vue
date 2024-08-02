<template>
  
  <div>
    <h1>ElimiarEstudiante</h1>
    <p type="Cedula"><input type="text" v-model="cedula"></p>
    <button v-on:click="borrar">Eliminar</button>
    <p v-if="mensaje">{{ mensaje }}</p>

  </div>
</template>

<script>
import {eliminarPorCedulaFachada} from '../clients/clienteEstudiante.js'
export default {
    data(){
        return{
            cedula:"",
            mensaje:""
        }
    },
    methods:{
        async borrar(){
            const data=await eliminarPorCedulaFachada(this.cedula);
            console.log("Estudiante eliminado con exito");
            this.mensaje="Estdudiante eliminado con exito";
        }
    }
}
</script>

<style>

</style>