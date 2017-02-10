import React from 'react';
import ReactDOM from 'react-dom';
import TextFields from './textfields';
import Client from './client';

export default React.createClass({
	getInitialState: function() {
		return {
			groups: []
		}
	},
	
	componentDidMount() {
		Client({method: 'GET', path: this.props.groupLink}).done(response => {
			this.setState({
				groups:response.entity._embedded.formGroups
			});
			console.log("Fetching from: ",this.props.groupLink);
			console.log("JSON Group Data: ", response);
		});
	},
	
	render() {	
		var _that = this;
		return <div>
				{
					this.state.groups.map(function(item,i){
						return(
							<div key={i} className="well">
								<p>{item.label}</p>
								<hr />
								<TextFields textFieldLink={item._links.textFields.href} onChange={_that.props.onChange}/>
							</div>
						)
					})
				}
		</div>
	}
})