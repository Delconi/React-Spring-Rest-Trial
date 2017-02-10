import React from 'react';
import ReactDOM from 'react-dom';
import Client from './client';

export default React.createClass({
	getInitialState: function() {
		return {
			textFields: []
		}
	},
	
	componentDidMount() {
		Client({method: 'GET', path: this.props.textFieldLink}).done(response => {
			this.setState({
				textFields:response.entity._embedded.textFields
			});
			console.log("Fetching from: ",this.props.textFieldLink);
			console.log("JSON TextFields Data: ", response);
		});
	},
	
	render() {	
		var _that = this;
		return <div>
				{
					this.state.textFields.map(function(item,i){
						return(
							<div key={i}>
								<label className="col-form-label">{item.value}:</label>
								<input className="form-control" type='text' id={item.name} onChange={_that.props.onChange}/>
								<br />
							</div>
						)
					})
				}
		</div>
	}
})