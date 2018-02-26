import React from "react";


export default class Update extends React.Component {

	constructor(props) {
		super(props)
		this.state = { dni: props.id }
	 	console.log(this.state)
    }
    
    update(event){
    	console.log(this.state.dni)
        fetch('/api/v1/actor/update/?dni='+this.state.dni)
    }

  render() {
		
		return (
				<button onClick={this.update.bind(this)}>
					Cambiar Nombre
				</button>
			)
  }
}