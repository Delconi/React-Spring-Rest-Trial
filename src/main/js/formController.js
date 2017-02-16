import React from 'react';
import ReactDOM from 'react-dom';
import Client from './client';
import Page from './page';

export default React.createClass({
	getInitialState: function() {
		return {
			forms: [],
			data: []
		}
	},
	
	//Default On Change Function
	handleChange(event){
		console.log("ChangeHandler target ID: "+event.target.id);
		console.log("ChangeHandler target value : "+event.target.value);
		
		var stateCopy = Object.assign({}, this.state);
		var key = event.target.id;
		stateCopy.data[key] = event.target.value;

		this.setState(stateCopy);
		console.log("After Updating State: ",this.state.data)
	},
	
	componentDidMount() {
		Client({method: 'GET', path: '/api/forms'}).done(response => {
			this.setState({
				forms:response.entity._embedded.forms
			});
			console.log("Fetching from: /api/forms?projection=fp")
			console.log("Forms Data : ", this.state.forms);
		});
	},
	
	render() {	
		var _that = this;
		return <div>
			{
				this.state.forms.map(
					function(form,i){
						return(
							<div key={i}>
								<div className="well" >
									<h1>Form Name: {form.name}</h1>
								</div>
								{
									form.pages.map(
										function(page,j){
											return(
												<Page pageDom={page} key={j} onChange={_that.handleChange}/>
											)
										}
									)
								}
							</div>
						)
					}
				)
			}
		</div>
	}
})